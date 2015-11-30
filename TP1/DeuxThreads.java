public class DeuxThreads extends Thread {

public void run(){
	for (int i=0; i<10; i++){
		System.out.println("nouveau thread : " +this.getName());
		
	}
}

public static void main (String[] args){
	DeuxThreads th = new DeuxThreads();  
	th.setName("Thread  fils");  
	th.start();
	Thread.currentThread().setName("Thread  père");
	for (int i=0; i<10; i++){
		System.out.println("Main thread : " +currentThread().getName());
		System.out.flush();
		//Thread.currentThread().yield();
		try{
		   Thread.currentThread().sleep(100);
		}catch(Exception e){
		   e.getMessage();
		}
	}
	}
}
