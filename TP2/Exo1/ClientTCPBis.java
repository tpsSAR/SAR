import java.net.*;
import java.io.*;

public class ClientTCPBis{
	public static void main (String[] args){
		int port = 4020;
		InetAddress hote = null;
		Socket sc = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try{
			if (args.length >= 2){
				hote = InetAddress.getByName(args[0]);
				port = Integer.parseInt(args[1]);
			}
			else{
				hote = InetAddress.getLocalHost();
			}
		}
		catch(UnknownHostException e){
			System.err.println("Machine inconnue :" +e);
		}

		try{
			sc = new Socket(hote, port);
			in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			out = new PrintWriter(sc.getOutputStream(), true);
			
			String str = "Bonjour";
			System.out.println("je dis au serveur " +str);
			out.println(str);
			String rep;
			rep = in.readLine();
			System.out.println("Le serveur me repond " +rep);

		}
		catch(IOException e){
			System.err.println("Impossible de creer la socket du client : " +e);
		}
		finally{
		try{
			out.close();
			in.close();
			sc.close();
		}
		catch (IOException e){}
		}
	}
}
