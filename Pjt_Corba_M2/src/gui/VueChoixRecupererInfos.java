package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VueChoixRecupererInfos extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JComboBox idSal = new JComboBox();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueChoixRecupererInfos frame = new VueChoixRecupererInfos(idSal);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param _idSal 
	 */
	public VueChoixRecupererInfos(JComboBox _idSal) {
		setTitle("Choix r\u00E9cup\u00E9ration des informations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChoisissezLidentifiantDe = new JLabel("Choisissez l'identifiant de la personne dont vous");
		lblChoisissezLidentifiantDe.setBounds(10, 26, 253, 14);
		contentPane.add(lblChoisissezLidentifiantDe);
		
		JLabel lblSouhaitezRcuprerLes = new JLabel("souhaitez r\u00E9cup\u00E9rer les informations :");
		lblSouhaitezRcuprerLes.setBounds(10, 43, 226, 14);
		contentPane.add(lblSouhaitezRcuprerLes);
		
		comboBox = _idSal;
		comboBox.setBounds(57, 68, 85, 20);
		contentPane.add(comboBox);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(10, 100, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(109, 99, 89, 23);
		contentPane.add(btnQuitter);
		
		// abonnements
		
		btnQuitter.addActionListener(new LFermerVueChoixRecupererInfos(this)); 
		
		// traitement pour le valider 

		btnValider.addActionListener(new LValiderChoixRecupererInfos(this)); 
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

}
