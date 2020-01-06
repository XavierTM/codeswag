package chatexample;

import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); // object to take input from the keyboard
        int port;

        // prompting the user to enter a port number, storing the number in the variable port
        System.out.print("Enter port number: ");
        port = scan.nextInt(); 

        try {
            ServerSocket server = new ServerSocket(port); // binding the server socket to a port provided by the user
            System.out.println("Waiting for the other user...");
            Socket socket = server.accept(); // listening for a connection

            System.out.println("The other user is now online..");

            // instantiating the thread objects.
            OutgoingThread out = new OutgoingThread(socket.getOutputStream());
            IncomingThread inc = new IncomingThread(socket.getInputStream());

            // starting the threads
            inc.start();
            out.start();

        } catch(Exception e) {
            System.err.println(e.getMessage());
        }

    }
	}
