package model.policies;

import model.policies.movements.NoMovement;
import model.policies.shifitings.NoShifitng;

//This class represent policy of all the inanimate entities
public class WallPolicy extends Policy {
	public WallPolicy() {
		super(new NoMovement(),new NoShifitng());
	}
}
