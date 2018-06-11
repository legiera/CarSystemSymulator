package agh.cs.lab2;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import agh.cs.lab3.Car;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab5.HayStack;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import agh.cs.lab4.UnboundedMap;

public class CarSystem {

	public static void main(String[] args) {
		
		MoveDirection[] directions = new OptionsParser().parse(args);
		
		List<HayStack> stacks = new ArrayList<>();
		stacks.add(new HayStack(new Position (-4,-4)));
		stacks.add(new HayStack(new Position (7,7)));
		stacks.add(new HayStack(new Position (3,6)));
		stacks.add(new HayStack(new Position (2,0)));
		
		IWorldMap map = new UnboundedMap(stacks);

		Car Fiat = new Car(map);
		Car Ford = new Car(map, 6, 7);
		Car Ferrari = new Car(map, 3, 6);
		map.add(Fiat);
		map.add(Ford);
		map.add(Ferrari);
		
		out.println(map.toString(map));
		map.run(directions);
		out.println(map.toString(map));
	}
}