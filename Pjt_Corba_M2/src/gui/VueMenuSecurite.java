package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueMenuSecurite extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueMenuSecurite frame = new VueMenuSecurite();
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
	public VueMenuSecurite() {
		setTitle("Menu S\u00E9curit\u00E9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVousVoulez = new JLabel("Vous voulez : ");
		lblVousVoulez.setBounds(10, 24, 129, 14);
		contentPane.add(lblVousVoulez);
		
		JButton btnAjouterUneAccrditation = new JButton("Ajouter une accr\u00E9ditation ");
		btnAjouterUneAccrditation.setBounds(33, 51, 254, 23);
		contentPane.add(btnAjouterUneAccrditation);
		
		JButton btnSupprimerUneAccrditation = new JButton("Supprimer une accr\u00E9ditation");
		btnSupprimerUneAccrditation.setBounds(31, 85, 254, 23);
		contentPane.add(btnSupprimerUneAccrditation);
		
		JButton btnLireUneAccrditation = new JButton("Lire une accr\u00E9ditation");
		btnLireUneAccrditation.setBounds(33, 119, 254, 23);
		contentPane.add(btnLireUneAccrditation);
		
		JButton btnConsulterUnvnement = new JButton("Consulter un \u00E9v\u00E9nement");
		btnConsulterUnvnement.setBounds(33, 153, 254, 23);
		contentPane.add(btnConsulterUnvnement);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(105, 206, 89, 23);
		contentPane.add(btnQuitter);
		
		// abonnements
		
		btnQuitter.addActionListener(new LFermerVueMenuSecurite(this)); 
		btnAjouterUneAccrditation.addActionListener(new LVueAjouterAccreditation(this)); 
		btnSupprimerUneAccrditation.addActionListener(new LVueSupprimerAccreditation(this)); 
		btnLireUneAccrditation.addActionListener(new LVueChoixLireAccreditation(this)); 
		btnConsulterUnvnement.addActionListener(new LVueChoixEvenements(this)); 
	}

}
