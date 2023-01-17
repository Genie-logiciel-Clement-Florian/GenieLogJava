package tests;

import static org.junit.Assert.*;

import myPackage.Courant;
import myPackage.DossierBancaire;
import myPackage.Epargne;

import org.junit.Test;

public class TestsDossierBancaire {

	@Test
	public void test_constructeur() {
		DossierBancaire dossier = new DossierBancaire();
		assertEquals(0, dossier.getSolde(), 0);

		Courant courant = new Courant(0);
		assertEquals(0, courant.getSolde(), 0);

		Epargne epargne = new Epargne(0);
		assertEquals(0, epargne.getSolde(), 0);

		assertEquals(dossier.getSolde(), courant.getSolde(), 0);
		assertEquals(dossier.getSolde(), epargne.getSolde(), 0);
		assertEquals(0, dossier.getSolde() + courant.getSolde() + epargne.getSolde(), 0);
	}

	@Test
	public void test_deposer() {
		DossierBancaire dossier = new DossierBancaire();
		Courant courant = new Courant(0);
		Epargne epargne = new Epargne(0);

		dossier.deposer(100);

		assertEquals(100, dossier.getSolde(), 0);
		assertEquals(40, courant.getSolde(), 0);
		assertEquals(60, epargne.getSolde(), 0);

		assertEquals(dossier.getSolde(), courant.getSolde() + epargne.getSolde(), 0);
	}

	@Test
	public void test_remunerer() {
		DossierBancaire dossier = new DossierBancaire();
		Courant courant = new Courant(0);
		Epargne epargne = new Epargne(0);

		dossier.deposer(100);
		dossier.remunerer();

		assertEquals(102.04, dossier.getSolde(), 0.01);
		assertEquals(40, courant.getSolde(), 0.01);
		assertEquals(62.04, epargne.getSolde(), 0.01);

		assertEquals(dossier.getSolde(), courant.getSolde() + epargne.getSolde(), 0.01);
	}

	@Test(expected = Exception.class)
	public void test_retirer() throws Exception {
		DossierBancaire dossier = new DossierBancaire();
		dossier.retirer(10);
	}

}
