package model.entities.creators;

import model.entities.RegularBoxTarget;
import model.entities.UnsolidEntity;

public class RegularBoxTargetCreator implements UnsolidCreator {

	@Override
	//The method generate new BoxTarget.
	public UnsolidEntity create() {
		return new RegularBoxTarget();
	}

}
