import java.net.*;
import java.io.*;
//je fais un test

public class ThreadClient{
	public static void main (String[] args){
		int port = 4020;
		InetAddress hote = null;
		ServerSocket se = null;
		Socket sc = null;
		PrintWriter out = null;
		BufferedReader in = null;
		//BufferedReader fluxInOut;
		String nom;
		public ThreadClient(Socket ssv, String nom){
		start();}

		try{			
			in = new BufferedReader(new InputStreamReader(se.getInputStream()));
			out = new PrintWriter(se.getOutputStream(), true);
			
			String req;
			String response; 
			response = "Un client est connecté "+getNom();
			System.out.println("Je dis "+response);
			
			while(true){
				response = in.readLine();
				if(response.equals("Bye")) break;
				try{
			
				}catch(IOException e){
			
				}
				req = "Cou";
				out.println(req);
				
			}

			
		}catch(IOException e){
			e.getMessage();
		}finally{
			try{
				in.close();
				out.close();
			}catch(){}
		}
		
	}
}
