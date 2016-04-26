/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import Accounts.UserRepository;
import Carparks.CarParkRepo;
import Reservations.ReservationRepository;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jconn
 */
public class Server implements Runnable {

    private UserRepository usersDB;
    private CarParkRepo carparksDB;
    private ReservationRepository reservationsDB;

    private ArrayList<Client> Clients = new ArrayList<Client>();
    private DatagramSocket socket;
    private int port;
    private boolean running = false;
    private Thread run, clients, send, receive;

    public Server(int serverPort) throws SocketException {

        usersDB = new UserRepository();
        carparksDB = new CarParkRepo();
        reservationsDB = new ReservationRepository();
        port = serverPort;

        socket = new DatagramSocket(port);
        run = new Thread(this, "Server");
        System.out.println("Attempting to start Server on port " + port);
        run.start();
        if (running) {
            System.out.println("Server started successfully");
        }
    }

    public void run() {
        System.out.println("Server started on port: " + port);
        running = true;
        getClients();
        receive();

    }

    private void getClients() {
        clients = new Thread("Manage Clients") {
            public void run() {
                while (running) {

                }
            }
        };
    }

    private void receive() {
        receive = new Thread("receiving") {
            public void run() {
                while (running) {
                    byte[] data = new byte[1024];
                    DatagramPacket dataPacket = new DatagramPacket(data, data.length);
                    try {
                        socket.receive(dataPacket);
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    process(dataPacket);
                }
            }
        };
        receive.start();
    }

    private void process(DatagramPacket dataPacket) {
        String data = new String(dataPacket.getData()).trim();
        if (data.startsWith("/c/")) {
            login(dataPacket, data);
        } else if (data.startsWith("/nu/")) {
            String[] info = data.trim().split("/nu/");
            usersDB.newUser(Integer.parseInt(info[1]), info[2], info[3], info[4], info[5]);
        } else if (data.startsWith("/ncp/")) {
            String[] msg = data.split("/ncp/");
            carparksDB.newCarPark(carparksDB.getNextID(), msg[1], Integer.parseInt(msg[2]), Integer.parseInt(msg[3]), 0, 0);
        } else if (data.startsWith("/nrs/")) {
            System.out.println(data);
            String[] msg = data.split("/nrs/");
            int type = usersDB.checkType(Integer.parseInt(msg[1]));
            int cpID = carparksDB.lookUpIndex(Integer.parseInt(msg[2]));
            reservationsDB.newReservation(type, Integer.parseInt(msg[1]), cpID, msg[3]);
            System.out.println("added new reservation");
        } else if (data.startsWith("/ecp/")) {
            String[] msg = data.split("/ecp/");
            String plate = carparksDB.readPlateFromBarrier(Integer.parseInt(msg[2]));
            int u = usersDB.getUserWithLicensePlate(plate);
            if (u == -1) {
                carparksDB.addUserToCarPark(Integer.parseInt(msg[2]), -1);
            } else if (reservationsDB.getReservationsForUser(u).size() >= 0) {
                carparksDB.addUserToCarPark(Integer.parseInt(msg[2]), usersDB.checkType(u));
            }

        } else if (data.startsWith("/gcp/")) {
            System.out.println("Car parks requested");
            StringBuilder returnmsg = new StringBuilder();
            ArrayList<String> carparks = carparksDB.getCarParks();
            for (String aCarPark : carparks) {
                returnmsg.append("/ls/" + aCarPark);
            }
            send(returnmsg.toString(), dataPacket.getAddress(), dataPacket.getPort());
        }

    }

    private void send(String data, InetAddress clientAddress, int clientPort) {
        byte[] byteData = data.getBytes();
        send = new Thread("sending") {
            public void run() {
                DatagramPacket sendPacket = new DatagramPacket(byteData, byteData.length, clientAddress, clientPort);
                try {
                    socket.send(sendPacket);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        send.start();
    }

    public void login(DatagramPacket dataPacket, String data) {
        String[] info = data.split("/c/");
        int id = usersDB.logUserIn(info[1], info[2]);
        System.out.println(id);
        // int id = Integer.parseInt(data.split("/c/")[1].trim());
        if (id != -1) {
            Clients.add(new Client(dataPacket.getAddress(), dataPacket.getPort(), id));
        } else {
            System.out.println("Login not found");
        }
        String reply = "/c/" + id;
        send(reply, dataPacket.getAddress(), dataPacket.getPort());
    }

}
