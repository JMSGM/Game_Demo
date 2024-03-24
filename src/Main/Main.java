//Name: Joseph Mathew Sagum CSC 130-05
package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Data.Sprite;
import Data.Vector2D;
import Data.spriteInfo;
import logic.Control;
import timer.stopWatchX;

public class Main{
	// Fields (Static) below...
	public static Queue<Vector2D> vecs1 = new LinkedList<>();
	public static Queue<Vector2D> vecs2 = new LinkedList<>();
	public static Color c = new Color(44, 169, 222);
	public static Vector2D currentVec = new Vector2D(-100, -100);
	public static stopWatchX time = new stopWatchX(250);
	public static ArrayList<spriteInfo> sprites = new ArrayList<>();
	public static int currentSpriteIndex = 0;
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		
		for(int x = -100; x <= 1280; x += 32) {
            sprites.add(new spriteInfo(new Vector2D(x , 300), "f0"));
            sprites.add(new spriteInfo(new Vector2D(x + 8, 300), "f1"));
            sprites.add(new spriteInfo(new Vector2D(x + 16, 300), "f2"));
            sprites.add(new spriteInfo(new Vector2D(x + 24, 300), "f3"));
		}
	}
	
		
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)

		spriteInfo si = sprites.get(currentSpriteIndex);
		ctrl.addSpriteToFrontBuffer(si.getCoords().getX() , si.getCoords().getY() , si.getTag());	// Sprite
		if(time.isTimeUp()) {
			currentSpriteIndex++;
			if(currentSpriteIndex >= sprites.size()) {
			currentSpriteIndex = 0;
			} 
			time.resetWatch();	
		}	
		ctrl.drawString(970, 640, "Joseph Mathew Sagum", c);		
	}
	
	// Additional Static methods below...(if needed)

}
