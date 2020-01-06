package chatexample;
	
import java.util.Scanner;
import java.io.*;

public class OutgoingThread extends Thread{

    DataOutputStream outStream;

    // constructor
    public OutgoingThread(OutputStream outStream) {
        this.outStream = new DataOutputStream(outStream);
    }

    @Override
    public void run() {
        while (true) {
            String msg;
            Scanner scan = new Scanner(System.in); // instantiating the object that takes input from the keyboard
            //System.out.print("<< ");
            msg = scan.nextLine(); // prompting the user to enter a message
            try {
                /* writing the message to the output stream
                this outut stream will be connected to the other socket's inpus stream
                the end_of_line character is added so that the input stream on the other end will scan messages using readLine(), which terminates when it encounters the '\n' character*/
                outStream.writeUTF(msg + "\n");
            } catch (IOException ex) {
                ex.printStackTrace();
                System.exit(1);
            }
        }        
    }
}
