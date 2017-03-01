package model.entities.policies.shifitings;

//This class represent regular shifting (only one entity).
public class RegularShifting implements Shifting {

	@Override
	public int getStrength() {
		return 1;
	}

}
