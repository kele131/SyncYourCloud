package syc.mvc.controller;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import syc.mvc.model.Model;
import syc.mvc.view.IHM_addSynchronisationRule;
import syc.mvc.view.IHM_synchronisationRules;


public class Controller_addSynchronisationRule implements ActionListener
{		
	private Model model_SYC;
    private IHM_addSynchronisationRule view_addSynchronisationRule;
    
    public Controller_addSynchronisationRule(Model aModel_SYC, IHM_addSynchronisationRule aView_addSynchronisationRule) 
    {
		this.model_SYC = aModel_SYC;
		this.view_addSynchronisationRule = aView_addSynchronisationRule;
		this.ControllerActionListenerForComponent(view_addSynchronisationRule.getContentPane());
    }
	
    public void ControllerActionListenerForComponent(Container cont_temps)
	{
		if(cont_temps instanceof Container)
		{
			int i;
			int j =cont_temps.getComponentCount();
			for(i =0; i< j ;i++)
			{
				Component cmp_temps = cont_temps.getComponents()[i];
				//System.out.println(j);
						
				if(cmp_temps instanceof JButton)
				{	
					((JButton) cmp_temps).addActionListener(this);
				}
				if(cmp_temps instanceof JTextField )
				{
					((JTextField) cmp_temps).addActionListener(this);
				}
				if(cmp_temps instanceof JPasswordField )
				{
					((JPasswordField) cmp_temps).addActionListener(this);
				}
				if(cmp_temps instanceof JComboBox)
				{
					ControllerActionListenerForComponent((JComboBox<String>) cmp_temps);
				}
				if(cmp_temps instanceof Container)
				{
					ControllerActionListenerForComponent((Container) cmp_temps); 
				}
			}
		}	
	}
	
    @Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==this.view_addSynchronisationRule.getjBt_BackToRules())
		{
			//back to IHM_synchronisationRules
			model_SYC.init();
			model_SYC.setDisplay_synchronisationRules(true);
		}	
		
		if(e.getSource()==this.view_addSynchronisationRule.getjBt_AddRulesSYC())
		{
			int dialogResult = JOptionPane.showConfirmDialog (this.view_addSynchronisationRule,
					"Confirmez vous l'ajout de cette R�gle","SYC message",JOptionPane.OK_CANCEL_OPTION);
			
			if(dialogResult == JOptionPane.OK_OPTION)
			{
				//add the new Rules
				
				//then go back to IHM_synchronisationRules
				model_SYC.init();
				model_SYC.setDisplay_synchronisationRules(true);
			}
		}	
		if(e.getSource()==this.view_addSynchronisationRule.getjCbx_DriveOwner())
		{
			
		}
		if(e.getSource()==this.view_addSynchronisationRule.getjCbx_FolderSelection())
		{
			
		}
		if(e.getSource()==this.view_addSynchronisationRule.getjCbx_DriveOwner1())
		{
			
		}
		if(e.getSource()==this.view_addSynchronisationRule.getjCbx_FolderSelection1())
		{
			
		}
	}	
}