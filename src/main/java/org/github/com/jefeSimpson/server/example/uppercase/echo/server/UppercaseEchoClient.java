package org.github.com.jefeSimpson.server.example.uppercase.echo.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class UppercaseEchoClient {
    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket("127.0.0.1", 9090)) {

            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("Hello!");

            InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
            Scanner scanner = new Scanner(inputStreamReader);
            System.out.println(scanner.nextLine().toUpperCase());
        }
    }
}
