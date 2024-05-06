//Name: Joseph Mathew Sagum CSC 130-05
package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


import Data.Vector2D;
import Data.spriteInfo;
import FileIO.EZFileRead;
import logic.Control;
import timer.stopWatchX;
import Data.Box;
public class Main{
	// Fields (Static) below...
	//Misc
	public static Color c = new Color(0, 0, 0);
	public static stopWatchX time = new stopWatchX(60);
	//Where Sprite animation is stored
	public static ArrayList<spriteInfo> sprites = new ArrayList<>();
	public static ArrayList<spriteInfo> sprites2 = new ArrayList<>();
	public static ArrayList<spriteInfo> sprites3 = new ArrayList<>();
	public static ArrayList<spriteInfo> sprites4 = new ArrayList<>();
	public static int currentSpriteIndex = 50;
	public static int currentSpriteIndex2 = 30;
	//In-game text
	public static EZFileRead ezr = new EZFileRead("VinnyDialog.txt");
	public static HashMap<String, String> map = new HashMap<>();
	//KeyProcessor booleans
	public static String trigger = "";
	public static boolean isWKeyDown = false;
	public static boolean isDKeyDown = false;
	public static boolean isAKeyDown = false;
	public static boolean isSKeyDown = false;
	
	public static boolean wasWKeyDown = false;
	public static boolean wasDKeyDown = false;
	public static boolean wasAKeyDown = false;
	public static boolean wasSKeyDown = true;
	public static boolean wasSpKeyDown = false;
	
	
	
	//Box collider
	public static ArrayList<Box> box = new ArrayList<>();
	public static Box vinBox = new Box(348, 147 , 374, 229);
	public static Box NPC1 = new Box(834, 285 , 894, 341);
	public static Box NPC2 = new Box(359, 365 , 434, 456);
	public static boolean wasCollision;
	public static boolean wasCollision2;
	
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		
		
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
		for(int y = -100; y <= 720; y += 32) {
            sprites3.add(new spriteInfo(new Vector2D(300 , y), "Ff0"));
            sprites3.add(new spriteInfo(new Vector2D(300, y + 8), "Ff1"));
            sprites3.add(new spriteInfo(new Vector2D(300, y + 16), "Ff2"));
            sprites3.add(new spriteInfo(new Vector2D(300, y + 24), "Ff3"));
		}
		for(int y = -100; y <= 720; y += 32) {
            sprites4.add(new spriteInfo(new Vector2D(300 , y), "Bf0"));
            sprites4.add(new spriteInfo(new Vector2D(300, y + 8), "Bf1"));
            sprites4.add(new spriteInfo(new Vector2D(300, y + 16), "Bf2"));
            sprites4.add(new spriteInfo(new Vector2D(300, y + 24), "Bf3"));
		}
		//add box objects
		box.add(new Box(0, 0, 1280, 85));
		box.add(new Box(0, 642, 1280, 720));
		box.add(new Box(0, 0, 64, 720));
		box.add(new Box(1230, 0 , 1280, 720));
		box.add(new Box(132, 122 , 277, 290));

		//Hashmap for in-game text
		System.out.println(sprites.size());
		for (int i = 0; i < ezr.getNumLines(); i++) {
		String raw = ezr.getLine(i);
		StringTokenizer st = new StringTokenizer(raw, "*");
		String Key = st.nextToken(); 
		String Value = st.nextToken();
		map.put(Key, Value);
		}
		
	}
	
		
	//Game Loop
	public static void update(Control ctrl) {
	
		//Dialog&Graphics
		String vinnyLine = map.get("line2");
		String vinnyLine2 = map.get("line1");
		ctrl.addSpriteToFrontBuffer(0, 0, "drop");
		ctrl.addSpriteToFrontBuffer(800, 250, "NPC1");
		ctrl.addSpriteToFrontBuffer(340, 360, "NPC2");
		

		spriteInfo si  =   sprites.get(currentSpriteIndex);
		spriteInfo si2 =  sprites2.get(currentSpriteIndex);
		spriteInfo si3 = sprites3.get(currentSpriteIndex2);
		spriteInfo si4 = sprites4.get(currentSpriteIndex2);
		


		//Collision logic
		if (wasCollision == true && wasSpKeyDown == true) {
			ctrl.drawString(500, 500, vinnyLine, c);		   
		}
		if (wasCollision2 == true && wasSpKeyDown == true) {
			ctrl.drawString(500, 500, vinnyLine2, c);  
		}
			//Border Collision
			for(Box b: box) {
				
				if(Box.hasCollided(vinBox, b)) {

					if(wasWKeyDown == true) {
						vinBox.adjustY(8);
						currentSpriteIndex2++;
					}
					if(wasAKeyDown == true) {
						vinBox.adjustX(8);
						currentSpriteIndex++;
					}
					if(wasSKeyDown == true) {
						vinBox.adjustY(-8);
						currentSpriteIndex2--;
					}
					if(wasDKeyDown == true) {
						vinBox.adjustX(-8);
						currentSpriteIndex--;
					}	
				}
			}	
					
			//NPC1 Collision 
			if(Box.hasCollided(vinBox, NPC1)) {
				if(wasWKeyDown == true) {
					wasCollision = true;
					vinBox.adjustY(8);
					currentSpriteIndex2++;
				}
				if(wasAKeyDown == true) {
					wasCollision = true;
					vinBox.adjustX(8);
					currentSpriteIndex++;
				}
				if(wasSKeyDown == true) {
					vinBox.adjustY(-8);
					currentSpriteIndex2--;
				}
				if(wasDKeyDown == true) {
					wasCollision = true;
					vinBox.adjustX(-8);
					currentSpriteIndex--;
				}
			}	
			//NPC2 Collision
			if(Box.hasCollided(vinBox, NPC2)) {
				if(wasWKeyDown == true) {
					wasCollision2 = true;
					vinBox.adjustY(8);
					currentSpriteIndex2++;
				}
				if(wasAKeyDown == true) {
					wasCollision2 = true;
					vinBox.adjustX(8);
					currentSpriteIndex++;
				}
				if(wasSKeyDown == true) {
					vinBox.adjustY(-8);
					currentSpriteIndex2--;
				}
				if(wasDKeyDown == true) {
					wasCollision2 = true;
					vinBox.adjustX(-8);
					currentSpriteIndex--;
				}
			}	

			

		//determine which sprite is shown to screen based on last key pressed
		if(wasWKeyDown == false && wasAKeyDown == false && wasSKeyDown == false && wasDKeyDown == true)
		ctrl.addSpriteToFrontBuffer(si.getCoords().getX() , si3.getCoords().getY() , si.getTag());
		if(wasWKeyDown == false && wasAKeyDown == true && wasSKeyDown == false && wasDKeyDown == false)
		ctrl.addSpriteToFrontBuffer(si2.getCoords().getX() , si3.getCoords().getY() , si2.getTag());
		if(wasWKeyDown == false && wasAKeyDown == false && wasSKeyDown == true && wasDKeyDown == false)
		ctrl.addSpriteToFrontBuffer(si.getCoords().getX() , si3.getCoords().getY() , si3.getTag());
		if(wasWKeyDown == true && wasAKeyDown == false && wasSKeyDown == false && wasDKeyDown == false)
		ctrl.addSpriteToFrontBuffer(si.getCoords().getX() , si4.getCoords().getY() , si4.getTag());
		

		//Right Direction - x direction
		if(isDKeyDown == true) {
			if(time.isTimeUp()) {
			currentSpriteIndex++;
			vinBox.adjustX(8); 
			wasCollision = false;
			wasCollision2 = false;
			wasSpKeyDown = false;
				if(currentSpriteIndex >= sprites.size()) {
					currentSpriteIndex = 0;
				} 
				time.resetWatch();
			}			
		}
		//Left Direction - x direction
		if(isAKeyDown == true) {
			if(time.isTimeUp()) {
				currentSpriteIndex  = currentSpriteIndex - 1;
				vinBox.adjustX(-8); 
				wasCollision = false;
				wasCollision2 = false;
				wasSpKeyDown = false;
					if(currentSpriteIndex <= 0) {
						currentSpriteIndex = sprites.size() - 1;
				} 
				time.resetWatch();	
			}	
		}
		//Forward Direction - y direction
		if(isSKeyDown == true) {
			if(time.isTimeUp()) {
			currentSpriteIndex2++;
			vinBox.adjustY(8); 
			wasCollision = false;
			wasCollision2 = false;
			wasSpKeyDown = false;
				if(currentSpriteIndex2 >= sprites3.size()-1) {
					currentSpriteIndex2 = 0;
				} 
				time.resetWatch();	
			}
		}
		//Backward Direction - y direction
		if(isWKeyDown == true) {
			if(time.isTimeUp()) {
				currentSpriteIndex2  = currentSpriteIndex2 - 1;
				vinBox.adjustY(-8); 
				wasCollision = false;
				wasCollision2 = false;
				wasSpKeyDown = false;
					if(currentSpriteIndex2 <= 0) {
						currentSpriteIndex2 = sprites4.size() - 1;
				} 
				time.resetWatch();	
			}	
		}	
	}

}