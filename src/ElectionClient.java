import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Vector;

public class ElectionClient {

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		String name = "Sem nome";
		String candidate = "Nulo";
	//	String opcao = null;

		System.out.println("argslen: " + args.length);
		if (args.length > 0)
			name = args[0]; // especifica o nome da pessoa
		if (args.length > 1)
			candidate = args[1];// especifica o candidato.


		System.out.println("Nome = " + name + " Candidato = " + candidate);

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

			System.out.println("TESTE");
			Vector<String> votes= election.Vote(candidate, name);
			System.out.println("TESTE");
			//Vector<String> sList = election.Result();
			//System.out.println("Retornado o vetor de Election");
			
			//if (opcao.equals("ler")) {
			System.out.println(candidate + "teve: " + election.Result(candidate) + " votos");
				
//				for (int i = 0; i < sList.size(); i++) {
//					GraphicalObject g = ((Shape) sList.elementAt(i)).getAllState();
//					g.print();
//				}
		//	} else {
				System.out.println("TESTE");
				
				for (int i = 0; i < votes.size(); i++) {
					String s = votes.elementAt(i);
					System.out.println(s);
				}
		//	}
		} catch (RemoteException e) {
			System.out.println("Método allShapes: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Lookup: " + e.getMessage());
		}

	}

}
