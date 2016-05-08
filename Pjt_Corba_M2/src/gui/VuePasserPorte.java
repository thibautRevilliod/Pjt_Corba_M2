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

public class VuePasserPorte extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JComboBox comboBox = new JComboBox();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VuePasserPorte frame = new VuePasserPorte(comboBox);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param jComboBox 
	 */
	public VuePasserPorte(JComboBox _comboBox) {
		setTitle("Porte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 229, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPourPasserLa = new JLabel("Pour passer la porte, veuillez saisir : ");
		lblPourPasserLa.setBounds(10, 11, 289, 14);
		contentPane.add(lblPourPasserLa);
		
		JLabel lblEmpreinte = new JLabel("Empreinte :");
		lblEmpreinte.setBounds(37, 50, 66, 14);
		contentPane.add(lblEmpreinte);
		
		JLabel lblPhoto = new JLabel("Photo : ");
		lblPhoto.setBounds(37, 75, 46, 14);
		contentPane.add(lblPhoto);
		
		textField = new JTextField();
		textField.setBounds(109, 47, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 72, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(14, 137, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(109, 137, 89, 23);
		contentPane.add(btnQuitter);
		
		JLabel lblZone = new JLabel("Zone :");
		lblZone.setBounds(37, 100, 46, 14);
		contentPane.add(lblZone);
		
		comboBox = _comboBox;
		comboBox.setBounds(109, 97, 86, 20);
		contentPane.add(comboBox);
		
		
		// abonnements
		
		btnQuitter.addActionListener(new LFermerVuePasserPorte(this)); 
		
		// Traitement pour la validation du formulaire: 
		
		btnValider.addActionListener(new LValiderPasserPorte(this)); 
		
	}

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

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
}
