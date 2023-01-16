package myPackage;

public class Courant implements Compte {

	private double solde;
	
	public Courant(double solde) {
		this.solde = solde;
	}
	
	@Override
	public double getSolde() {
		return solde;
	}

	@Override
	public void setSolde(double solde) {
		solde += solde;
	}

}
