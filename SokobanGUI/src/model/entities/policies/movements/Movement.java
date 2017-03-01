package model.entities.policies.movements;

import java.io.Serializable;

import commons.Direction2D;
import model.Position2D;

//Each movement we want to apply on an Entity will have its own Movement class which implements from it.
public interface Movement extends Serializable{
	//This method apply movement on Entity position and return if there is movement or not.
	public boolean move(Position2D pos,Direction2D dir);
}
