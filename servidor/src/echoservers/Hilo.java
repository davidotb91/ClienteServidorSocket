/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoservers;

import java.io.*;
import java.net.*;
import java.lang.Thread;

public class Hilo extends Thread {

    long threadID;
    Socket client;

    Hilo(Socket client) {
        this.client = client;
    }

    public void run() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //BufferedReader readerID = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            //writer.println("[Escribe 'topez' para cerrar la conexion]");
            threadID = currentThread().getId();
            while (true) {
                String line = reader.readLine();
                if (line.trim().equals("escape")) {
                    writer.println("Adios");
                    break;
                }
               
                
                System.out.println(threadID + ": " + line);
                writer.println(threadID + " " + line);
          
            }
        } catch (Exception e) {
            System.err.println("Exception caught: client disconnected.");
        } finally {
            try {
                client.close();
            } catch (Exception e) {System.out.println("ERROR EN LA LECTURA");
            }
        }
    }
}
