package model.entities;

import java.io.Serializable;

import model.Position2D;
import model.policies.Policy;



//This is the abstract super class of all the figures in the game.
//The SolidiEntity has Position (from AbstractEntity) and Policy (from SolidEntity).
public abstract class Figure extends SolidEntity implements Serializable{

	public Figure() {
		super();
	}
	
	public Figure(Policy policy)
	{
		super(policy);
	}
	
	public Figure(Position2D pos,Policy policy) {
		super(pos,policy);
	}
	
}
