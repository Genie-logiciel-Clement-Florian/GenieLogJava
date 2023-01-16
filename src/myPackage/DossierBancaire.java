package myPackage;

public class DossierBancaire {

	private Courant courant;

	public DossierBancaire() {
		courant = new Courant(0);
	}
	
	public void deposer(double value)
    {
    	courant.setSolde(value);
    }

	public double getSolde() {
		return courant.getSolde();
	}

	public void remunerer() {
	}
}
