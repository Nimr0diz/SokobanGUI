package model.entities;

import commons.Direction2D;
import model.Position2D;
import model.entities.policies.DoorPolicy;
import model.entities.policies.EntityPolicy;

public abstract class Door extends UnsolidEntity {
	Direction2D enter;
	
	public Door() {
		super();
	}
	
	public Door(Direction2D enter) {
		super(new DoorPolicy(enter));
		this.enter = enter;
	}
	
	public Door(Position2D pos, Direction2D enter) {
		super(pos,new DoorPolicy(enter));
		this.enter = enter;
	}
	
}
