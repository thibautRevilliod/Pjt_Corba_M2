package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VueAjouterEmpreinte extends JFrame {

	private JPanel contentPane;
	private JTextField empreinte;
	private JComboBox listeIdSalaries;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JComboBox mcomboBox = new JComboBox();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueAjouterEmpreinte frame = new VueAjouterEmpreinte(mcomboBox);
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
	public VueAjouterEmpreinte(JComboBox pListeIdSalaries) {
		setTitle("Ajouter une empreinte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPourAjouterUne = new JLabel("Pour ajouter une empreinte, veuiller saisir : ");
		lblPourAjouterUne.setBounds(20, 24, 331, 14);
		contentPane.add(lblPourAjouterUne);
		
		JLabel lblLidDeLa = new JLabel("L'id de la personne concern\u00E9e : ");
		lblLidDeLa.setBounds(20, 60, 230, 14);
		contentPane.add(lblLidDeLa);
		
		JLabel lblSonEmpreinte = new JLabel("Son empreinte : ");
		lblSonEmpreinte.setBounds(20, 104, 153, 14);
		contentPane.add(lblSonEmpreinte);
		
		empreinte = new JTextField();
		empreinte.setBounds(278, 101, 73, 20);
		contentPane.add(empreinte);
		empreinte.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(53, 155, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(196, 155, 89, 23);
		contentPane.add(btnQuitter);
		
		listeIdSalaries = pListeIdSalaries;
		listeIdSalaries.setBounds(278, 54, 71, 26);
		contentPane.add(listeIdSalaries);
		
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueAjouterEmpreinte(this));  
		
		// traitement du bouton valider
		btnValider.addActionListener(new LValiderAjouterEmpreinte(this));  
		
	}

	public JTextField getEmpreinte() {
		return empreinte;
	}

	public void setEmpreinte(JTextField empreinte) {
		this.empreinte = empreinte;
	}

	public JComboBox getListeIdSalaries() {
		return listeIdSalaries;
	}

	public void setListeIdSalaries(JComboBox listeIdSalaries) {
		this.listeIdSalaries = listeIdSalaries;
	}
	
	
}
