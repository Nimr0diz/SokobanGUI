package model.entities.creators;

import model.entities.RegularLeftDoor;
import model.entities.UnsolidEntity;

public class RegularLeftDoorCreator implements UnsolidCreator {

	@Override
	public UnsolidEntity create() {
		return new RegularLeftDoor();
	}

}
