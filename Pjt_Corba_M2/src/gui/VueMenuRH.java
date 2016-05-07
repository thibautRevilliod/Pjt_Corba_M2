package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VueMenuRH extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueMenuRH frame = new VueMenuRH();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VueMenuRH() {
		setTitle("Menu RH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVousSouhaitez = new JLabel("Vous souhaitez :");
		lblVousSouhaitez.setBounds(10, 22, 209, 14);
		contentPane.add(lblVousSouhaitez);
		
		JButton btnVrifierLaCorrespondance = new JButton("V\u00E9rifier la correspondance nom / empreinte");
		btnVrifierLaCorrespondance.setBounds(33, 46, 291, 23);
		contentPane.add(btnVrifierLaCorrespondance);
		
		JButton btnSupprimerUneEmpreinte = new JButton("Supprimer une empreinte");
		btnSupprimerUneEmpreinte.setBounds(33, 114, 291, 23);
		contentPane.add(btnSupprimerUneEmpreinte);
		
		JButton btnAjouterUneEmpreinte = new JButton("Ajouter une empreinte");
		btnAjouterUneEmpreinte.setBounds(33, 80, 291, 23);
		contentPane.add(btnAjouterUneEmpreinte);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(130, 188, 89, 23);
		contentPane.add(btnQuitter);
		
		JButton btnOuvrirLannuaire = new JButton("Ouvrir l'annuaire");
		btnOuvrirLannuaire.setBounds(33, 152, 291, 23);
		contentPane.add(btnOuvrirLannuaire);
		
		// abonnements
		
		btnQuitter.addActionListener(new LFermerVueMenuRH(this)); 
		btnVrifierLaCorrespondance.addActionListener(new LVueCorrespondanceEmpreinteNom(this)); 
		btnSupprimerUneEmpreinte.addActionListener(new LVueSupprimerEmpreinte(this)); 
		btnAjouterUneEmpreinte.addActionListener(new LVueAjouterEmpreinte(this)); 
		btnOuvrirLannuaire.addActionListener(new LVueMenuAnnuaire(this)); 
	}

}
