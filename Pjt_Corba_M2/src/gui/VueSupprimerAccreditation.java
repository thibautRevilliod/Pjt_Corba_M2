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

public class VueSupprimerAccreditation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueSupprimerAccreditation frame = new VueSupprimerAccreditation();
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
	public VueSupprimerAccreditation() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(248, 20, 28, 20);
		contentPane.add(comboBox);
		
		JLabel lblIdentifiantDeLa = new JLabel("Identifiant de la zone : ");
		lblIdentifiantDeLa.setBounds(10, 59, 139, 14);
		contentPane.add(lblIdentifiantDeLa);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(248, 59, 28, 20);
		contentPane.add(comboBox_1);
		
		
		// abonnement
		
		btnQuitter.addActionListener(new LFermerVueSupprimerAccreditation(this)); 
		
		// traitement du bouton valider
		btnValider.addActionListener(new LValiderVueSupprimerAccreditation(this)); 
	}
}
