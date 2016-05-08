package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LValiderChoixLireAccreditation implements ActionListener
{

	private VueChoixLireAccreditation vm;
	
	

	public LValiderChoixLireAccreditation (VueChoixLireAccreditation vueChoixLireAccreditation)
	{
		this.vm=vueChoixLireAccreditation;
	}

	public void actionPerformed(ActionEvent e)
	{

		
		// ici l'action a réaliser 
		
		System.out.println("yo je valide le choix de lire l'acreditation ,et j'ouvre la fenetre ! !");
		VueLireAccreditation vce;
		
		vce = new VueLireAccreditation();
		vce.setVisible(true);
		vce.setLocation(500, 200);
	}
}