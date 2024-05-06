package Data;


public class Box {

	//field
private int x1, y1, x2, y2;
	//constructor

	public Box(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	//methods
	public int getX1() {
		return this.x1;
	}
	public int getY1() {
		return this.y1;
	}
	public int getX2() {
		return this.x2;
	}
	public int getY2() {
		return this.y2;
	}
	
	public void adjustX(int x) {
		this.x1 += x;
		this.x2 += x;
	}
	public void adjustY(int y) {
		this.y1 += y;
		this.y2 += y;
	}
	public static boolean hasCollided(Box b1, Box b2) {
		if(b2.getX1() > b1.getX2())
			return false;
		if(b2.getX2() < b1.getX1())
			return false;
		if(b2.getY2() < b1.getY1())
			return false;
		if(b2.getY1() > b1.getY2())
			return false;
		
		return true;
		
	}
}
