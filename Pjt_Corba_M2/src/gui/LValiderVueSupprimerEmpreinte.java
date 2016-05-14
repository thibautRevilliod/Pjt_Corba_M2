package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import LanceurPersonnel.PersonnelRH;
import modControledAcces.CleInconnue;
import modControledAcces.ErreurSalarieInexistant;

public class LValiderVueSupprimerEmpreinte implements ActionListener
{

	private VueSupprimerEmpreinte vm;

	public LValiderVueSupprimerEmpreinte (VueSupprimerEmpreinte vueSupprimerEmpreinte)
	{
		this.vm=vueSupprimerEmpreinte;
	}

	public void actionPerformed(ActionEvent e)
	{
		String message = "";
		String resSupprEmpreinte = "";
		
		if(!vm.getListeIdSalaries().getSelectedItem().equals(""))
		{
			String salarie = (String) vm.getListeIdSalaries().getSelectedItem();
			

				try {
					resSupprEmpreinte = PersonnelRH.monELEmpreinte.supprimerEmpreinte(salarie, PersonnelRH.cleEmpreinte);
					
					int retSupprEmpreinte = Integer.parseInt(resSupprEmpreinte);
					
					
					if (retSupprEmpreinte == -1)
					{
						message = "Erreur SQL";
						JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
					}
					else if(retSupprEmpreinte == -2)
					{
						message = "Pas d'empreinte pour ce salarié";
						JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);

					}
					else if(retSupprEmpreinte >0)
					{
						message = "Empreinte supprimée";
						JOptionPane.showMessageDialog(vm, message, "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						message = "Erreur inconnue";
						JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
					}
					
				} catch (ErreurSalarieInexistant e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CleInconnue e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		
		System.out.println("yo 6 !");
	}
}