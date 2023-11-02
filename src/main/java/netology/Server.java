package netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer port = 7777;

    public static void main(String[] args)  throws IOException {


       try(ServerSocket serverSocket = new ServerSocket(port)) {
           System.out.println("Server Start!");
           while (true) {
               try (Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    ) {
                 final   String name = in.readLine();
                   System.out.println("New connection accepted");
                   out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
               }

           }

       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       }
}



