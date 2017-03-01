package model.entities.creators;

import model.entities.RegularRightDoor;
import model.entities.UnsolidEntity;

public class RegularRightDoorCreator implements UnsolidCreator {

	@Override
	public UnsolidEntity create() {
		return new RegularRightDoor();
	}

}
