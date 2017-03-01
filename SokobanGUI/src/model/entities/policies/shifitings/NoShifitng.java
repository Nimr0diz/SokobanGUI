package model.entities.policies.shifitings;

//This class represent no shifting.
public class NoShifitng implements Shifting {

	@Override
	public int getStrength() {
		return 0;
	}

}
