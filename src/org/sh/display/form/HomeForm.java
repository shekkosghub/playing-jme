package org.sh.display.form;

import java.io.IOException;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;

import com.sh.display.service.DisplayService;

public class HomeForm extends Form implements CommandListener {

	private static final String TITLE = "Inicio";
	private Image img;
	private Command cmdSalir;
	public HomeForm(){
		super(TITLE);
		//this.loadImage();
		//append(img);
		this.cmdSalir = new Command("Salir", Command.EXIT,1);
		this.addCommand(cmdSalir);
	}
	public void commandAction(Command c, Displayable d) {
		// TODO Auto-generated method stub
		if(c == cmdSalir){
			destroyForm();
			DisplayService.quit();
			System.gc();
		}

	}
	 protected void destroyForm() {
		 	img = null;
	        cmdSalir = null;
	    }
	
	
	private boolean loadImage(){
		boolean ok = true;
	     try {       
	    	 	img = Image.createImage("bear2.JPG");
	        } catch (IOException er) {            
	            System.out.println("IO Ekshepchion");
	        	er.printStackTrace();
	        	ok = false;
	        }catch(Exception e){
	        	System.out.println("Ekshepchion");
	        	e.printStackTrace();
	        	ok = false;
	        }
	        return ok;
	}

}
