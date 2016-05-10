package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VueRecupererInfos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueRecupererInfos frame = new VueRecupererInfos();
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
	public VueRecupererInfos() {
		setTitle("R\u00E9cup\u00E9rer les informations d'un salari\u00E9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdentifiant = new JLabel("Identifiant :");
		lblIdentifiant.setBounds(30, 11, 86, 14);
		contentPane.add(lblIdentifiant);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(157, 11, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(30, 36, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(157, 36, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setBounds(30, 61, 46, 14);
		contentPane.add(lblPrnom);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(157, 61, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe : ");
		lblMotDePasse.setBounds(30, 86, 100, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(157, 86, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblPhoto = new JLabel("Photo :");
		lblPhoto.setBounds(30, 111, 46, 14);
		contentPane.add(lblPhoto);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(157, 111, 100, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblDateDeValidit = new JLabel("Date de validit\u00E9 : ");
		lblDateDeValidit.setBounds(30, 136, 100, 14);
		contentPane.add(lblDateDeValidit);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(157, 136, 107, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblPermanent = new JLabel("Permanent ?");
		lblPermanent.setBounds(30, 161, 86, 14);
		contentPane.add(lblPermanent);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(157, 161, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(89, 299, 89, 23);
		contentPane.add(btnQuitter);
		
		JLabel lblJourDbut = new JLabel("Jour D\u00E9but :");
		lblJourDbut.setBounds(30, 186, 73, 14);
		contentPane.add(lblJourDbut);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(157, 186, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblJourFin = new JLabel("Jour Fin :");
		lblJourFin.setBounds(30, 211, 46, 14);
		contentPane.add(lblJourFin);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(157, 211, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblHeureDbut = new JLabel("Heure D\u00E9but :");
		lblHeureDbut.setBounds(30, 236, 73, 14);
		contentPane.add(lblHeureDbut);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(157, 236, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblHeureFin = new JLabel("Heure Fin :");
		lblHeureFin.setBounds(30, 264, 86, 14);
		contentPane.add(lblHeureFin);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(157, 261, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueRecupererInfos(this)); 
		
	}
}
