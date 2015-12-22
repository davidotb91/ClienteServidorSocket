package echoservers;

import java.io.*;
import java.net.*;
import java.lang.Thread;

public class Servidor {

    public static void main(String[] args) {
        Socket[] socketes;
        try {
            ServerSocket server = new ServerSocket(6666);
            while (true) {
                Socket cliente = server.accept();
                Hilo objetoHilo = new Hilo(cliente);
                objetoHilo.start();
            }
        } catch (Exception e) {
            System.err.println("Exception caught:" + e);
        }
    }
}