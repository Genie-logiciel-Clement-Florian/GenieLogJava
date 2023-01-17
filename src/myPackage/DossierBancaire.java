package myPackage;

public class DossierBancaire {

	// On utilise l'interface Compte
	private Compte epargne;
	private Compte courant;

	// Constructeur, initialisation des différents comptes
	public DossierBancaire() {
		courant = new Courant(0);
		epargne = new Epargne(0);
	}

	// Dépôt de 40% d'une valeur sur le compte Courant et 60% sur le compte Epargne
	public void deposer(double value) {
		courant.setSolde(value * 0.4);
		epargne.setSolde(value * 0.6);
	}

	// Récupération et addition des soldes de tous les comptes
	public double getSolde() {
		return courant.getSolde() + epargne.getSolde();
	}

	// Rémunération du compte Epargne de 3.4%
	public void remunerer() {
		epargne.setSolde(epargne.getSolde() * 0.034);
	}
	
	public void retirer(double val) throws Exception
    {
    	if (courant.getSolde() < val)
    	    throw new Exception("Solde du compte courant insuffisant");
    	else courant.setSolde(-val);
    }
}
