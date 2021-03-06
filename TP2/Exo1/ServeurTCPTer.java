import java.net.*;
import java.io.*;

public class ServeurTCPTer{
	public static void main(String[] args){
		int port = 4020;
		ServerSocket se = null;
		Socket ssv = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try{
			se = new ServerSocket(port);
			System.out.println("Le serveur est pret");
			System.out.println("Le serveur est à l'écoute du port " +port);
			ssv = se.accept();
			System.out.println("Un client est connecté !!!");
			//A partir de la, on crée les flux de communication
			in = new BufferedReader(new InputStreamReader(ssv.getInputStream()));
			out = new PrintWriter(ssv.getOutputStream(), true);
		
			while(true){
				String str = in.readLine();
				System.out.println("Le client me dit " +str);
				String response = in.readLine();
				System.out.println("je lui repond " +response);
				out.println(response);
				System.out.println("Fin de la communication");
			}
			
		}
		catch (IOException e){
			System.err.println("Erreur : " +e);
		}
		finally{
		try{
			out.close();
			in.close();
			ssv.close();
			se.close();
		}
		catch (IOException e){}
		}
	}
}
