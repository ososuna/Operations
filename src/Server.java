
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Operations {
    
    private static int PORT = 3032; 

    public Server() throws RemoteException { }
    public static void main(String[] args) throws Exception {
        (new Server()).startServer();
        
    }

    public void startServer() {
        try {
            String dirIp = (InetAddress.getLocalHost()).toString();
            System.out.println("Listening in port " + dirIp + ":" + PORT);
            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.bind("server", (Operations) this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int add(int n1, int n2) throws RemoteException {
        return n1 + n2;
    }
    

    public int square(int n) throws RemoteException {
        return n * n;
    }
    

    public double power(double n1, double n2) throws RemoteException {
        return Math.pow(n1, n2);
    }
}       
   