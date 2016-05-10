package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.text.Format;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VueCreerSalarie extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JFormattedTextField formattedTextField;
	private JRadioButton rdbtnOui;
	private JRadioButton rdbtnNon;
	private  ButtonGroup group;
	private JTextField textField_4;
	private JFormattedTextField formattedTextField_1;
	private JFormattedTextField formattedTextField_2;
	private JFormattedTextField formattedTextField_3;
	private JFormattedTextField formattedTextField_4;

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
		setBounds(100, 100, 307, 405);
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
        
        DateFormat formatDateheure = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        DateFormat formatHeure = new SimpleDateFormat("HH:mm");
        DateFormat formatDate= new SimpleDateFormat("yyyy/MM/dd");
        
        formattedTextField = new JFormattedTextField(formatDateheure);
        formattedTextField.setBounds(173, 112, 86, 20);
		contentPane.add(formattedTextField);
		formattedTextField.setColumns(10);
		
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
		btnValider.setBounds(32, 332, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(141, 332, 89, 23);
		contentPane.add(btnQuitter);
		
		formattedTextField_1 = new JFormattedTextField(formatHeure);
		formattedTextField_1.setColumns(10);
		formattedTextField_1.setBounds(173, 194, 86, 20);
		contentPane.add(formattedTextField_1);
		
		JLabel lblHeureDebut = new JLabel("Heure debut :");
		lblHeureDebut.setBounds(10, 197, 153, 14);
		contentPane.add(lblHeureDebut);
		
		formattedTextField_2 = new JFormattedTextField(formatHeure);
		formattedTextField_2.setColumns(10);
		formattedTextField_2.setBounds(173, 225, 86, 20);
		contentPane.add(formattedTextField_2);
		
		JLabel lblHeureFin = new JLabel("Heure fin :");
		lblHeureFin.setBounds(10, 228, 153, 14);
		contentPane.add(lblHeureFin);
		
		formattedTextField_3 = new JFormattedTextField(formatDate);
		formattedTextField_3.setColumns(10);
		formattedTextField_3.setBounds(173, 256, 86, 20);
		contentPane.add(formattedTextField_3);
		
		JLabel lblJourDbut = new JLabel("Jour d\u00E9but :");
		lblJourDbut.setBounds(10, 259, 153, 14);
		contentPane.add(lblJourDbut);
		
		formattedTextField_4 = new JFormattedTextField(formatDate);
		formattedTextField_4.setColumns(10);
		formattedTextField_4.setBounds(173, 287, 86, 20);
		contentPane.add(formattedTextField_4);
		
		JLabel lblJourFin = new JLabel("Jour fin :");
		lblJourFin.setBounds(10, 290, 153, 14);
		contentPane.add(lblJourFin);
		
		rdbtnNon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				formattedTextField_1.setVisible(true);
				formattedTextField_2.setVisible(true);
				formattedTextField_3.setVisible(true);
				formattedTextField_4.setVisible(true);
			}
		});
		
		rdbtnOui.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {				
				formattedTextField_1.setVisible(false);
				formattedTextField_2.setVisible(false);
				formattedTextField_3.setVisible(false);
				formattedTextField_4.setVisible(false);
			}
		});
		
		// abonnements
		btnQuitter.addActionListener(new LFermerVueCreerSalarie(this)); 
		
		// traitement pour le bouton valider
		btnValider.addActionListener(new LValiderCreerSalarie(this)); 
		
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JRadioButton getRdbtnOui() {
		return rdbtnOui;
	}

	public void setRdbtnOui(JRadioButton rdbtnOui) {
		this.rdbtnOui = rdbtnOui;
	}

	public JRadioButton getRdbtnNon() {
		return rdbtnNon;
	}

	public void setRdbtnNon(JRadioButton rdbtnNon) {
		this.rdbtnNon = rdbtnNon;
	}

	public JFormattedTextField getjFormattedTextField() {
		return formattedTextField;
	}

	public void setjFormattedTextField(JFormattedTextField jFormattedTextField) {
		this.formattedTextField = jFormattedTextField;
	}

	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JFormattedTextField getFormattedTextField_1() {
		return formattedTextField_1;
	}

	public void setFormattedTextField_1(JFormattedTextField formattedTextField_1) {
		this.formattedTextField_1 = formattedTextField_1;
	}

	public JFormattedTextField getFormattedTextField_2() {
		return formattedTextField_2;
	}

	public void setFormattedTextField_2(JFormattedTextField formattedTextField_2) {
		this.formattedTextField_2 = formattedTextField_2;
	}

	public JFormattedTextField getFormattedTextField_3() {
		return formattedTextField_3;
	}

	public void setFormattedTextField_3(JFormattedTextField formattedTextField_3) {
		this.formattedTextField_3 = formattedTextField_3;
	}

	public JFormattedTextField getFormattedTextField_4() {
		return formattedTextField_4;
	}

	public void setFormattedTextField_4(JFormattedTextField formattedTextField_4) {
		this.formattedTextField_4 = formattedTextField_4;
	}
}
