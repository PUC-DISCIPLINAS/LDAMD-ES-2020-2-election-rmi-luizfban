import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface Election extends Remote {
	Vector<String>  Vote(String nameCandidate, String hashMD5 ) throws RemoteException;
	int Result(String nameCandidate) throws RemoteException;
}
