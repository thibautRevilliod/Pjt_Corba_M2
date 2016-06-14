package LanceurGUI;

import gui.VueMenuRH;



public class MenuRH {
	public static String[] param;
	public static void main(String[] args) 
	{
		param = args;
		

		VueMenuRH menuRH;

		
		// pour ouvrir le menu RH 		
		
		menuRH = new VueMenuRH();
		menuRH.setVisible(true);
		menuRH.setLocation(500, 200);

	}

}
