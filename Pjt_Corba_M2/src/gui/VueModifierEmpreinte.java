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
	private JTextField textField_2;

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
		setBounds(100, 100, 360, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPourModifierVotre = new JLabel("Pour modifier votre empreinte, veuillez saisir : ");
		lblPourModifierVotre.setBounds(10, 23, 275, 14);
		contentPane.add(lblPourModifierVotre);
		
		JLabel lblAncienneEmpreinte = new JLabel("Ancienne empreinte :");
		lblAncienneEmpreinte.setBounds(20, 59, 145, 14);
		contentPane.add(lblAncienneEmpreinte);
		
		JLabel lblNouvelleEmpreinte = new JLabel("Nouvelle empreinte : ");
		lblNouvelleEmpreinte.setBounds(20, 109, 145, 14);
		contentPane.add(lblNouvelleEmpreinte);
		
		textField = new JTextField();
		textField.setBounds(175, 56, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 106, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(35, 148, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(147, 148, 89, 23);
		contentPane.add(btnQuitter);
		
		JLabel lblPhoto = new JLabel("Photo :");
		lblPhoto.setBounds(20, 84, 46, 14);
		contentPane.add(lblPhoto);
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 81, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		// abonnements :
		btnQuitter.addActionListener(new LFermerVueModifierEmpreinte(this)); 
		
		// traitement valider :
		btnValider.addActionListener(new LValiderModifierEmpreinte(this)); 
		
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}
}
