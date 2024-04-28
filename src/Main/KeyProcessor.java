/* This will handle the "Hot Key" system. */

package Main;

import Data.Box;
import logic.Control;
import timer.stopWatchX;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			// For debouncing purposes
	private static stopWatchX sw = new stopWatchX(250);
	
	// Static Method(s)
	public static void processKey(char key){
		if(key == ' '){
			Main.isAKeyDown = 	false;
			Main.isDKeyDown = 	false;
			Main.isWKeyDown = 	false;	
			Main.isSKeyDown = 	false;
			
			return;
			}
		// Debounce routine below...
			
		if(key == last)
			if(sw.isTimeUp() == false)			return;
		last = key;
		sw.resetWatch();
		
		/* TODO: You can modify values below here! */
		switch(key){
		case '%':								// ESC key
			System.exit(0);
			break;
		case 'a':
			

			Main.isWKeyDown = false;
			Main.isAKeyDown =  true;
			Main.isSKeyDown = false;
			Main.isDKeyDown = false;	
				
			
			Main.wasWKeyDown = false;
			Main.wasAKeyDown =  true;
			Main.wasSKeyDown = false;
			Main.wasDKeyDown = false;
			Main.trigger = "a is triggered";	
			break;
		case 'w':
			Main.isWKeyDown =  true;
			Main.isAKeyDown = false;
			Main.isSKeyDown = false;
			Main.isDKeyDown = false;
			
			
			Main.wasWKeyDown =  true;
			Main.wasAKeyDown = false;
			Main.wasSKeyDown = false;
			Main.wasDKeyDown = false;
			Main.trigger = "w is triggered";
			break;
		case 's':
			Main.isWKeyDown = false;
			Main.isAKeyDown = false;
			Main.isSKeyDown =  true;
			Main.isDKeyDown = false;
			
			Main.wasWKeyDown = false;
			Main.wasAKeyDown = false;
			Main.wasSKeyDown =  true;
			Main.wasDKeyDown = false;
			Main.trigger = "s is triggered";
			break;
		case 'd':
		
			
			Main.isWKeyDown = false;
			Main.isAKeyDown = false;
			Main.isSKeyDown = false;
			Main.isDKeyDown =  true;
			
			Main.wasWKeyDown = false;
			Main.wasAKeyDown = false;
			Main.wasSKeyDown = false;
			Main.wasDKeyDown =  true;
			Main.trigger = "d is triggered";
			break;
		case '$':
			Main.trigger = "space is triggered";
			break;
		case 'm':
			// For mouse coordinates
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;
		}
	}
}