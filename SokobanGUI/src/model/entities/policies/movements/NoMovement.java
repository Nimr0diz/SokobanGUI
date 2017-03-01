package model.entities.policies.movements;

import commons.Direction2D;
import model.Position2D;

//This class represent no movement. 
public class NoMovement implements Movement {

	@Override
	public boolean move(Position2D pos, Direction2D dir) {
		//No Movement
		return false;
	}

}
