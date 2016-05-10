package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;

public class VueCorrespondanceEmpreinteIdentifiant extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueCorrespondanceEmpreinteIdentifiant frame = new VueCorrespondanceEmpreinteIdentifiant();
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
	public VueCorrespondanceEmpreinteIdentifiant() {
		setTitle("Correspondance Identifiant / Empreinte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(28, 29, 371, 173);
		contentPane.add(table);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(156, 227, 89, 23);
		contentPane.add(btnQuitter);
		
		// abonnement
		
		btnQuitter.addActionListener(new LFermerVueCorrespondanceEmpreinteIdentifiant(this)); 
		
	}

}
