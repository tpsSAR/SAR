import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadClient extends Thread{
	
	Socket s=null;
	BufferedReader in;
	PrintWriter out;

	ThreadClient(Socket s) throws IOException{
		this.s=s;
		start();
	}

	//get nom du client

	public void run(){			
		try {
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				out=new PrintWriter(s.getOutputStream(),true);

				String rep;
				String req;

				rep = "bienvenu";
				System.out.println("je dis au client"+rep);
				out.println(rep);
	
				while(true){
					req=in.readLine();
					if (req.equals("Bye"))  break;
					System.out.println("le client me dit"+req);
					try{
						sleep(1000);
					}catch (InterruptedException e) {}
					rep ="cc"; 
					System.out.println("je dis au client" +rep);
					out.println(rep);
				}
				System.out.println("fin de communication");		
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
				try{
					s.close();
				}
				catch (IOException e){}
		}
		
	}
			
}
