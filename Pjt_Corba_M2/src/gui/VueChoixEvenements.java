package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class VueChoixEvenements extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JFormattedTextField formattedTextField;
	private JComboBox comboBox_1;
	private JFormattedTextField formattedTextField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JComboBox mcomboBox = null;
		JComboBox mcomboBox_1;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueChoixEvenements frame = new VueChoixEvenements(mcomboBox, mcomboBox);
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
	public VueChoixEvenements(JComboBox _comboBox, JComboBox _comboBox_1) {
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
		
		//comboBox = new JComboBox();
		comboBox = _comboBox;
		comboBox.setBounds(169, 30, 145, 20);
		contentPane.add(comboBox);
		
		JLabel lblIdentifiantDeLopration = new JLabel("Nom de l'op\u00E9ration : ");
		lblIdentifiantDeLopration.setBounds(29, 64, 161, 14);
		contentPane.add(lblIdentifiantDeLopration);
		
		//comboBox_1 = new JComboBox();
		comboBox_1 = _comboBox_1;
		comboBox_1.setBounds(169, 61, 145, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblEntre = new JLabel("Entre : ");
		lblEntre.setBounds(28, 115, 46, 14);
		contentPane.add(lblEntre);
		
		DateFormat formatDateheure = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		formattedTextField = new JFormattedTextField(formatDateheure);
		formattedTextField.setBounds(83, 112, 67, 20);
		contentPane.add(formattedTextField);
		
		JLabel lblHEt = new JLabel("       et         ");
		lblHEt.setBounds(157, 115, 73, 14);
		contentPane.add(lblHEt);
		
		formattedTextField_1 = new JFormattedTextField(formatDateheure);
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

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JFormattedTextField getFormattedTextField() {
		return formattedTextField;
	}

	public void setFormattedTextField(JFormattedTextField formattedTextField) {
		this.formattedTextField = formattedTextField;
	}

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}

	public JFormattedTextField getFormattedTextField_1() {
		return formattedTextField_1;
	}

	public void setFormattedTextField_1(JFormattedTextField formattedTextField_1) {
		this.formattedTextField_1 = formattedTextField_1;
	}
}
