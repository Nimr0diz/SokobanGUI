package model.entities;

import commons.Direction2D;
import model.Position2D;

public class RegularRightDoor extends Door {
	public RegularRightDoor() {
		super(Direction2D.RIGHT);
	}
	
	public RegularRightDoor(Position2D position){
		super(position,Direction2D.RIGHT);
	}
	
	
}
