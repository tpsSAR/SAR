
public class Compte {
	private int solde=0; 
   
	public void ajouter(int somme){
		solde=solde+somme;
		System.out.println(" ajout de " +somme);
	} 
   
	public void retirer (int somme){
		solde=solde-somme;
		System.out.println(" retrait de " +somme);
	}   
 
	public synchronized void operationNulle (int somme){
		solde=solde+somme;
		System.out.print(" ajout de " +somme +",");
		solde=solde-somme;
		System.out.print("et retrait de " +somme +".");
		System.out.println();
	}
	public synchronized int getSolde(){
		return solde;
	}
}






















// Le probleme : il ya deux process 
// op1 et ep2, chacun d'entre eux fait opnulle
// op1 peut juste faire +7 euro et passe la main
// car synchronized n'est pas atomique
// pour resoudre le probleme : syncronized les methodes
// opnulle et getSolde
