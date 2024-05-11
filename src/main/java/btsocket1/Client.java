/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btsocket1;

/**
 *
 * @author TAN TAI
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String number;
            while ((number = serverReader.readLine()) != null) {
                System.out.println("Received number: " + number);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
