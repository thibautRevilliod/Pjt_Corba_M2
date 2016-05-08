package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LValiderChoixEvenements implements ActionListener
{

	private VueChoixEvenements vm;
	
	

	public LValiderChoixEvenements (VueChoixEvenements vueChoixEvenements)
	{
		this.vm=vueChoixEvenements;
	}

	public void actionPerformed(ActionEvent e)
	{

		
		// ici l'action a réaliser 
		
		System.out.println("yo je valide le choix des evenements ,et j'ouvre la fenetre ! !");
		VueConsulterEvenements vce;
		
		vce = new VueConsulterEvenements();
		vce.setVisible(true);
		vce.setLocation(500, 200);
	}
}