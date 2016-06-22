package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.ZoneId;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VueMenuPorte extends JFrame {

	private JPanel contentPane;
	private String idZone;
	private JLabel LbInfosPorte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String iidZone = null;
		String iidPorte = null;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueMenuPorte frame = new VueMenuPorte(iidZone, iidPorte);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param _libPorte 
	 * @param idZone 
	 */
	public VueMenuPorte(String _idZone, String _libPorte) {
		idZone = _idZone;
		
		setTitle("Menu Porte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVousSouhaitez = new JLabel("Vous souhaitez : ");
		lblVousSouhaitez.setBounds(10, 11, 154, 14);
		contentPane.add(lblVousSouhaitez);
		
		JButton btnPasserLaPorte = new JButton("Passer la porte ");
		btnPasserLaPorte.setBounds(10, 40, 154, 23);
		contentPane.add(btnPasserLaPorte);
		
		JButton btnModifierVotreEmpreinte = new JButton("Modifier votre empreinte");
		btnModifierVotreEmpreinte.setBounds(176, 40, 222, 23);
		contentPane.add(btnModifierVotreEmpreinte);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(112, 74, 89, 23);
		contentPane.add(btnQuitter);
		
		LbInfosPorte = new JLabel("=> Zone : " + _idZone + " || Porte : " + _libPorte);
		LbInfosPorte.setBounds(45, 127, 244, 20);
		contentPane.add(LbInfosPorte);
		
		
		// Abonnements :
		btnQuitter.addActionListener(new LFermerMenuPorte(this));    
		btnPasserLaPorte.addActionListener(new LVuePasserPorte(this, idZone));
		btnModifierVotreEmpreinte.addActionListener(new LVueModifierEmpreinte(this));
	}

}
