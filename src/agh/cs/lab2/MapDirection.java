package agh.cs.lab2;

public enum MapDirection {
	North, East, South, West;
	
	public String toString() {
		switch(this){
		case North:
			return "P�noc";
		case South:
			return "Po�udnie";
		case West:
			return "Zach�d";
		case East:
			return "Wsch�d";
		default:
			return null;
		}
	}
	
	public MapDirection next() {
		return MapDirection.values()[(this.ordinal()+ 1) % 4];
	}
	
	public MapDirection previous() {
		return MapDirection.values()[(this.ordinal() +3) % 4];
	}
}