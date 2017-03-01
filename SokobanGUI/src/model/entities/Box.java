package model.entities;

import model.Position2D;
import model.entities.policies.EntityPolicy;


//This is the abstract super class of all the boxes in the game.
//The SolidiEntity has Position (from AbstractEntity) and Policy (from SolidEntity).
public abstract class Box extends SolidEntity {

	public Box() {
		super();
	}
	
	public Box(EntityPolicy policy)
	{
		this.policy = policy;
	}
	
	public Box(Position2D pos,EntityPolicy policy) {
		super(pos,policy);
		// TODO Auto-generated constructor stub
	}
	

}
