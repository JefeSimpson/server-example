package org.github.com.jefeSimpson.server.example.time.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(9090)){
            while(true){
                try(Socket client = serverSocket.accept()){
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    writer.println("Time now is " + ZonedDateTime.now());
                }
            }
        }
    }
}
