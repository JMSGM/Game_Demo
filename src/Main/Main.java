//Name: Joseph Mathew Sagum CSC 130-05
package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import Data.Sprite;
import Data.Vector2D;
import Data.spriteInfo;
import FileIO.EZFileRead;
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
	public static EZFileRead ezr = new EZFileRead("VinnyDialog.txt");
	public static HashMap<String, String> map = new HashMap<>();
	public static String trigger = "";
	public static boolean isKeyDown = false;
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		
		
		for (int i = 0; i < ezr.getNumLines(); i++) {
		String raw = ezr.getLine(i);
		StringTokenizer st = new StringTokenizer(raw, "*");
		String Key = st.nextToken(); 
		String Value = st.nextToken();
		map.put(Key, Value);
		}
		
	}
	
		
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		String vinnyLine = map.get("line2");
		
		ctrl.addSpriteToFrontBuffer(0, 0, "drop");	// Sprite
		ctrl.addSpriteToFrontBuffer(0, 0, "f");
		ctrl.addSpriteToFrontBuffer(100, 100, "f1");
		
		ctrl.drawString(970, 640, "Joseph Mathew Sagum", c);
		if(isKeyDown == true) {
		ctrl.drawString(150, 250, trigger, c);
		}
	}
	
	// Additional Static methods below...(if needed)

}
