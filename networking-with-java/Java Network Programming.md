## Java Network Programming
_Network programming_ refers to the writing of programs that runs across different devices. The devices need to be connected via a certain _network_.
A _network_ is just an interconnection of two or more devices.  
Networking has many advantages:  
 * It allows communication between users and the sharing of information without the need to be physically together.  
 * It allows the sharing of resources hence saving costs. For example, in a company, all computers can be connected to a printer via a network so that the company doesn't have to buy a printer for each office.  
 * It allows the operation of machines remotely. This can be very useful especially when you can't physically be where the machine is, like in a hazardous environment. Or just for convenience like the [Internet of Things](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=28&cad=rja&uact=8&ved=2ahUKEwjhjrbPm-rmAhUSUxUIHUdbCB0QmhMwG3oECA0QAg&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FInternet_of_things&usg=AOvVaw25VoDIzJabaX0WmCLYIOtX) in homes, which allows you to control home appliances from wherever you are.

Let us define some networking terminology:  
  * **Protocol**: a set of conventional rules or procedures followed when two devices are communicating. Protocols are there to make sure that devices interpret the information the same way.  
  * **Socket**: one endpoint of a two-way communication link between two programs running on the network. It is uniquely identified by a combination of the machine's IP address and the program's port number.  
  * **Port number**: a number(integer) that uniquely identifies a socket on a machine.  
  * **IP address**: Internet Protocol address, a string that uniquely identifies a computer on a network.

### The java.net package
The **java.net package** is a collection of interfaces and classes that allows a programmer to develop networking applications using Java. It supports two protocols, _Transmission Control Protocol(TCP)_ and _User Datagram Protocol(UDP)_.  
The main difference between TCP and UDP is that TCP connection-oriented, whilst UDP is connectionless. This means that TCP establishes a connection with the receiver first before it sents data, while UDP will just send the data and assumes the receiver is listening. TCP is more reliable since data is guaranteed to be delivered. If the receiver does not confirm data delivery, TCP will try to send the data again. On the other hand, UDP transfers data faster, since it does not have to settle anything with anyone before it transmits.  
UDP is usually used in applications where the receiver is guaranteed to be listening, e.g communication between applications on the same machine, whilst TCP is used in applications where there's no such guarantee, like over the Internet.  

### Socket programming in Java
_Socket programming_ is the writing of programs that communicate via TCP. The other socket acts as a server and the other acts as a client. To allow for communication using socket programming, the following steps are carried out:  

 1. The server socket starts _listening_ for a connection on a certain port number. Listening is just the action by the server to be ready for a client to connect.  The port number may be arbitrary, as long as it is not being used by another program. [Standard port numbers](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=4&cad=rja&uact=8&ved=2ahUKEwiEzdKesermAhVZRBUIHXjHC10QFjADegQIAxAB&url=https%3A%2F%2Fwww.webopedia.com%2Fquick_ref%2Fportnumbers.asp&usg=AOvVaw1Ywega6ANdPeCl1gdoG4te) exist though.
 2. The client socket tries to connect to the port number of the server socket. The client has to know both the port number and the IP address or hostname of the server.
 3. The server socket accepts the connection of the client. The two sockets are now ready to communicate whatever data they want to.
 4. When there is no more data to transmit between the programs, the sockets can close the connection.

#### ServerSocket class
This class is part of the _java.net_ package. It is used by server applications to obtain a port and listen for client requests. It has four constructors:  
**public ServerSocket() throws IOException**  
This constructor creates a socket object which is not bounded to any port number. The port number can be bound later using the _bind()_ method.

**public ServerSocket(int port) throws IOException**  
This constructor creates a socket and binds it to the port number provided in the argument. Throws an exception when the provided port number is being used by another process.

**public ServerSocket(int port, int backlog) throws IOException**  
Similar to the above constructor, except that it limits the number of connections in the waiting queue to the number specified by the backlog argument.

**public ServerSocket(int port, int backlog, InetAddress address) throws IOException**  
Similar to the constructor above. Here, the address argument specifies the IP address the socket is listening to. This constructor is useful on machines that have two or more IP addresses.

**N.B**: If you pass the argument 0 for the port number, the server will find a free port for you. You can then find out which port the socket is bound to later using the _getLocalPort()_ method.

Here are some of the member methods of the ServerSocket class:  
**public int getLocalPort()**  
Returns the port number the socket is bound to.

**public Socket accept() throws IOException**
When this method is invoked, it starts listening for a connection. This method does not return until a connection is made or the socket times out(if there is a value previously specified by the _setSoTimeout()_ member method). It returns a Socket object.

**public void bind(SocketAddress host, int backlog)**  
This method binds the socket to the server and port specified by the host argument.

**public void setSoTimeout(int timeout)** 
The argument specifies the amount of time(seconds) the server socket has to wait for the client to connect before it stops listening. 


#### Socket class
This class provides a blueprint to create sockets that  both clients and servers use to communicate with each other. The client obtains a Socket object by instantiating one, while the server obtains it when the accepts method returns after a connection.

The Socket class has five constructors: 
**public Socket()**  
This constructor creates an unconnected socket. The _connect()_ method can be used later to connect to a server.
 
**public Socket(String host, int port) throws UnknownHostException, IOException**  
This method tries to connect to the server specified by the host argument at a port number specified by the port argument.

**public Socket(InetAddress host, int port) throws IOException**
Similar to the above constructor, just that the host here is specified by an InetAddress object.

**public Socket(String host, int port, InetAddress localAddress, int localPort) throws IOException**  
Connects to the server specified by the host argument at a port specified by the port argument, creating a socket on the local host specified by the localAddress argument and on a port specified by the localPort argument.

**public Socket(InetAddress host, int port, InetAddress localAddress, int localPort) throws IOException**  
Similar to the above constructor except that the host here is specified by an InetAddress object.

Here we're going to specify Socket class member methods of interest:  
**public void connect(SocketAddress host, int timeout) throws IOException**
This method is used to connect to a socket specified by the arguments. It is used when the Socket object is constructed using the no parameter constructor(the first constructor on the above list).

**public int getPort()**  
This returns the port number of the socket of the other machine.

**public InputStream getInputStream() throws IOException**
Returns the input stream of the socket.

**public OutputStream getOutputStream() throws IOException**  
Returns the output stream of the socket.

**public void close() throws IOException**
Closes the connection between the connected sockets.


### Chat Application Example
Now it's time for a little example. In this example, we're going to create a console-based application that allows two people to chat on a network. For simplicity's sake, one application will be the server and the other one will be the client.

Let's dive right into the code. Firstly, let's explain how our code will work. In a chat application, incoming messages are not predictable, and we need to print them as they come. We also need to be always prompting the user to type a message, but we know that when an application is waiting for the user to input something on a console, no code will be executed. What does this mean? This means we can't print incoming messages while we're waiting for the user to type messages. We can wait until the user inputs a message, then print the incoming message, but that makes a very horrible experience for our users. So what can we do? The answer is _multithreading_. We will create two threads on each of the applications, one to print incoming messages, and the other to wait for the user to enter a message. _Problem solved_. 

We will call the class for outgoing messages thread OutgoingThread, and the one for incoming messages IncomingThread. Below is the code for the IncomingThread class.

``` java
 
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

```


And here is the code for the OutgoingThread class:

``` java

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

```

The server code will prompt the user to enter the port number on which the server will be listening on. When the user enters okay, the code will instantiate a ServerSocket object with the entered port number, then listens to a connection. When the connection is made, the code will start two threads, one to print incoming messages and the other to prompt the user to type a message. Will will call the server class Server. Below is the code.

``` java

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


```

The client code will prompt the user to enter the hostname and the port number for the server. Then it will try to connect to the server. When the connection is made, the code will construct and start two threads as done by the server code. Now the chatting can begin. Here is the code for the Client class:

``` java


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


```

All you have to know is the hostname of the computer running the server application and the port chosen to be listened to. Below are the samples that were done on the same computer(hence the hostname *localhost*). Port 81 was chosen.

![Serversample output](https://codeswag.co.uk/wp-content/uploads/2020/01/Server-sample-screenshot.png)  
*Figure 1: Server output sample*

![Client sample output](https://codeswag.co.uk/wp-content/uploads/2020/01/Client-sample-screenshot-150x150.png)  
*Figure 2: Client output sample*

The link below is to the full documentation of the *java.net package*.  
[Read more](https://docs.oracle.com/javase/8/docs/api/java/net/package-frame.html)
