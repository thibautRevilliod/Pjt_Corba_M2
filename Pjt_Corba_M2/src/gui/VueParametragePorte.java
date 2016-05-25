package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LanceurPersonnel.PersonnelRH;
import LanceurPersonnel.PersonnelSecurite;
import LanceurPersonnel.Utilisateur;
import modControledAcces.InfoZone;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class VueParametragePorte extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueParametragePorte frame = new VueParametragePorte();
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
	public VueParametragePorte() {
//		Utilisateur.connexionELporte(main.param);
//		PersonnelSecurite.connexionELautorisation(main.param);
		
		setTitle("Param\u00E9trage Porte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVeuillezSaisirLidentifiant = new JLabel("Veuillez saisir : ");
		lblVeuillezSaisirLidentifiant.setBounds(25, 27, 128, 14);
		contentPane.add(lblVeuillezSaisirLidentifiant);
		
		JLabel lblLidentifiantDeLa = new JLabel("L'identifiant de la zone : ");
		lblLidentifiantDeLa.setBounds(35, 52, 140, 14);
		contentPane.add(lblLidentifiantDeLa);
		
		JLabel lblLidentifiantDeLa_1 = new JLabel("Nom de la porte : ");
		lblLidentifiantDeLa_1.setBounds(35, 102, 140, 14);
		contentPane.add(lblLidentifiantDeLa_1);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnValider.setBounds(35, 146, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(131, 146, 89, 23);
		contentPane.add(btnQuitter);
		
		comboBox = remplirComboBoxZone();
		comboBox.setBounds(164, 49, 93, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(164, 99, 93, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// abonnements
		
		btnQuitter.addActionListener(new LFermerVueParametragePorte(this)); 
		btnValider.addActionListener(new LValiderParametragePorte(this)); 
		
		
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	
	private InfoZone[] listeZones() {
		PersonnelSecurite.connexionELautorisation(main.param);
		InfoZone[] infoZone = PersonnelSecurite.monELAutorisation.listeToutesZones();
		
		return infoZone;
	}
	
	private JComboBox remplirComboBoxZone()
	{
		JComboBox _comboBox = new JComboBox();
		InfoZone[] iz = listeZones();
		
		_comboBox.addItem("");
		
		for(int i = 0; i < iz.length; i++)
		{
			_comboBox.addItem(iz[i].idZone);
		}
		return _comboBox;
	}
}
