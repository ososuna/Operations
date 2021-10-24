
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Operations extends Remote {
    
    public int add(int n1, int n2)
        throws RemoteException;    
    
    public int square(int n)
        throws RemoteException;    
    
    public double power(double n1, double n2)
        throws RemoteException;    

}
