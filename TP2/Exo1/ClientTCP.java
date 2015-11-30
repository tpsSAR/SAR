public class ClientTCP{
	public static void main (String[] args){
		int port=…;
		InetAddress hote=null;
		Socket sc=null;
		BufferedReader in;
		PrintWriter out;

		try{
			if (args.length>=2){
				hote=…
				port=…
			}
			else{
				hote = ….
			}
		}
		catch(UnknownHostException e){
			System.err.println("Machine inconnue :" +e);
		}
		try{
			sc = …
			in = …
			out = …
			…
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
}