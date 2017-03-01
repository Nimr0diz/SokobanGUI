package model.entities;

import commons.Direction2D;
import model.Position2D;
import model.entities.policies.EntityPolicy;

//This is the abstract super class of all the solid entities in the game.
//The SolidiEntity has Position (from AbstractEntity) and Policy.
public abstract class SolidEntity extends AbstractEntity{
	
	public SolidEntity() {
		super();
	}
	
	public SolidEntity(EntityPolicy policy)
	{
		this.policy = policy;
	}
	
	public SolidEntity(Position2D pos,EntityPolicy policy) {
		super(pos);
		this.policy = policy;
	}
	
	public EntityPolicy getPolicy() {
		return policy;
	}

	public void setPolicy(EntityPolicy policy) {
		this.policy = policy;
	}
	
	

}
