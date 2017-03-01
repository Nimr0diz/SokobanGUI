package model.entities;

import java.io.Serializable;

import commons.CommonEntity;
import commons.Direction2D;
import model.Position2D;
import model.entities.policies.EntityPolicy;

//This is the abstract super class of all entities in the game.
//It have only attribute of position in game.
public abstract class AbstractEntity implements Serializable{
	Position2D position;
	EntityPolicy policy;
	
	public AbstractEntity() {
		this.position = null;
	}
	
	public AbstractEntity(Position2D pos) {
		this.position = pos;
	}

	public Position2D getPosition() {
		return position;
	}

	public void setPosition(Position2D position) {
		this.position = position;
	}
	
	//This method change Entity's Position to specific direction by the policy movement method.
	public boolean move(Direction2D dir)
	{
		return policy.getMovement().move(position, dir);
	}

	
	
	public CommonEntity getCommon()
	{
		return new CommonEntity(this.getClass().getSimpleName(), position.getCommon());
	}



	
}
