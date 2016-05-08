package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VueChoixLireAccreditation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueChoixLireAccreditation frame = new VueChoixLireAccreditation();
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
	public VueChoixLireAccreditation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 124);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdentifiantDeLa = new JLabel("Identifiant de la personne : ");
		lblIdentifiantDeLa.setBounds(10, 11, 206, 14);
		contentPane.add(lblIdentifiantDeLa);
				
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(173, 8, 108, 20);
		contentPane.add(comboBox);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(58, 51, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(181, 51, 89, 23);
		contentPane.add(btnQuitter);

		
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueChoixLireAccreditation(this)); 
		
		// pour le bouton valider : cela ouvre une nouvelle fenetre + mémorisation des données saisies
		
		btnValider.addActionListener(new LValiderChoixLireAccreditation(this)); 
	}
}
