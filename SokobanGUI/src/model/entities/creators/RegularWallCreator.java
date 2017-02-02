package model.entities.creators;

import model.entities.RegularWall;
import model.entities.SolidEntity;

public class RegularWallCreator implements SolidCreator {

	@Override
	//The method generate new RegularWall.
	public SolidEntity create() {
		return new RegularWall();
	}

}
