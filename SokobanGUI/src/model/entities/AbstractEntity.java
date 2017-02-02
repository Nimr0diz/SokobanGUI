package model.entities;

import java.io.Serializable;

import commons.CommonEntity;
import model.Position2D;

//This is the abstract super class of all entities in the game.
//It have only attribute of position in game.
public abstract class AbstractEntity implements Serializable{
	Position2D position;
	
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
	
	public CommonEntity getCommon()
	{
		return new CommonEntity(this.getClass().getSimpleName(), position.getCommon());
	}



	
}
