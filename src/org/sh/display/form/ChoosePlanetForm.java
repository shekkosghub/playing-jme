package org.sh.display.form;



import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

import com.sh.display.service.DisplayService;

public class ChoosePlanetForm extends Form implements CommandListener {

	private static final String TITLE = "Choose your Planet";
	
	
	private ChoiceGroup planetChoice;
	
	private Command next;
	public ChoosePlanetForm(){
		super(TITLE);
		planetChoice      = new ChoiceGroup("Planets",ChoiceGroup.EXCLUSIVE);
		int len = AppConstants.planets.length;
		for(int i = 0; i<len;i++)
			planetChoice.append(AppConstants.planets[i], null);
		append(planetChoice);
		next = new Command(AppConstants.NEXT,Command.OK,1);
		addCommand(next);
		this.setCommandListener(this);

	}
	public void commandAction(Command c, Displayable d) {
		// TODO Auto-generated method stub
		c.getCommandType();
		if(c == next){
			PlanetDescriptionForm descFrm = new PlanetDescriptionForm(this.planetChoice.getString(this.planetChoice.getSelectedIndex()));
			DisplayService.setCurrentForm(descFrm);
		}
	}
	
	

}
