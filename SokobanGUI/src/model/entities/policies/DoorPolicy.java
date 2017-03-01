package model.entities.policies;

import commons.Direction2D;
import model.entities.policies.shifitings.NoShifitng;

public class DoorPolicy extends EntityPolicy {
	public DoorPolicy(Direction2D enter) {
		super(new DoorMovement(enter),new NoShifitng());
	}
}
