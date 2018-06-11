package agh.cs.lab3;

import java.util.HashMap;
import java.util.Map;

import agh.cs.lab2.MoveDirection;

public class OptionsParser {
	private Map<String, MoveDirection> optionToDirections;
	
	
    public OptionsParser() {
        optionToDirections = new HashMap<String, MoveDirection>();  
        this.optionToDirections.put("f", MoveDirection.Forward);
        this.optionToDirections.put("forward", MoveDirection.Forward);
        this.optionToDirections.put("b", MoveDirection.Backward);
        this.optionToDirections.put("backward", MoveDirection.Backward);
        this.optionToDirections.put("r", MoveDirection.Right);
        this.optionToDirections.put("right", MoveDirection.Right);
        this.optionToDirections.put("l", MoveDirection.Left);
        this.optionToDirections.put("left", MoveDirection.Left);
    }

	public MoveDirection[] parse(String[] args){
		MoveDirection[] result = new MoveDirection[args.length];
		for (int i = 0; i < args.length; i++){
			MoveDirection direction = optionToDirections.get(args[i]);
			result[i] = direction; 
		}
		return result;
	}
}