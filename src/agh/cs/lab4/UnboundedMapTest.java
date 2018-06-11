package agh.cs.lab4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab5.HayStack;

public class UnboundedMapTest {

	@Test
	public void testCanMoveTo() {
		List<HayStack> stacks = new ArrayList<>();
		stacks.add(new HayStack(new Position (0,0)));
		UnboundedMap map = new UnboundedMap(stacks);
		Car car = new Car(map,1,1);
		map.add(car);
		assertTrue(map.canMoveTo(new Position(8,7)));
		assertFalse(map.canMoveTo(new Position(1,1)));
		assertFalse(map.canMoveTo(new Position(0,0)));
	}
	
	@Test
	public void testAdd(){
		List<HayStack> stacks = new ArrayList<>();
		stacks.add(new HayStack(new Position (0,0)));
		UnboundedMap map = new UnboundedMap(stacks);
		assertTrue(map.add(new Car(map,2,2)));
		assertFalse(map.add(new Car(map,0,0)));
		assertFalse(map.add(new Car(map,2,2)));
	}
	
	@Test
	public void testRun(){
		List<HayStack> stacks = new ArrayList<>();
		stacks.add(new HayStack(new Position (2,2)));
		UnboundedMap map = new UnboundedMap(stacks);
		Car car1 = new Car(map,1,1);
		Car car2 = new Car(map,2,1);
		map.add(car1);
		map.add(car2);
		MoveDirection[] directions = {MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Left, MoveDirection.Right};
		map.run(directions);
		assertEquals(car1.getPosition(), new Position(1,2));
		assertEquals(car1.toString(), "W");
		assertEquals(car2.getPosition(), new Position(2,1));
		assertEquals(car2.toString(), "E");
	}
	
	@Test
	public void testIsOccupied(){
		List<HayStack> stacks = new ArrayList<>();
		stacks.add(new HayStack(new Position (0,0)));
		UnboundedMap map = new UnboundedMap(stacks);
		Car car = new Car(map,1,1);
		map.add(car);
		assertTrue(map.isOccupied(new Position(0,0)));
		assertTrue(map.isOccupied(new Position(1,1)));
		assertFalse(map.isOccupied(new Position(5,5)));
	}
	
	@Test
	public void testObjectAt(){
		List<HayStack> stacks = new ArrayList<>();
		stacks.add(new HayStack(new Position (0,0)));
		UnboundedMap map = new UnboundedMap(stacks);
		Car car = new Car(map,1,1);
		map.add(car);
		assertEquals(map.objectAt(new Position(1,1)), car);
		assertEquals(map.objectAt(new Position(0,0)), stacks.get(0));
		assertEquals(map.objectAt(new Position(5,5)), null);
	}
}