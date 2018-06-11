package agh.cs.lab1;

import static java.lang.System.out;

public class PrimitiveCarSystem {

	public static void main(String[] args){
		out.println("Start");
		run(convertArguments(args));
		out.println("Finish");
	}
	
	private static Direction[] convertArguments(String[] args){
		Direction[] result = new Direction[args.length];
		for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f":
                   result[i] = Direction.Forward;
                    break;
                case "b":
                    result[i] = Direction.Backward;
                    break;
                case "l":
                    result[i] = Direction.Left;
                    break;
                case "r":
                    result[i] = Direction.Right;
                    break;
                default:
                	break;
            }
        }
		return result;
	}
	
	private static void run (Direction[] directions){
		for (Direction direction : directions){
			switch(direction){
				case Forward:
					out.println("Moves forward");
					break;
				case Backward:
					out.println("Moves backward");
					break;
				case Left:
					out.println("Turns left");
					break;
				case Right:
					out.println("Turns right");
					break;
				default:
					break;				
			}
		}
	}
}