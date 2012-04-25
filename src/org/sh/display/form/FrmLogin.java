package org.sh.display.form;

import java.io.IOException;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextField;

import com.sh.display.service.DisplayService;
/**
 * 
 * @author XMBX249 Sergio Segura(Shekko)
 * 23/04/2012
 *
 */
public class FrmLogin extends Form implements CommandListener {

	private static final String TITLE = "Firma";
	private TextField tf_User;
	private TextField tf_Pass;
	private TextField tf_PassN;
	private Command cmdAceptar;
	private Command cmdSalir;
	private Image img;
	
	
	public FrmLogin(){
		super(TITLE);
	        setCommandListener(this);
	        tf_User = new TextField("Usuario","",20,TextField.ANY);
	        tf_Pass = new TextField("Clave","",16,TextField.PASSWORD);
	        tf_PassN = new TextField("Nueva","",16,TextField.PASSWORD);
	        cmdAceptar = new Command("Ingresar", Command.OK, 1);
	        cmdSalir = new Command("Salir", Command.EXIT, 2);
	        
	        //img = this.getImage();
	        //append(img);
	        
	        append(tf_User);
	        append(tf_Pass);
	        append(tf_PassN);
	        
	        addCommand(cmdAceptar);
	        addCommand(cmdSalir);
	}

	public void commandAction(Command c, Displayable d) {
		// TODO Auto-generated method stub
		if(c == cmdSalir){
			destroyForm();
			DisplayService.quit();
			System.gc();
		}else if(c == cmdAceptar){
			/*Alert ukey = new Alert("ukey!", 
					  "ukey Command Executed!", null, AlertType.INFO);
					  ukey.setTimeout(5000);
			DisplayService.setCurrentForm(ukey,this);
			*/
			ChoosePlanetForm planetForm = new ChoosePlanetForm();
			//PlanetDescriptionForm planetForm = new PlanetDescriptionForm();
			DisplayService.setCurrentForm(planetForm);
			
					  
			}
		
		
	}

	   protected void destroyForm() {
	        tf_User = null;
	        tf_Pass = null;
	        cmdAceptar  = null;
	        cmdSalir = null;
	        
	    }
	   
	   public Image getImage() {
	        try {        	
	            return(Image.createImage("Multiasistencia.PNG"));
	        } catch (IOException er) {            
	            System.out.println("IO Ekshepchion");
	        	er.printStackTrace();            
	        }catch(Exception e){
	        	System.out.println("Ekshepchion");
	        	e.printStackTrace();
	        }
	        return null;
	    }
}
