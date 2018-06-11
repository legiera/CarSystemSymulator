package agh.cs.lab2;

public enum MapDirection {
	North, East, South, West;
	
	public String toString() {
		switch(this){
		case North:
			return "Pó³noc";
		case South:
			return "Po³udnie";
		case West:
			return "Zachód";
		case East:
			return "Wschód";
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