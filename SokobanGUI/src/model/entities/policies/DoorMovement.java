package model.entities.policies;

import commons.Direction2D;
import model.Position2D;
import model.entities.policies.movements.Movement;

public class DoorMovement implements Movement {
	Direction2D enter;
	
	public DoorMovement(Direction2D enter) {
		this.enter=enter;
	}
	
	@Override
	public boolean move(Position2D pos, Direction2D dir) {
		return dir==enter;
	}

}
