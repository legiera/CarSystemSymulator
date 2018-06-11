package agh.cs.lab4;

import agh.cs.lab2.Position;

public class RectangularMap extends AbstractWorldMap{
	public final int width;
	public final int height;
	
	public Position leftBound;
	public Position rightBound;
	
	public RectangularMap(int width, int height){
		this.width = width;
		this.height = height;
		leftBound = new Position (0,0);
		rightBound = new Position (width,height);
	}
		
	@Override
	public boolean canMoveTo(Position position) {
		return (position.larger(leftBound) && position.smaller(rightBound) && !isOccupied(position));
	}

	@Override
	public String toString(IWorldMap map){
		MapVisualizer visualizedMap = new MapVisualizer();
		return visualizedMap.dump(map, leftBound, rightBound);
	}
}