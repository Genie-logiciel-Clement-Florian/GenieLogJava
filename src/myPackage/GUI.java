package myPackage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI implements ActionListener {

	private DossierBancaire m_dossier;
	private JTextField m_saisie_depot;
	private JTextField m_display_solde_courant;
	private JTextField m_display_solde_epargne;
	private JTextField m_display_solde;
	private JTextField m_saisie_retirer;
	private JButton m_remunerer;

	// Constructeur
	public GUI(DossierBancaire d) {
		// Dossier
		m_dossier = d;

		// Element saisie depot
		m_saisie_depot = new JTextField(20);
		m_saisie_depot.addActionListener(this);

		// Element declenchement remuneration
		m_remunerer = new JButton("OK");
		m_remunerer.addActionListener(this);

		// Element saisie retirer
		m_saisie_retirer = new JTextField(20);
		m_saisie_retirer.addActionListener(this);

		// Element affichage solde
		m_display_solde = new JTextField(20);
		m_display_solde.setEditable(false); // Pour eviter d'ecrire
		m_display_solde.setText(Double.toString(m_dossier.getSolde()));

		// Element affichage solde courant
		m_display_solde_courant = new JTextField(20);
		m_display_solde_courant.setEditable(false); // Pour eviter d'ecrire
		m_display_solde_courant.setText(Double.toString(m_dossier.getSoldeCourant()));

		// Element affichage solde epargne
		m_display_solde_epargne = new JTextField(20);
		m_display_solde_epargne.setEditable(false); // Pour eviter d'ecrire
		m_display_solde_epargne.setText(Double.toString(m_dossier.getSoldeEpargne()));

		// Initialisation de la fenetre generale
		JFrame frame = new JFrame("Editeur dossier bancaire");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Geometrie de repartition des elements graphiques
		frame.setLayout(new GridLayout(6, 2)); // 3 lignes and 2 columns
		// First line
		frame.getContentPane().add(new JLabel("Depot"));
		frame.getContentPane().add(m_saisie_depot);
		frame.getContentPane().add(new JLabel("Retirer"));
		frame.getContentPane().add(m_saisie_retirer);
		frame.getContentPane().add(new JLabel("Remunerer"));
		frame.getContentPane().add(m_remunerer);
		frame.getContentPane().add(new JLabel("Solde"));
		frame.getContentPane().add(m_display_solde);
		frame.getContentPane().add(new JLabel("Solde compte courant"));
		frame.getContentPane().add(m_display_solde_courant);
		frame.getContentPane().add(new JLabel("Solde compte epargne"));
		frame.getContentPane().add(m_display_solde_epargne);
		frame.pack(); // Causes this Window to be sized to fit the preferred size and layouts of its
						// subcomponents.
		frame.setVisible(true); // Shows this Window

	}

	// Callbacks for buttons: dispatch processings
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == m_saisie_depot) {
			float depot_value = Float.parseFloat(m_saisie_depot.getText());
			m_dossier.deposer(depot_value);
			m_saisie_depot.setText("");
		}
		if (e.getSource() == m_saisie_retirer) {
			float retirer_value = Float.parseFloat(m_saisie_retirer.getText());
			try {
				m_dossier.retirer(retirer_value);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			m_saisie_retirer.setText("");
		}
		if (e.getSource() == m_remunerer) {
			m_dossier.remunerer();
		}
		m_display_solde.setText(Double.toString(m_dossier.getSolde()));
		m_display_solde_courant.setText(Double.toString(m_dossier.getSoldeCourant()));
		m_display_solde_epargne.setText(Double.toString(m_dossier.getSoldeEpargne()));
	}
}
