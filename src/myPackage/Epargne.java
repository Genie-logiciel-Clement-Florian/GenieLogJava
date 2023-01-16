package myPackage;

public class Epargne implements Compte {

	private double solde;

	public Epargne(double solde) {
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
