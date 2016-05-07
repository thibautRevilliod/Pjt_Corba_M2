package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VueMenuPorte extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueMenuPorte frame = new VueMenuPorte();
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
	public VueMenuPorte() {
		setTitle("Menu Porte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVousSouhaitez = new JLabel("Vous souhaitez : ");
		lblVousSouhaitez.setBounds(10, 11, 107, 14);
		contentPane.add(lblVousSouhaitez);
		
		JButton btnPasserLaPorte = new JButton("Passer la porte ");
		btnPasserLaPorte.setBounds(10, 40, 134, 23);
		contentPane.add(btnPasserLaPorte);
		
		JButton btnModifierVotreEmpreinte = new JButton("Modifier votre empreinte");
		btnModifierVotreEmpreinte.setBounds(157, 40, 180, 23);
		contentPane.add(btnModifierVotreEmpreinte);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(112, 74, 89, 23);
		contentPane.add(btnQuitter);
		
		
		// Abonnements :
		btnQuitter.addActionListener(new LFermerMenuPorte(this));    
		btnPasserLaPorte.addActionListener(new LVuePasserPorte(this));
		btnModifierVotreEmpreinte.addActionListener(new LVueModifierEmpreinte(this));
	}

}
