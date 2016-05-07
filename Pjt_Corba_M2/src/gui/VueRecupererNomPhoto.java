package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VueRecupererNomPhoto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueRecupererNomPhoto frame = new VueRecupererNomPhoto();
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
	public VueRecupererNomPhoto() {
		setTitle("R\u00E9cup\u00E9ration du nom et de la photo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntrezLidentifiantDe = new JLabel("Entrez l'identifiant de la personne concern\u00E9e : ");
		lblEntrezLidentifiantDe.setBounds(10, 30, 276, 14);
		contentPane.add(lblEntrezLidentifiantDe);
		
		textField = new JTextField();
		textField.setBounds(296, 27, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(24, 77, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(123, 77, 173, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPhoto = new JLabel("Photo : ");
		lblPhoto.setBounds(24, 115, 46, 14);
		contentPane.add(lblPhoto);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(123, 115, 217, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(147, 153, 89, 23);
		contentPane.add(btnQuitter);
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueRecupererNomPhoto(this)); 
	}

}
