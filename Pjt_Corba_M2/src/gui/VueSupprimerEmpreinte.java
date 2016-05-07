package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VueSupprimerEmpreinte extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueSupprimerEmpreinte frame = new VueSupprimerEmpreinte();
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
	public VueSupprimerEmpreinte() {
		setTitle("Supprimer une empreinte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 142);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuelleEmpreinteSouhaitez = new JLabel("Quelle empreinte souhaitez vous supprimer ?");
		lblQuelleEmpreinteSouhaitez.setBounds(22, 22, 272, 14);
		contentPane.add(lblQuelleEmpreinteSouhaitez);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(47, 50, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(179, 50, 89, 23);
		contentPane.add(btnQuitter);
		
		textField = new JTextField();
		textField.setBounds(304, 19, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// abonnements
		
		btnQuitter.addActionListener(new LFermerVueSupprimerEmpreinte(this)); 
		
		// traitement pour le valider 

		btnValider.addActionListener(new LValiderVueSupprimerEmpreinte(this)); 
		
	}

}
