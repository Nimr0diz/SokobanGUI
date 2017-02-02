package model.entities;

import commons.Direction2D;
import model.Position2D;
import model.policies.Policy;

//This is the abstract super class of all the solid entities in the game.
//The SolidiEntity has Position (from AbstractEntity) and Policy.
public abstract class SolidEntity extends AbstractEntity{
	Policy policy;
	
	public SolidEntity() {
		super();
	}
	
	public SolidEntity(Policy policy)
	{
		this.policy = policy;
	}
	
	public SolidEntity(Position2D pos,Policy policy) {
		super(pos);
		this.policy = policy;
	}
	
	//This method change Entity's Position to specific direction by the policy movement method.
	public boolean move(Direction2D dir)
	{
		return policy.getMovement().move(position, dir);
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	
	

}
