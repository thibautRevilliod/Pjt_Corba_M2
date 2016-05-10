package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VueChoixRecupererNomPhoto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueChoixRecupererNomPhoto frame = new VueChoixRecupererNomPhoto();
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
	public VueChoixRecupererNomPhoto() {
		setTitle("Choix r\u00E9cup\u00E9ration nom et photo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntrezLidentifiantDe = new JLabel("Entrez l'identifiant de la personne dont vous");
		lblEntrezLidentifiantDe.setBounds(10, 33, 414, 14);
		contentPane.add(lblEntrezLidentifiantDe);
		
		JLabel lblSouhaitezRcuprerLe = new JLabel("souhaitez r\u00E9cup\u00E9rer le nom et la photo : ");
		lblSouhaitezRcuprerLe.setBounds(10, 51, 230, 14);
		contentPane.add(lblSouhaitezRcuprerLe);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(53, 76, 135, 20);
		contentPane.add(comboBox);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(10, 145, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(134, 145, 89, 23);
		contentPane.add(btnQuitter);
		
		// abonnements
		
		btnQuitter.addActionListener(new LFermerVueChoixRecupererNomPhoto(this)); 
		
		// traitement pour le valider 

		btnValider.addActionListener(new LValiderChoixRecupererNomPhoto(this)); 
	}
}
