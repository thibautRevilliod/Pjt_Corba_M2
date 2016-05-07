package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VueAjouterEmpreinte extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueAjouterEmpreinte frame = new VueAjouterEmpreinte();
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
	public VueAjouterEmpreinte() {
		setTitle("Ajouter une empreinte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPourAjouterUne = new JLabel("Pour ajouter une empreinte, veuiller saisir : ");
		lblPourAjouterUne.setBounds(20, 24, 270, 14);
		contentPane.add(lblPourAjouterUne);
		
		JLabel lblLidDeLa = new JLabel("L'id de la personne concern\u00E9e : ");
		lblLidDeLa.setBounds(20, 60, 201, 14);
		contentPane.add(lblLidDeLa);
		
		JLabel lblSonEmpreinte = new JLabel("Son empreinte : ");
		lblSonEmpreinte.setBounds(20, 104, 153, 14);
		contentPane.add(lblSonEmpreinte);
		
		textField = new JTextField();
		textField.setBounds(228, 57, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 101, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(53, 155, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(196, 155, 89, 23);
		contentPane.add(btnQuitter);
		
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueAjouterEmpreinte(this));  
		
		// traitement du bouton valider
		
	}

}
