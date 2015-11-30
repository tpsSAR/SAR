public class ServeurTCP{
	public static void main(String[] args){
		int port=...;
		ServerSocket se;
		Socket ssv=null;
		PrintWriter out;
		BufferedReader in;
		try{
			se = …
			ssv = …
			in = …
			out = …
			…
		}
		catch (IOException e){
			System.err.println("Erreur : " +e);
		}
		finally{
		try{
			ssv.close();
		}
		catch (IOException e){}
		}
	}
}