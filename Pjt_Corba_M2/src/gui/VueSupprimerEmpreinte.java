package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VueSupprimerEmpreinte extends JFrame {

	private JPanel contentPane;
	private JComboBox listeIdSalaries;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JComboBox mcomboBox = new JComboBox();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueSupprimerEmpreinte frame = new VueSupprimerEmpreinte(mcomboBox);
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
	public VueSupprimerEmpreinte(JComboBox pListeIdSalaries) {
		setTitle("Supprimer une empreinte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuelleEmpreinteSouhaitez = new JLabel("S\u00E9lectionnez le salari\u00E9 temporaire pour lequel ");
		lblQuelleEmpreinteSouhaitez.setBounds(22, 22, 334, 23);
		contentPane.add(lblQuelleEmpreinteSouhaitez);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(146, 104, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(313, 104, 89, 23);
		contentPane.add(btnQuitter);
		
		JLabel lblNewLabel = new JLabel("vous souhaitez supprimer l'empreinte");
		lblNewLabel.setBounds(22, 52, 278, 23);
		contentPane.add(lblNewLabel);
		
		listeIdSalaries = pListeIdSalaries;
		listeIdSalaries.setBounds(410, 47, 89, 26);
		contentPane.add(listeIdSalaries);
		
		// abonnements
		
		btnQuitter.addActionListener(new LFermerVueSupprimerEmpreinte(this)); 
		
		// traitement pour le valider 

		btnValider.addActionListener(new LValiderVueSupprimerEmpreinte(this)); 
		
	}

	public JComboBox getListeIdSalaries() {
		return listeIdSalaries;
	}

	public void setListeIdSalaries(JComboBox listeIdSalaries) {
		this.listeIdSalaries = listeIdSalaries;
	}
	
	
}
