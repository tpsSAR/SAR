public class Compteur extends Thread {

	public void run(){
		for (int i=0; i<10; i++){
			try{
				sleep((int)(Math.random() * 5000));
			}
			catch(Exception e){
				System.out.println("error");
			}
			System.out.println(this.getName()+" :" + (i+1));
		}
		System.out.println(this.getName()+" a fini de compter"); 
	}

	public static void main (String[] args){

		int n = Integer.parseInt(args[0]);
		Compteur[] cpt=new Compteur[n];
		for(int i=0;i<n;i++){
			cpt[i]=new Compteur();
			cpt[i].setName("Thread "+i);
			cpt[i].start();
		}
		currentThread().setName("Pere");
		
		//Début question 2
		for(int i=0;i<n;i++){
			try{
			  cpt[i].join();
			}catch(Exception e){}
		}
		System.out.println("Main thread :" +currentThread().getName());
		System.out.flush();
		System.out.println("Main FINISH");
	}

}




 
