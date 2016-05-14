package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import LanceurPersonnel.PersonnelRH;
import modControledAcces.CleInconnue;
import modControledAcces.EmpreinteExistante;
import modControledAcces.EmpreinteIncorrecte;

public class LValiderAjouterEmpreinte implements ActionListener
{

	private VueAjouterEmpreinte vm;

	public LValiderAjouterEmpreinte (VueAjouterEmpreinte vueAjouterEmpreinte)
	{
		this.vm=vueAjouterEmpreinte;
	}

	public void actionPerformed(ActionEvent e)
	{
		String message = "";
		String resAjoutEmpreinte = "";
		
		if(!vm.getListeIdSalaries().getSelectedItem().equals("") && !vm.getEmpreinte().getText().equals(""))
		{
			String salarie = (String) vm.getListeIdSalaries().getSelectedItem();
			String empreinte = (String) vm.getEmpreinte().getText();
			
			try {
				resAjoutEmpreinte = PersonnelRH.monELEmpreinte.ajouterEmpreinte(salarie, empreinte, PersonnelRH.cleEmpreinte);
				
				int retAjoutEmpreinte = Integer.parseInt(resAjoutEmpreinte);
				
				
				if (retAjoutEmpreinte == -1)
				{
					message = "Erreur SQL";
					JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
				}
				else if(retAjoutEmpreinte == -2)
				{
					message = "Empreinte déjà existante";
					JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);

				}
				else if(retAjoutEmpreinte >0)
				{
					message = "Empreinte ajoutée";
					JOptionPane.showMessageDialog(vm, message, "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					message = "Erreur inconnue";
					JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
				}
				
			} catch (EmpreinteExistante e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CleInconnue e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (EmpreinteIncorrecte e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		System.out.println("yo 2 !");
	}
}