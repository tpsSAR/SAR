
public class ClientIRC extends Thread{
	static int port=...;
	static InetAddress hote=...;
	Socket sc=...;
	BufferedReader in; 
	PrintWriter out;
	String nom;
	int compteur=0;
	public ClientIRC(String nom){
	...
	}
	public void run(){
		try{
			sc =...
			in =...
			out =...
			String rep; 
			String req;
			//envoyer le pseudonyme au serveur
			//recevoir le message d'accueil du serveur
			for(int i = 0; i < 10; i++) {
				//recevoir un message du serveur
				//incrementer le nb d'echanges
				//repondre au serveur
				//faire une pause de 3sec
			}
			//recevoir un message du serveur
			//faire une pause de 2sec
			//envoyer un message «Bye» au serveur
		}
		catch(IOException e){
			Sy
			stem.err.println("Impossible 
			cree
			socket du client : " +e);
		}
		finally{
			try{
				sc.close();
				in.close();
				out.close();
			}
			catch (IOException e){}
		}
	}

	public static void main (String[] args){
		try{
			if (args.length>=2){
			... 
			}
			else{
			...
			}
		}
		catch(UnknownHostException e){
			System.err.println("Machine inconnue :" +e);
		}
		ClientIRC client=...
		}
}
