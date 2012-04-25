package org.sh.display.form;



import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

import com.sh.display.service.DisplayService;

public class PlanetDescriptionForm extends Form implements CommandListener {

	private static final String TITLE = "PLANET";
	private String choosenPlanet;
	private Command back;
	public PlanetDescriptionForm(){
		super(TITLE);
		back = new Command(AppConstants.BACK,Command.BACK,1);
	}
	
	public PlanetDescriptionForm(String label){
		super(label);
		back = new Command(AppConstants.BACK,Command.BACK,1);
		addCommand(back);
		this.setCommandListener(this);
		if(label.equals(AppConstants.planets[0])){
			append(AppConstants.MERCURY);
		}else if(label.equals(AppConstants.planets[1])){
			append(AppConstants.VENUS);
		}else
			append("building");
	}
	
	public void commandAction(Command c, Displayable d) {
		// TODO Auto-generated method stub
		if(c == this.back){
			ChoosePlanetForm planetChoose = new ChoosePlanetForm();
			DisplayService.setCurrentForm(planetChoose);
		}
	}

	/**
	 * @return the choosenPlanet
	 */
	public String getChoosenPlanet() {
		return choosenPlanet;
	}

	/**
	 * @param choosenPlanet the choosenPlanet to set
	 */
	public void setChoosenPlanet(String choosenPlanet) {
		this.choosenPlanet = choosenPlanet;
	}
	
	
	
	

}
