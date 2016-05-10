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
	private JTextField textField;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeQuiSouhaitez = new JLabel("De qui souhaitez vous r\u00E9cuperer les informations  ? ");
		lblDeQuiSouhaitez.setBounds(10, 11, 347, 14);
		contentPane.add(lblDeQuiSouhaitez);
		
		textField = new JTextField();
		textField.setBounds(315, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIdentifiant = new JLabel("Identifiant :");
		lblIdentifiant.setBounds(30, 36, 86, 14);
		contentPane.add(lblIdentifiant);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(157, 36, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(30, 62, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(157, 61, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setBounds(30, 87, 46, 14);
		contentPane.add(lblPrnom);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(157, 87, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe : ");
		lblMotDePasse.setBounds(30, 119, 100, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(157, 119, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblPhoto = new JLabel("Photo :");
		lblPhoto.setBounds(30, 144, 46, 14);
		contentPane.add(lblPhoto);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(157, 144, 100, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblDateDeValidit = new JLabel("Date de validit\u00E9 : ");
		lblDateDeValidit.setBounds(30, 170, 100, 14);
		contentPane.add(lblDateDeValidit);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(157, 169, 107, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblPermanent = new JLabel("Permanent ?");
		lblPermanent.setBounds(30, 200, 86, 14);
		contentPane.add(lblPermanent);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(157, 200, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(268, 227, 89, 23);
		contentPane.add(btnQuitter);
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueRecupererInfos(this)); 
		
	}

}
