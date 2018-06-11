package agh.cs.lab2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void testToString() {
		assertEquals("(1,2)", new Position(1,2).toString());
		assertEquals(new Position(1,2).toString(), "(1,2)");
	}
	@Test
	public void testSmaller() {
		assertTrue(new Position(1,2).smaller(new Position(2,3)));
		assertFalse(new Position(1,2).smaller(new Position(0,1)));
	}
	@Test
	public void testLarger() {
		assertFalse(new Position(1,2).larger(new Position(2,3)));
		assertTrue(new Position(1,2).larger(new Position(0,1)));
	}
	@Test
	public void testAdd() {
		Position p1 = new Position(1,2);
		Position p2 = new Position(3,4);
		Position p3 = new Position(4,6);
		
		assertEquals(p1.add(p2), p3);
		assertEquals(p2.add(p1), p3);
	}
}