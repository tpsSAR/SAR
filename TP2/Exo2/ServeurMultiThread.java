import java.net.*;
import java.io.*;

public class ServeurMultiThread implements Runnable{
		//int port = 4020;
		ServerSocket se = null;
		Socket ssv = null;
		private int nbrClient = 1;

		public ServeurMultiThread(ServerSocket se){
			this.se = se;
		}

			try{
				se= new ServerSocket(port);
				while(true){
					ssv = se.accept();
					System.out.println("Le client numéro "+nbrClient+" est connecté.");
					nbrClient++;
					ThreadClient tcli = new ThreadClient(ssv, nbrClient);
					
				}
			}catch(IOException e){
				e.getMessage();
			}finally{
				ssv.close();
			}
		
}
