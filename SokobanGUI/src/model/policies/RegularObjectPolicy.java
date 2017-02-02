package model.policies;

import model.policies.movements.RegularMovement;
import model.policies.shifitings.RegularShifting;

//This class represent regular moving and shifting policy.
public class RegularObjectPolicy extends Policy {
	public RegularObjectPolicy() {
		super(new RegularMovement(),new RegularShifting());
	}
}
