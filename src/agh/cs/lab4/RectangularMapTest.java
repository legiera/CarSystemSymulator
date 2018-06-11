package agh.cs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;

public class RectangularMapTest {

	@Test
	public void testCanMoveTo() {
		RectangularMap map = new RectangularMap(3,3);
		map.add(new Car(map,2,2));
		assertTrue(map.canMoveTo(new Position(1,1)));
		assertFalse(map.canMoveTo(new Position(4,4)));
		assertFalse(map.canMoveTo(new Position(2,2)));
	}

	@Test
	public void testAdd(){
		RectangularMap map = new RectangularMap(3,3);
		assertTrue(map.add(new Car(map,2,2)));
		assertFalse(map.add(new Car(map,2,2)));
		assertFalse(map.add(new Car(map,4,4)));
	}
	
	@Test
	public void testRun(){
		RectangularMap map = new RectangularMap(3,3);
		Car car1 = new Car(map,1,1);
		Car car2 = new Car(map,2,1);
		map.add(car1);
		map.add(car2);
		MoveDirection[] directions = {MoveDirection.Forward, MoveDirection.Backward};
		map.run(directions);
		assertEquals(car1.getPosition(), new Position(1,2));
		assertEquals(car1.toString(), "N");
		assertEquals(car2.getPosition(), new Position(2,0));
		assertEquals(car2.toString(), "N");
	}
	
	@Test
	public void testIsOccupied(){
		RectangularMap map = new RectangularMap(3,3);
		map.add(new Car(map,1,1));
		assertTrue(map.isOccupied(new Position(1,1)));
		assertFalse(map.isOccupied(new Position(2,2)));
		assertFalse(map.isOccupied(new Position(5,2)));
	}
	
	@Test
	public void testObjectAt(){
		RectangularMap map = new RectangularMap(3,3);
		Car car = new Car(map,1,1);
		map.add(car);
		assertEquals(map.objectAt(new Position(1,1)), car);
		assertEquals(map.objectAt(new Position(2,2)), null);
	}
}