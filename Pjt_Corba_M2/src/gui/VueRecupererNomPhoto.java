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
		setBounds(100, 100, 252, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(24, 26, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(96, 26, 173, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPhoto = new JLabel("Photo : ");
		lblPhoto.setBounds(24, 51, 46, 14);
		contentPane.add(lblPhoto);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(93, 51, 217, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(64, 101, 89, 23);
		contentPane.add(btnQuitter);
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueRecupererNomPhoto(this)); 
	}

}
