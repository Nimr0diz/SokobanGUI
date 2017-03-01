package model.entities.policies;

import model.entities.policies.movements.RegularMovement;
import model.entities.policies.shifitings.RegularShifting;

//This class represent regular moving and shifting policy.
public class RegularObjectPolicy extends EntityPolicy {
	public RegularObjectPolicy() {
		super(new RegularMovement(),new RegularShifting());
	}
}
