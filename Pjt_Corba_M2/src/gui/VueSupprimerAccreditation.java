package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LanceurPersonnel.PersonnelSecurite;
import modControledAcces.InfoSalarie;
import modControledAcces.InfoZone;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VueSupprimerAccreditation extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JComboBox mcomboBox = new JComboBox();
		JComboBox mcomboBox_1 = new JComboBox();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueSupprimerAccreditation frame = new VueSupprimerAccreditation(mcomboBox,mcomboBox_1);
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
	public VueSupprimerAccreditation(JComboBox _comboBox, JComboBox _comboBox_1) {
		setTitle("Supprimer une accreditation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdentifiantDeLaccreditation = new JLabel("Identifiant de la personne : ");
		lblIdentifiantDeLaccreditation.setBounds(10, 23, 250, 14);
		contentPane.add(lblIdentifiantDeLaccreditation);
		
		JButton btnValider = new JButton("Valider ");
		btnValider.setBounds(80, 125, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(187, 125, 89, 23);
		contentPane.add(btnQuitter);
		
		//comboBox = new JComboBox();
		comboBox = _comboBox;
		comboBox.setBounds(248, 20, 118, 20);
		contentPane.add(comboBox);
		
		JLabel lblIdentifiantDeLa = new JLabel("Identifiant de la zone : ");
		lblIdentifiantDeLa.setBounds(10, 59, 139, 14);
		contentPane.add(lblIdentifiantDeLa);
		
		//comboBox_1 = new JComboBox();
		comboBox_1 = _comboBox_1;
		comboBox_1.setBounds(248, 59, 118, 20);
		contentPane.add(comboBox_1);
		
		
		// abonnement
		
		btnQuitter.addActionListener(new LFermerVueSupprimerAccreditation(this)); 
		
		// traitement du bouton valider
		btnValider.addActionListener(new LValiderVueSupprimerAccreditation(this)); 
	}
	
	
	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}
}
