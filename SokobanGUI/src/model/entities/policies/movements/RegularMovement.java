package model.entities.policies.movements;

import commons.Direction2D;
import model.Position2D;

//This class represent regular movement (move one step to each direction).
public class RegularMovement implements Movement {

	@Override
	public boolean move(Position2D pos, Direction2D dir) {
		pos.move(dir, 1);
		return true;
	}

}
