package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class LFermerVueParametragePorte implements ActionListener, WindowListener 
{

		
	private VueParametragePorte vue;
		
	
	public LFermerVueParametragePorte (VueParametragePorte pvue)
	{
			this.vue=pvue;
	}
	
	
	public void actionPerformed(ActionEvent arg0) 
	{
		int messageType=0;
		int reponse = JOptionPane.showConfirmDialog(this.vue, "Voulez-vous r�ellemment fermer la fen�tre ?", "Quitter ?", JOptionPane.YES_NO_OPTION);
		
		if (reponse == JOptionPane.YES_OPTION) 
		{
					
			System.exit(0);
		}
		
		
	}

	
	
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}


	//@Override
	public void windowClosing(WindowEvent arg0) {
		
		
		System.exit(0);
	} 
	
}