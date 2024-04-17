/* This will handle the "Hot Key" system. */

package Main;

import logic.Control;
import timer.stopWatchX;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			// For debouncing purposes
	private static stopWatchX sw = new stopWatchX(250);
	
	// Static Method(s)
	public static void processKey(char key){
		if(key == ' '){
			Main.isAKeyDown = false;
			Main.isDKeyDown = false;
			Main.isKeyDown = false;	
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
			Main.isKeyDown = true;
			Main.isAKeyDown = true;
			Main.wasAKeyDown = true;
			Main.wasDKeyDown = false;
			Main.trigger = "a is triggered";	
			break;
		case 'w':
			Main.isKeyDown = true;
			Main.trigger = "w is triggered";
			break;
		case 's':
			Main.isKeyDown = true;
			Main.trigger = "s is triggered";
			break;
		case 'd':
			Main.isDKeyDown = true;
			Main.wasAKeyDown = false;
			Main.wasDKeyDown = true;
			Main.trigger = "d is triggered";
			break;
		case '$':
			 Main.isKeyDown = true;
			Main.trigger = "space is triggered";
			break;
		case 'm':
			// For mouse coordinates
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;
		}
	}
}