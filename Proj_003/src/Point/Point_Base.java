package Point;

public class Point_Base {
	protected int x;
	protected int y;

	public Point_Base(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public void affiche () {
		System.out.println("point de coordonnées x = " + this.x + ", y = " + y);
	}
	public void deplace (int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}
}
