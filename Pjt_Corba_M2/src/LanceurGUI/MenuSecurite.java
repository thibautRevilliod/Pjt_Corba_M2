package LanceurGUI;

import gui.VueMenuSecurite;



public class MenuSecurite {
	public static String[] param;
	public static void main(String[] args) 
	{
		param = args;
		
		VueMenuSecurite menuSecurite;
		
			
		
	// pour ouvrir le menu Securite		
		
		menuSecurite = new VueMenuSecurite();
		menuSecurite.setVisible(true);
		menuSecurite.setLocation(500, 200);
		
	}

}
