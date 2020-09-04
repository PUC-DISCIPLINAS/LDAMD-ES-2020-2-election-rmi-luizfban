import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ElectionClient {

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		String name = "Sem nome";
		String candidate = "Nulo";

		System.out.println("argslen: " + args.length);
		if (args.length > 0)
			name = args[0]; // especifica o nome da pessoa
		if (args.length > 1)
			candidate = args[1];// especifica o candidato.


		System.out.println("Nome: " + name + " // Candidato: " + candidate);

		/*if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		} else
			System.out.println("Já possui um Security Manager.");
*/
		Election election = null;

		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			election = (Election) registry.lookup("Election");
			System.out.println("Election Encontrado.");

			election.Vote(candidate, name);
			System.out.println("Voto Realizado com Sucesso");
			System.out.println(candidate + " teve " + election.Result(candidate) + " votos." +election);
			
		} catch (RemoteException e) {
			System.out.println("Método erro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Lookup: " + e.getMessage());
		}

	}

}
