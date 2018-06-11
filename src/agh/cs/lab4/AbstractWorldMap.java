package agh.cs.lab4;

import java.util.ArrayList;
import java.util.List;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab5.HayStack;

public class AbstractWorldMap implements IWorldMap  {

	protected List<Car> cars = new ArrayList<>();
	protected List<HayStack> stacks = new ArrayList<>();
	
	@Override
	public boolean canMoveTo(Position position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Car car) {	
		if(!isOccupied(car.getPosition()) && canMoveTo(car.getPosition())){
			cars.add(car);
			return true;
		}
		else 
			return false;
	}

	@Override
	public void run(MoveDirection[] directions) {
		int i = 0;
		for (MoveDirection direction : directions){
			cars.get(i % cars.size()).move(direction);
			i++;
		}
	}

	@Override
	public boolean isOccupied(Position position) {		
		if(objectAt(position)!=null) 
			return true;
		else 
			return false;

	}

	@Override
	public Object objectAt(Position position) {
		for (Car car : cars){
			if (position.equals(car.getPosition()))
					return car;
		}
		return null;
	}

	@Override
	public String toString(IWorldMap map) {
		// TODO Auto-generated method stub
		return null;
	}
}