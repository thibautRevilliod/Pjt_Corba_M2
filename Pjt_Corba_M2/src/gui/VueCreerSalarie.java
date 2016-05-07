package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class VueCreerSalarie extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueCreerSalarie frame = new VueCreerSalarie();
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
	
	
	public VueCreerSalarie() {
			
		setTitle("Cr\u00E9er un salari\u00E9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(10, 11, 81, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom : ");
		lblPrnom.setBounds(10, 36, 81, 14);
		contentPane.add(lblPrnom);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe : ");
		lblMotDePasse.setBounds(10, 65, 81, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel lblPhoto = new JLabel("Photo :");
		lblPhoto.setBounds(10, 90, 46, 14);
		contentPane.add(lblPhoto);
		
		JLabel lblDateDeFin = new JLabel("Date de fin de validit\u00E9 :");
		lblDateDeFin.setBounds(10, 115, 153, 14);
		contentPane.add(lblDateDeFin);
		
		JLabel lblPermanent = new JLabel("Permanent ? ");
		lblPermanent.setBounds(10, 154, 112, 14);
		contentPane.add(lblPermanent);
			
	    ButtonGroup group;
		JRadioButton rdbtnOui;
		JRadioButton rdbtnNon;
		
		rdbtnOui = new JRadioButton("Oui");
		rdbtnOui.setBounds(142, 147, 46, 29);
		rdbtnOui.setName("Oui");
				
		rdbtnNon = new JRadioButton("Non");
		rdbtnNon.setBounds(193, 147, 76, 29);
		rdbtnNon.setName("Non");
		rdbtnNon.setSelected(true);
		
        group = new ButtonGroup();
        
        group.add(rdbtnOui);
        getContentPane().add(rdbtnOui);
        
        group.add(rdbtnNon);
        getContentPane().add(rdbtnNon);
		
		textField = new JTextField();
		textField.setBounds(173, 112, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(173, 87, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 62, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(173, 33, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(173, 8, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(33, 189, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(142, 189, 89, 23);
		contentPane.add(btnQuitter);
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueCreerSalarie(this)); 
		
		// traitement pour le bouton valider
	}

}
