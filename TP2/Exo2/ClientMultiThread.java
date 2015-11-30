

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMultiThread extends Thread{

	static int port=4010;
	static InetAddress hote=null;

	Socket sc=null;
	BufferedReader in;
	PrintWriter out;

	String nom;

	ClientMultiThread (String s){
		nom=s;
		start();
	}

	public void run(){

		try{
			
			sc =new Socket(hote,port);
			System.out.println("socket creee");

			out = new PrintWriter(sc.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader( sc.getInputStream()));
			
			String rep;
			String req;

			for(int i=0; i<10; i++){ //question 2
				rep=in.readLine();
				System.out.println("Le  serveur me dit  "+rep);

				req=" Cooucou !";
				out.println(req);

				try{ sleep(2000);
				}
				catch(InterruptedException e){}		
			}
			req="Bye";
			System.out.println("je dis au serveur"+req);
			out.println(req); 
			
		}
		catch(IOException e){
			System.err.println("Impossible de creer la socket du client : " +e);
		}
		finally{

			try{
				sc.close();
			}
			catch (IOException e){}
		}
		
}

	public static void main (String[] args){
		
		try{
			if (args.length>=2){
				hote=InetAddress.getByName(args[0]);
				port=Integer.parseInt(args[1]);
			}
			else{
				hote = InetAddress.getLocalHost();
			}
		
		}catch(UnknownHostException e){
			System.err.println("Machine inconnue :" +e);
		}

		ClientMultiThread cl1=new ClientMultiThread("toto");
		ClientMultiThread cl2=new ClientMultiThread("toto 2");		
	}
}
