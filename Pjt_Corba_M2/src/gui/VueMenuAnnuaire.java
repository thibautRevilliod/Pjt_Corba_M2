package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VueMenuAnnuaire extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueMenuAnnuaire frame = new VueMenuAnnuaire();
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
	public VueMenuAnnuaire() {
		setTitle("Menu RH : Sous menu Annuaire");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrerUnSalari = new JButton("Cr\u00E9er un salari\u00E9");
		btnCrerUnSalari.setBounds(24, 64, 282, 23);
		contentPane.add(btnCrerUnSalari);
		
		JButton btnRcuprerLeNom = new JButton("R\u00E9cup\u00E9rer le nom et la photo d'un salari\u00E9");
		btnRcuprerLeNom.setBounds(24, 100, 282, 23);
		contentPane.add(btnRcuprerLeNom);
		
		JButton btnRcuprerLesInformations = new JButton("R\u00E9cup\u00E9rer les informations d'un salari\u00E9");
		btnRcuprerLesInformations.setBounds(24, 134, 282, 23);
		contentPane.add(btnRcuprerLesInformations);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(122, 168, 89, 23);
		contentPane.add(btnQuitter);
		
		JLabel lblVousVoulez = new JLabel("Vous voulez : ");
		lblVousVoulez.setBounds(24, 25, 114, 14);
		contentPane.add(lblVousVoulez);
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueMenuAnnuaire(this)); 
		btnCrerUnSalari.addActionListener(new LVueCreerSalarie(this)); 
		btnRcuprerLesInformations.addActionListener(new LVueRecupererInfos(this)); 
		btnRcuprerLeNom.addActionListener(new LVueRecupererNomPhoto(this)); 
		
		
		
	}

}
