package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VueAjouterAccreditation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueAjouterAccreditation frame = new VueAjouterAccreditation();
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
	public VueAjouterAccreditation() {
		setTitle("Ajouter une accredidation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdentifiantDuSalari = new JLabel("Identifiant du salari\u00E9 : ");
		lblIdentifiantDuSalari.setBounds(23, 27, 156, 14);
		contentPane.add(lblIdentifiantDuSalari);
		
		textField = new JTextField();
		textField.setBounds(189, 24, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblJourDbut = new JLabel("Jour d\u00E9but : ");
		lblJourDbut.setBounds(23, 61, 148, 14);
		contentPane.add(lblJourDbut);
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 58, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblJourFin = new JLabel("Jour fin :");
		lblJourFin.setBounds(23, 96, 142, 14);
		contentPane.add(lblJourFin);
		
		textField_2 = new JTextField();
		textField_2.setBounds(189, 93, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEntre = new JLabel("Entre ");
		lblEntre.setBounds(23, 138, 46, 14);
		contentPane.add(lblEntre);
		
		textField_3 = new JTextField();
		textField_3.setBounds(79, 135, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblHEt = new JLabel("h     et ");
		lblHEt.setBounds(175, 138, 46, 14);
		contentPane.add(lblHEt);
		
		textField_4 = new JTextField();
		textField_4.setBounds(231, 135, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblH = new JLabel("h");
		lblH.setBounds(327, 138, 46, 14);
		contentPane.add(lblH);
		
		JLabel lblZone = new JLabel("Zone : ");
		lblZone.setBounds(23, 173, 148, 14);
		contentPane.add(lblZone);
		
		textField_5 = new JTextField();
		textField_5.setBounds(189, 170, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(62, 212, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(204, 212, 89, 23);
		contentPane.add(btnQuitter);
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueAjouterAccreditation(this)); 
		
		// traitement pour le bouton valider
		btnValider.addActionListener(new LValiderAjouterAccreditation(this)); 
	}

}
