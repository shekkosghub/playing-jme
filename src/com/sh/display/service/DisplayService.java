package com.sh.display.service;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import org.sh.display.form.FrmLogin;

public class DisplayService extends MIDlet {

	private static Display display;
	private static DisplayService instance;
	
	public DisplayService() {
		// TODO Auto-generated constructor stub
		display = Display.getDisplay(this);
		instance = this;
	}

	protected void destroyApp(boolean unconditional)
			throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		// TODO Auto-generated method stub
        try {            
            FrmLogin scrlogin = new FrmLogin();
            Display.getDisplay(this).setCurrent(scrlogin);
                        
        } catch (Exception err) {
            Alert a = new Alert("Error");
            a.setString("No se pudo crear la instancia de la clase");
            a.setTimeout(Alert.FOREVER);
            Display.getDisplay(this).setCurrent(a);
        } 
	}
	
	public static void setCurrentForm(Alert aviso, Displayable forma) {
        display.setCurrent(aviso,forma);
    } 

	  public static void setCurrentForm(Displayable forma) {
	        display.setCurrent(forma);
	    }
	  
	  public static void quit() {
	        instance.notifyDestroyed();
	        instance = null;
	    } 
}

