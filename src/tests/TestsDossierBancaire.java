package tests;

import static org.junit.Assert.*;

import myPackage.Courant;
import myPackage.DossierBancaire;

import org.junit.Test;

//The Test annotation indicates that the public void method to which it is attached can be run as a test case.
public class TestsDossierBancaire {

	@Test
	public void test_constructeur() {
		DossierBancaire dossier = new DossierBancaire();
		assertEquals(0, dossier.getSolde(), 0);
		
		Courant courant = new Courant(0);
		assertEquals(0, courant.getSolde(), 0);
		
		assertEquals(dossier.getSolde(), courant.getSolde(), 0);
	}

	@Test
	public void test_deposer() {
		DossierBancaire dossier = new DossierBancaire();
		Courant courant = new Courant(0);
		
		dossier.deposer(100);
		assertEquals(100, dossier.getSolde(), 0);
		assertEquals(100, courant.getSolde(), 0);

		assertEquals(dossier.getSolde(), courant.getSolde(), 0);
	}

	@Test
	public void test_remunerer() {
	}

}
