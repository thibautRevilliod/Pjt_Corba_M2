package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VueModifierEmpreinte extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueModifierEmpreinte frame = new VueModifierEmpreinte();
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
	public VueModifierEmpreinte() {
		setTitle("Modifier votre empreinte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPourModifierVotre = new JLabel("Pour modifier votre empreinte, veuillez saisir : ");
		lblPourModifierVotre.setBounds(10, 23, 275, 14);
		contentPane.add(lblPourModifierVotre);
		
		JLabel lblAncienneEmpreinte = new JLabel("Ancienne empreinte :");
		lblAncienneEmpreinte.setBounds(20, 48, 145, 14);
		contentPane.add(lblAncienneEmpreinte);
		
		JLabel lblNouvelleEmpreinte = new JLabel("Nouvelle empreinte : ");
		lblNouvelleEmpreinte.setBounds(20, 73, 145, 14);
		contentPane.add(lblNouvelleEmpreinte);
		
		textField = new JTextField();
		textField.setBounds(175, 45, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 70, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(33, 108, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(141, 108, 89, 23);
		contentPane.add(btnQuitter);
		
		
		// abonnements :
		btnQuitter.addActionListener(new LFermerVueModifierEmpreinte(this)); 
		
		// traitement valider :
		btnValider.addActionListener(new LValiderModifierEmpreinte(this)); 
		
	}

}
