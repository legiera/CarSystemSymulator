package agh.cs.lab2;

public class Position {
	public final int x;
	public final int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;		
	}

	public int getPositionX() {
		return x;
	}
	
	public int getPositionY() {
		return y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public boolean smaller(Position that) {
		return this.x <= that.x && this.y <= that.y;
	}
	
	public boolean larger(Position that) {
		return this.x >= that.x && this.y >= that.y;
	}
	
	public Position add(Position that) {
		Position result = new Position(this.x + that.x, this.y + that.y);
		return result;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof Position))
			return false;
		Position that = (Position) other;
			if (this.x == that.x && this.y == that.y) return true;
			else return false;
	}
}