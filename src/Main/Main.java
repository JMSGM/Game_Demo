//Name: Joseph Mathew Sagum CSC 130-05
package Main;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

import Data.Vector2D;
import logic.Control;
import timer.stopWatchX;

public class Main{
	// Fields (Static) below...
	public static Queue<Vector2D> vecs1 = new LinkedList<>();
	public static Queue<Vector2D> vecs2 = new LinkedList<>();
	public static Color c = new Color(44, 169, 222);
	public static Vector2D currentVec = new Vector2D(-100, -100);
	public static stopWatchX time = new stopWatchX(50);
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		for(int x = -100; x <= 1408; x += 8) {
			vecs1.add(new Vector2D(x, 300));
		}
		
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		ctrl.addSpriteToFrontBuffer(currentVec.getX(), currentVec.getY(), "f1");				// Add a tester sprite to render list by tag (Remove later! Test only!)
		if(time.isTimeUp()) {
			if(!vecs1.isEmpty()) {
				currentVec = vecs1.remove();
				vecs2.add(new Vector2D(currentVec.getX(), currentVec.getY()));
				time.resetWatch();
			}else {
				while(!vecs2.isEmpty()) {
					vecs1.add(vecs2.remove());		
				}
			}
				 
		}
		
		
		ctrl.drawString(970, 640, "Joseph Mathew Sagum", c);		// Test drawing text on screen where you want (Remove later! Test only!)
	}
	
	// Additional Static methods below...(if needed)

}
