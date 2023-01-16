package myPackage;

public class DossierBancaire {

	private Epargne epargne;
	private Courant courant;

	public DossierBancaire() {
		courant = new Courant(0);
		epargne = new Epargne(0);
	}

	// Dépôt de 40% du solde sur le compte Courant et 60% sur le compte Epargne
	public void deposer(double value) {
		courant.setSolde(value * 0.4);
		epargne.setSolde(value * 0.6);
	}

	public double getSolde() {
		return courant.getSolde() + epargne.getSolde();
	}

	public void remunerer() {
		epargne.setSolde(epargne.getSolde() * 0.034);
	}
}
