package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;

public class VueConsulterEvenements extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			JTable _table = new JTable();
			public void run() {
				try {
					VueConsulterEvenements frame = new VueConsulterEvenements(_table);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param _table 
	 */
	public VueConsulterEvenements(JTable _table) {
		setTitle("Consulter les \u00E9v\u00E9nements");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//table = new JTable();
		table = _table;
		table.setBounds(23, 11, 800, 189);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		contentPane.add(table);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(165, 211, 89, 23);
		contentPane.add(btnQuitter);
		
		
		// abonnements
		
		btnQuitter.addActionListener(new LFermerVueConsulterEvenements(this)); 
	}

}
