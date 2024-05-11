/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btsocket2;

/**
 *
 * @author TAN TAI
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your username: ");
            String username = userInputReader.readLine();
            serverWriter.println(username);
            String serverResponse = serverReader.readLine();
            System.out.println(serverResponse);
            Thread serverThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = serverReader.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverThread.start();
            String clientMessage;
            while ((clientMessage = userInputReader.readLine()) != null) {
                serverWriter.println(clientMessage);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
