package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueParametragePorte extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		JLabel lblLeLibelleDe = new JLabel("Le libelle de la zone :");
		lblLeLibelleDe.setBounds(34, 77, 119, 14);
		contentPane.add(lblLeLibelleDe);
		
		JLabel lblLidentifiantDeLa_1 = new JLabel("L'identifiant de la porte : ");
		lblLidentifiantDeLa_1.setBounds(35, 102, 140, 14);
		contentPane.add(lblLidentifiantDeLa_1);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnValider.setBounds(35, 146, 89, 23);
		contentPane.add(btnValider);
		
		textField = new JTextField();
		textField.setBounds(162, 49, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 74, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(162, 99, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(131, 146, 89, 23);
		contentPane.add(btnQuitter);
		
		// abonnements
		
		btnQuitter.addActionListener(new LFermerVueParametragePorte(this)); 
		btnValider.addActionListener(new LValiderParametragePorte(this)); 
		
	}
}
