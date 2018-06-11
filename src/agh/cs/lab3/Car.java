package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;

import agh.cs.lab4.IWorldMap;

public class Car {
	private MapDirection orientation = MapDirection.North;
	private Position position = new Position(2,2);
	
	public final IWorldMap map;
	
	public Car(IWorldMap map){
		this.map = map;
	}
		
	public Car(IWorldMap map, int x, int y){
		this.map = map;
		this.position = new Position(x,y);
	}
	
	public Position getPosition(){
		return this.position;
	}
		
	@Override
	public String toString() {
		switch(this.orientation){
		case North:
			return "N";
		case South:
			return "S";
		case West:
			return "W";
		case East:
			return "E";
		default:
			return null;
		}
	}
	
	public void move(MoveDirection direction) {
		switch(direction){
		case Right:
			this.orientation=this.orientation.next();
			break;
		case Left:
			this.orientation=this.orientation.previous();
			break;
		case Forward:	drive(1);
			return;
		case Backward:	drive(-1);
			return;
		}
	}
	
	public void drive(int distance) {
		Position newPosition = new Position(0,0);
		switch(orientation){
			case North:
				newPosition = this.position.add(new Position(0, distance));
				break;
			case South:
				newPosition = this.position.add(new Position(0, -distance));
				break;
			case East:
				newPosition = this.position.add(new Position(distance,0));
				break;
			case West:
				newPosition = this.position.add(new Position(-distance,0));	
				break;
		}
		if(map.canMoveTo(newPosition)){
			this.position = newPosition;
		}
	}
}