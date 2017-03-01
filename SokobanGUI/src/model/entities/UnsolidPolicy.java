package model.entities;

import model.entities.policies.EntityPolicy;
import model.entities.policies.movements.NoMovement;
import model.entities.policies.shifitings.NoShifitng;

public class UnsolidPolicy extends EntityPolicy {
	public UnsolidPolicy() {
		super(new UnsolidMovement(),new NoShifitng());
	}
}
