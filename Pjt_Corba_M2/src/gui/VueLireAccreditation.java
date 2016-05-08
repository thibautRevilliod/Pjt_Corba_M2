package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class VueLireAccreditation extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblIdentifiantDeLa;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueLireAccreditation frame = new VueLireAccreditation();
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
	public VueLireAccreditation() {
		setTitle("Lire les accreditations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(35, 82, 353, 133);
		contentPane.add(table);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(152, 227, 89, 23);
		contentPane.add(btnQuitter);
		
		lblIdentifiantDeLa = new JLabel("Identifiant de la personne \u00E0 consulter : ");
		lblIdentifiantDeLa.setBounds(25, 32, 249, 14);
		contentPane.add(lblIdentifiantDeLa);
		
		comboBox = new JComboBox();
		comboBox.setBounds(311, 29, 28, 20);
		contentPane.add(comboBox);
		
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueLireAccreditation(this)); 
	}

}
