import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMultiThread{

	public static void main(String[] args){
	int port=4010;	
	ServerSocket se=null;
	Socket ssv=null;
	PrintWriter out;
	BufferedReader in;

	try{
		se = new ServerSocket(port); //ouverture de la socket d'écoute
		System.out.println("Le serveur est pret ");
		
	
		while (true) //attend qu il y ait plusieurs clients
		{
			ssv = se.accept();
			System.out.println("connexion accepté ");
			ThreadClient TC= new ThreadClient(ssv);
		}
	}
	catch (IOException e){
		System.err.println("Erreur! : " +e);
	}

	finally{
		try{
			se.close();
		}
		catch (IOException e){}
		}
	}
}

