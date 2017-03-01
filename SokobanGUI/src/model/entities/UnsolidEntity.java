package model.entities;

import model.Position2D;
import model.entities.policies.EntityPolicy;

//This is the abstract super class of all the no-solid entities in the game.
//The UnsolidiEntity has Position (from AbstractEntity).
public abstract class UnsolidEntity extends AbstractEntity {
	
	public UnsolidEntity() {
		super();
	}
	
	public UnsolidEntity(EntityPolicy policy)
	{
		this.policy = policy;
	}
	
	public UnsolidEntity(Position2D pos,EntityPolicy policy) {
		super(pos);
		this.policy = policy;
	}
	
	public UnsolidEntity(Position2D pos) {
		super(pos);
	}

	
	


}
