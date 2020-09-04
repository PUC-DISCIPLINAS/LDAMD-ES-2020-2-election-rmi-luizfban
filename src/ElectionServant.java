import java.math.BigInteger;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Vector;

public class ElectionServant implements Election {

	private Vector<String> candidateList;
	private Vector<String> hashList;
	
	public ElectionServant() throws RemoteException {
		candidateList = new Vector<String>();
	}
	
	@Override
	public Vector<String> Vote(String nameCandidate, String electorName) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("METODO VOTE");
		String hashMD5 = getHashMD5(electorName);
		if(hashList.contains(hashMD5)) {
			
		}else {	
			hashList.addElement(hashMD5);
			candidateList.addElement(nameCandidate);	
			return candidateList;
		}
		return null;
	}

	@Override
	public int Result(String nameCandidate) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("METODO RESULT");
		int numVotes = Collections.frequency(candidateList, nameCandidate);
		return numVotes;
	}
	
	private String getHashMD5(String name){
		System.out.println("HASH");
		String nomeEleitor = name;
		String hashMd5 = null;

	      try {
	         // Gera o hash MD5 baseado no nome do eleitor
	         MessageDigest md = MessageDigest.getInstance("MD5");
	         md.update(nomeEleitor.getBytes());
	         byte[] md5 = md.digest();

	         // Formata em Hexadecimal minúsculo para exibir na tela
	         BigInteger numMd5 = new BigInteger(1, md5);
	         hashMd5 = String.format("%022x", numMd5); 
	               
	         System.out.println("Nome: " + nomeEleitor + "\nMD5: " + hashMd5);
	      } catch (NoSuchAlgorithmException e) {
	         throw new RuntimeException(e);
	      }
		
		return hashMd5;
	}
	

}
