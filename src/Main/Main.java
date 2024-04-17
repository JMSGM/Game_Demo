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
	public static stopWatchX time = new stopWatchX(60);
	public static ArrayList<spriteInfo> sprites = new ArrayList<>();
	public static ArrayList<spriteInfo> sprites2 = new ArrayList<>();

	public static int currentSpriteIndex = 0;
	public static EZFileRead ezr = new EZFileRead("VinnyDialog.txt");
	public static HashMap<String, String> map = new HashMap<>();
	public static String trigger = "";
	public static boolean isKeyDown = false;
	public static boolean isDKeyDown = false;
	public static boolean isAKeyDown = false;
	public static boolean wasDKeyDown = false;
	public static boolean wasAKeyDown = false;
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		
		//Right walk
		for(int x = -100; x <= 1280; x += 32) {
            sprites.add(new spriteInfo(new Vector2D(x , 300), "f0"));
            sprites.add(new spriteInfo(new Vector2D(x + 8, 300), "f1"));
            sprites.add(new spriteInfo(new Vector2D(x + 16, 300), "f2"));
            sprites.add(new spriteInfo(new Vector2D(x + 24, 300), "f3"));
		}
		for(int x = -100; x <= 1280; x += 32) {
            sprites2.add(new spriteInfo(new Vector2D(x , 300), "Lf0"));
            sprites2.add(new spriteInfo(new Vector2D(x + 8, 300), "Lf1"));
            sprites2.add(new spriteInfo(new Vector2D(x + 16, 300), "Lf2"));
            sprites2.add(new spriteInfo(new Vector2D(x + 24, 300), "Lf3"));
		}
		System.out.println(sprites.size());
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
	
		//Misc
		String vinnyLine = map.get("line2");
		ctrl.addSpriteToFrontBuffer(0, 0, "drop");
		ctrl.addSpriteToFrontBuffer(100, 100, "f1");
		ctrl.drawString(970, 640, "Joseph Mathew Sagum", c);
		
		spriteInfo si = sprites.get(currentSpriteIndex);
		spriteInfo si2 = sprites2.get(currentSpriteIndex);
		int end = sprites2.size()-1;
		
		//input logic
		if(wasAKeyDown == false && wasDKeyDown == true)
		ctrl.addSpriteToFrontBuffer(si.getCoords().getX() , si.getCoords().getY() , si.getTag());
		if(wasAKeyDown == true && wasDKeyDown == false)
		ctrl.addSpriteToFrontBuffer(si2.getCoords().getX() , si2.getCoords().getY() , si2.getTag());
		
		
		//Right Direction
		if(isDKeyDown == true) {
		ctrl.drawString(150, 250, trigger, c);
		
		
		if(time.isTimeUp()) {
			currentSpriteIndex++;
			if(currentSpriteIndex >= sprites.size()) {
			currentSpriteIndex = 0;
			} 
			time.resetWatch();	
		}	
		ctrl.drawString(970, 640, "Joseph Mathew Sagum", c);	
		}
		//Left Direction
		if(isAKeyDown == true) {
			ctrl.drawString(150, 250, trigger, c);
			if(time.isTimeUp()) {
				currentSpriteIndex  = currentSpriteIndex - 1;
				if(currentSpriteIndex <= 0) {
				currentSpriteIndex = end;
				} 
				time.resetWatch();	
			}	
		}

	}
	
	// Additional Static methods below...(if needed)

}
