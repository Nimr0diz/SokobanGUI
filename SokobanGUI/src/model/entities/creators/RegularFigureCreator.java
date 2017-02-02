package model.entities.creators;

import model.entities.RegularFigure;
import model.entities.SolidEntity;

public class RegularFigureCreator implements SolidCreator {

	@Override
	//The method generate new RegularFigure.
	public SolidEntity create() {
		return new RegularFigure();
	}

}
