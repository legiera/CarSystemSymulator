package agh.cs.lab4;

import java.util.List;

import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab5.HayStack;

public class UnboundedMap extends AbstractWorldMap{

	public UnboundedMap(List<HayStack> stacks){	
		this.stacks = stacks;
	}
	
	@Override
	public boolean canMoveTo(Position position) {
		return !isOccupied(position);
	}

	@Override
	public Object objectAt(Position position) {
	Object object = super.objectAt(position);
	if(object != null) return object;
	for (HayStack stack : stacks){
		if (position.equals(stack.getPosition()))
				return stack;
	}
	return null;
	}
	
	@Override
	public String toString(IWorldMap map) {
		MapVisualizer visualizedMap = new MapVisualizer();	
		int minX = 0;
		int minY = 0;
		int maxX = 0;
		int maxY = 0;
		int x;
		int y;
		for (HayStack stack : stacks) {
			x = stack.getPosition().getPositionX();
			y = stack.getPosition().getPositionY();
			if (x < minX) minX = x;
			else if (x > maxX) maxX = x;
			if (y < minY) minY = y;
			else if (y > maxY) maxY = y;
		}
		for (Car car : cars) {
			x = car.getPosition().getPositionX();
			y = car.getPosition().getPositionY();
			if (x < minX) minX = x;
			else if (x > maxX) maxX = x;
			if (y < minY) minY = y;
			else if (y > maxY) maxY = y;
			}
		Position leftBound = new Position(minX,minY);
		Position rightBound = new Position(maxX,maxY);
		return visualizedMap.dump(map, leftBound, rightBound);
	}
}
