package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class VueLireAccreditation extends JFrame {

	private JScrollPane contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JTable ttable = new JTable();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueLireAccreditation frame = new VueLireAccreditation(ttable);
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
	public VueLireAccreditation(JTable _table) {
		setTitle("Lire les accreditations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JScrollPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table = _table;
		table.setBounds(35, 26, 353, 189);
		contentPane.add(table);
		contentPane.add(table.getTableHeader(), BorderLayout.NORTH);
		contentPane.add(table, BorderLayout.CENTER);
		//TODO : Afficher le Header du table
		//contentPane.add(new JScrollPane(table)); 
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(152, 227, 89, 23);
		contentPane.add(btnQuitter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(41, 227, 89, 23);
		contentPane.add(btnModifier);
		
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueLireAccreditation(this)); 
		btnModifier.addActionListener(new LModifierVueLireAccreditation(this)); 
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
