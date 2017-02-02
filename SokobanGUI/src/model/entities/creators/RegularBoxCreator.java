package model.entities.creators;

import model.entities.RegularBox;
import model.entities.SolidEntity;

public class RegularBoxCreator implements SolidCreator {

	@Override
	//The method generate new RegularBox.
	public SolidEntity create() {
		return new RegularBox();
	}

}
