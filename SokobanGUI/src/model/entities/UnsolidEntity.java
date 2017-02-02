package model.entities;

import model.Position2D;

//This is the abstract super class of all the no-solid entities in the game.
//The UnsolidiEntity has Position (from AbstractEntity).
public abstract class UnsolidEntity extends AbstractEntity {
	
	public UnsolidEntity() {
		super();
	}
	
	public UnsolidEntity(Position2D pos) {
		super(pos);
	}

	
	


}
