package model.entities;

import commons.Direction2D;
import model.Position2D;
import model.entities.policies.movements.Movement;

public class UnsolidMovement implements Movement {

	@Override
	public boolean move(Position2D pos, Direction2D dir) {
		return true;
	}

}
