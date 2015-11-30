import java.net.*;
import java.io.*;

public class ClientMultiThread{
	int port = 4020;
	InetAddress hote = null;
	Socket sc = null;
	String nom;
		
	public ClientMultiThread(String nom){
		this.nom = nom;
		start();
	}

	public String getNom(){
		return nom;
	}
	public void run(){
		try{
			int cpt = 0;
			sc = new Socket(hote, port);
			sysout("Le client avec "+hote+" et "+port" a réussi");
			in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			out = new PrintWriter(sc.getOutputStream(), true);

				String req;
				String response; 
				for(int i=0;i<10; i++){
					req = in.readLine();
					System.out.println("Le serveur me dit "+req);
					cpt++;
					response = "Je suis le client"+getNom()+"et j'ai fait"+cpt+"appels";
					Sysytem.out.println("Je dit au serveur"+response);
					out.println(response);
					
					try{
						slepp(2000);
					}
					catch(IOException e){
			
					}


		}catch(IOException e){
			e.getMessage();
		}	
	}

	public static void main (String[] args){

		ClientMultiThread client1 = new ClientMultiThread("toto");
		ClientMultiThread client2 = new ClientMultiThread("pathe");
	}
}
