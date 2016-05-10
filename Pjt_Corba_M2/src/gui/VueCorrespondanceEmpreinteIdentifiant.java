package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VueCorrespondanceEmpreinteIdentifiant extends JFrame {

	private JPanel contentPane;
	private JTextField empreinte;
	private JComboBox listeSalaries;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueCorrespondanceEmpreinteIdentifiant frame = new VueCorrespondanceEmpreinteIdentifiant();
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
	public VueCorrespondanceEmpreinteIdentifiant() {
		setTitle("Correspondance Identifiant / Empreinte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(156, 227, 89, 23);
		contentPane.add(btnQuitter);
		
		JLabel lblChoisirUnIdentifiant = new JLabel("Choisir un identifiant");
		lblChoisirUnIdentifiant.setBounds(41, 37, 147, 20);
		contentPane.add(lblChoisirUnIdentifiant);
		
		listeSalaries = new JComboBox();
		listeSalaries.setBounds(203, 34, 80, 26);
		contentPane.add(listeSalaries);
		
		JLabel lblSaisirLempreinte = new JLabel("Saisir l'empreinte");
		lblSaisirLempreinte.setBounds(41, 87, 147, 20);
		contentPane.add(lblSaisirLempreinte);
		
		empreinte = new JTextField();
		empreinte.setBounds(203, 84, 100, 26);
		contentPane.add(empreinte);
		empreinte.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(156, 137, 100, 29);
		contentPane.add(btnValider);
		
		JLabel lblRsultatDeLa = new JLabel("R\u00E9sultat de la correspondance");
		lblRsultatDeLa.setBounds(41, 184, 231, 20);
		contentPane.add(lblRsultatDeLa);
		
		JLabel resCorresp = new JLabel("");
		resCorresp.setBounds(305, 184, 69, 20);
		contentPane.add(resCorresp);
		
		// abonnement
		
		btnValider.addActionListener(new LValiderCorrespondanceEmpreinteIdentifiant(this));
		btnQuitter.addActionListener(new LFermerVueCorrespondanceEmpreinteIdentifiant(this)); 
		
	}

	public JTextField getEmpreinte() {
		return empreinte;
	}

	public void setEmpreinte(JTextField empreinte) {
		this.empreinte = empreinte;
	}

	public JComboBox getListeSalaries() {
		return listeSalaries;
	}

	public void setListeSalaries(JComboBox listeSalaries) {
		this.listeSalaries = listeSalaries;
	}
	
	
	
	
}
