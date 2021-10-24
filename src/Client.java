
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    
    public static void main(String[] args) {
        
        Operations server;
        String serverAddress = "localhost";
        int serverPort = 3032;

        try {
            Registry registry = LocateRegistry.getRegistry(serverAddress, serverPort);
            server = (Operations) (registry.lookup("server"));
            int add = server.add(2, 2);
            int square = server.square(5);
            double power = server.power(3, 3);
            System.out.println("Add = " + add);
            System.out.println("Square = " + square);
            System.out.println("Power = " + power);
        } catch (Exception e) {
            e.printStackTrace();
        }        

    }

}