package chatexample;  
import java.io.*;

public class IncomingThread extends Thread{

    BufferedReader inStream; 

    public IncomingThread(InputStream inStream) {
        this.inStream = new BufferedReader(new InputStreamReader(inStream));
    }

    @Override
    public void run() {
        String msg;
        while (true) {
            try {
                if (inStream.ready()) { // testing to see if there is any message on the input stream
                    msg = inStream.readLine(); // reading the message
                    System.out.println(">> " + msg); // printing the message on the console
                }
            } catch(Exception e) {
                System.err.println(e.getMessage());
                System.exit(1);
            } 
        }
    }
}
