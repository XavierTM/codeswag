package chatexample;

import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        String host;
        int port;
        Scanner scan = new Scanner(System.in);

        // prompting the user to enter the host name
        System.out.print("Enter server host name: ");
        host = scan.next();

        // prompting the user to enter the port number
        System.out.print("Enter server port: ");
        port = scan.nextInt();

        System.out.println("Finding the other user...");

        try  {

            Socket socket = new Socket(host, port); // connecting to the server
            System.out.println("The other user is available...");

            // constructing the thread objects
            IncomingThread inc = new IncomingThread(socket.getInputStream());
            OutgoingThread out = new OutgoingThread(socket.getOutputStream());

            // starting the threads
            inc.start();
            out.start();

        } catch (Exception e) {
            System.err.println("Error occured: " + e.getMessage());
            System.exit(1);
        }
    } 
}
