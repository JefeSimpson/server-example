package org.github.com.jefeSimpson.server.example.echo.server;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(9090)){
            while(true){
                try(Socket client = serverSocket.accept()){
                    InputStreamReader inputeStreamReader = new InputStreamReader(client.getInputStream());
                    Scanner scanner = new Scanner(inputeStreamReader);
                    String a = scanner.nextLine();
                    System.out.println(a);

                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    writer.println(a);
                }
            }
        }
    }
}
