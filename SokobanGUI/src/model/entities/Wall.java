package model.entities;

import model.Position2D;
import model.entities.policies.WallPolicy;

//This is the abstract super class of all the walls in the game.
//The SolidiEntity has Position (from AbstractEntity) and Policy (from SolidEntity).
public abstract class Wall extends SolidEntity {

	public Wall() {
		super(new WallPolicy());
	}
	
	public Wall(Position2D pos) {
		super(pos,new WallPolicy());

	}
	


}
