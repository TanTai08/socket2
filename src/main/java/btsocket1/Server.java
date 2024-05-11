/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btsocket1;

/**
 *
 * @author TAN TAI
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is running and waiting for client connection...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream(), true);

                for (int i = 1; i <= 1000; i++) {
                    clientWriter.println(i);
                    Thread.sleep(1000);
                }
                clientSocket.close();
                System.out.println("Client disconnected.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
