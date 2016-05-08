package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class VueChoixEvenements extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueChoixEvenements frame = new VueChoixEvenements();
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
	public VueChoixEvenements() {
		setTitle("Choix \u00E9v\u00E9nement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdentifiantDuSalari = new JLabel("Identifiant du salari\u00E9 : ");
		lblIdentifiantDuSalari.setBounds(29, 33, 151, 14);
		contentPane.add(lblIdentifiantDuSalari);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(169, 30, 145, 20);
		contentPane.add(comboBox);
		
		JLabel lblIdentifiantDeLopration = new JLabel("Nom de l'op\u00E9ration : ");
		lblIdentifiantDeLopration.setBounds(29, 64, 161, 14);
		contentPane.add(lblIdentifiantDeLopration);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(169, 61, 145, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblEntre = new JLabel("Entre : ");
		lblEntre.setBounds(28, 115, 46, 14);
		contentPane.add(lblEntre);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(83, 112, 67, 20);
		contentPane.add(formattedTextField);
		
		JLabel lblHEt = new JLabel("       et         ");
		lblHEt.setBounds(157, 115, 73, 14);
		contentPane.add(lblHEt);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(229, 112, 67, 20);
		contentPane.add(formattedTextField_1);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(61, 143, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(167, 143, 89, 23);
		contentPane.add(btnQuitter);
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueChoixEvenements(this)); 
		
		// pour le bouton valider : cela ouvre une nouvelle fenetre + mémorisation des données saisies
		
		btnValider.addActionListener(new LValiderChoixEvenements(this)); 
	}
}
