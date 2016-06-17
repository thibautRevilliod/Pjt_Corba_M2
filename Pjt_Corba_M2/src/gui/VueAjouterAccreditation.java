package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class VueAjouterAccreditation extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1;
	private JFormattedTextField formattedTextField_2;
	private JFormattedTextField formattedTextField_3;
	private JComboBox listeIdSalaries;
	private JComboBox listeIdZones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JComboBox mcomboBox = new JComboBox();
		JComboBox mcomboBox_1 = new JComboBox();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueAjouterAccreditation frame = new VueAjouterAccreditation(mcomboBox, mcomboBox_1);
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
	public VueAjouterAccreditation(JComboBox pListeIdSalaries, JComboBox pListeIdZones) {
		setTitle("Ajouter une accredidation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdentifiantDuSalari = new JLabel("Identifiant du salari\u00E9 : ");
		lblIdentifiantDuSalari.setBounds(23, 27, 156, 14);
		contentPane.add(lblIdentifiantDuSalari);
		
		JLabel lblJourDbut = new JLabel("Jour d\u00E9but (format yyyy/MM/dd) : ");
		lblJourDbut.setBounds(23, 61, 168, 14);
		contentPane.add(lblJourDbut);
		
		JLabel lblJourFin = new JLabel("Jour fin (format yyyy/MM/dd) :");
		lblJourFin.setBounds(23, 96, 168, 14);
		contentPane.add(lblJourFin);
		
		JLabel lblEntre = new JLabel("Entre (format HH:mm)");
		lblEntre.setBounds(23, 121, 128, 14);
		contentPane.add(lblEntre);
		
		JLabel lblHEt = new JLabel("et (format HH:mm)");
		lblHEt.setBounds(23, 148, 114, 14);
		contentPane.add(lblHEt);
		
		JLabel lblZone = new JLabel("Zone : ");
		lblZone.setBounds(23, 173, 148, 14);
		contentPane.add(lblZone);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(90, 235, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(238, 235, 89, 23);
		contentPane.add(btnQuitter);
		
		DateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat formatHeure = new SimpleDateFormat("HH:mm");
		
		formattedTextField = new JFormattedTextField(formatDate);
		formattedTextField.setBounds(227, 58, 86, 20);
		contentPane.add(formattedTextField);
		
		formattedTextField_1 = new JFormattedTextField(formatDate);
		formattedTextField_1.setBounds(227, 93, 86, 20);
		contentPane.add(formattedTextField_1);
		
		formattedTextField_2 = new JFormattedTextField(formatHeure);
		formattedTextField_2.setBounds(227, 118, 86, 20);
		contentPane.add(formattedTextField_2);
		
		formattedTextField_3 = new JFormattedTextField(formatHeure);
		formattedTextField_3.setBounds(227, 145, 86, 20);
		contentPane.add(formattedTextField_3);
		
		listeIdSalaries = pListeIdSalaries;
		listeIdSalaries.setBounds(227, 28, 86, 20);
		contentPane.add(listeIdSalaries);
		
		listeIdZones = pListeIdZones;
		listeIdZones.setBounds(227, 170, 86, 20);
		contentPane.add(listeIdZones);
		
		
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueAjouterAccreditation(this)); 
		
		// traitement pour le bouton valider
		btnValider.addActionListener(new LValiderAjouterAccreditation(this)); 
	}

	

	public JComboBox getListeIdSalaries() {
		return listeIdSalaries;
	}

	public void setListeIdSalaries(JComboBox listeIdSalaries) {
		this.listeIdSalaries = listeIdSalaries;
	}

	public JComboBox getListeIdZones() {
		return listeIdZones;
	}

	public void setListeIdZones(JComboBox listeIdZones) {
		this.listeIdZones = listeIdZones;
	}

	public JFormattedTextField getFormattedTextField() {
		return formattedTextField;
	}

	public void setFormattedTextField(JFormattedTextField formattedTextField) {
		this.formattedTextField = formattedTextField;
	}

	public JFormattedTextField getFormattedTextField_1() {
		return formattedTextField_1;
	}

	public void setFormattedTextField_1(JFormattedTextField formattedTextField_1) {
		this.formattedTextField_1 = formattedTextField_1;
	}

	public JFormattedTextField getFormattedTextField_2() {
		return formattedTextField_2;
	}

	public void setFormattedTextField_2(JFormattedTextField formattedTextField_2) {
		this.formattedTextField_2 = formattedTextField_2;
	}

	public JFormattedTextField getFormattedTextField_3() {
		return formattedTextField_3;
	}

	public void setFormattedTextField_3(JFormattedTextField formattedTextField_3) {
		this.formattedTextField_3 = formattedTextField_3;
	}
}
