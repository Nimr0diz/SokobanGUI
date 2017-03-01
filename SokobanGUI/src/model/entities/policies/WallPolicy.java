package model.entities.policies;

import model.entities.policies.movements.NoMovement;
import model.entities.policies.shifitings.NoShifitng;

//This class represent policy of all the inanimate entities
public class WallPolicy extends EntityPolicy {
	public WallPolicy() {
		super(new NoMovement(),new NoShifitng());
	}
}
