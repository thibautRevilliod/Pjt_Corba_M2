package LanceurGUI;

import gui.VueParametragePorte;



public class MenuPorte {
	public static String[] param;
	public static void main(String[] args) 
	{
		param = args;
		

		VueParametragePorte paramPorte;

		
		//pour ouvrir la fenetre de paramétrage de la porte: 
		paramPorte = new VueParametragePorte();
		paramPorte.setVisible(true);
		paramPorte.setLocation(500, 200);

	}

}
