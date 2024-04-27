package Data;


public class Box {

	//field
private int x1, y1, x2, y2;
	//constructor

	public Box(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x1 = x2;
		this.y1 = y2;
	}
	//methods
	public int getX1() {
		return this.x1;
	}
	public int getY1() {
		return this.x1;
	}
	public int getX2() {
		return this.x1;
	}
	public int getY2() {
		return this.x1;
	}
	
	public void adjustX1(int X1) {
		this.x1 = X1;
	}
	public void adjustY1(int Y1) {
		this.y1 = Y1;
	}	
	
	public void adjustX2(int X2) {
		this.x2 = X2;
	}
	public void adjustY2(int Y2) {
		this.y2 = Y2;
	}

}
