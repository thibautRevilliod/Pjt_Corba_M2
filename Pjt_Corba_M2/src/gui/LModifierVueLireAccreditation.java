package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class LModifierVueLireAccreditation implements ActionListener, WindowListener 
{

		
	private VueLireAccreditation vue;
		
	
	public LModifierVueLireAccreditation (VueLireAccreditation pvue)
	{
			this.vue=pvue;
	}
	
	
	public void actionPerformed(ActionEvent arg0) 
	{
		SimpleDateFormat formatDateNew = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat formatDateOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat formatHeure = new SimpleDateFormat("HH:mm");
		
		try {
			int selectedRowIndex = vue.getTable().getSelectedRow();
			
			String idSalarie = (String) vue.getTable().getModel().getValueAt(selectedRowIndex, 0);
			String idZone = (String) vue.getTable().getModel().getValueAt(selectedRowIndex, 1);
			
			String dateAccreditation = formatDateNew.format(formatDateOld.parse((String) vue.getTable().getModel().getValueAt(selectedRowIndex, 2)));
			
			String heureDebut = formatHeure.format(formatDateOld.parse((String) vue.getTable().getModel().getValueAt(selectedRowIndex, 3)));
			String heureFin = formatHeure.format(formatDateOld.parse((String) vue.getTable().getModel().getValueAt(selectedRowIndex, 4)));
			String jourDebut = formatDateNew.format(formatDateOld.parse((String) vue.getTable().getModel().getValueAt(selectedRowIndex, 5)));
			String jourFin = formatDateNew.format(formatDateOld.parse((String) vue.getTable().getModel().getValueAt(selectedRowIndex, 6)));
		
		
		
		
					
		this.vue.setVisible(false);
		
		
		VueModifierAccreditation vMA = new VueModifierAccreditation(idSalarie, idZone, heureDebut, heureFin, jourDebut, jourFin);
		vMA.setVisible(true);
		vMA.setLocation(800, 300);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		
		this.vue.setVisible(false);
	} 
	
}