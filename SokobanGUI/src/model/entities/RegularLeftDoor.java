package model.entities;

import commons.Direction2D;
import model.Position2D;

public class RegularLeftDoor extends Door {
	public RegularLeftDoor() {
		super(Direction2D.LEFT);
	}
	
	public RegularLeftDoor(Position2D position){
		super(position,Direction2D.LEFT);
	}
	
	
}
