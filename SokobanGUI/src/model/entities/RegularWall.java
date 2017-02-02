package model.entities;

import model.Position2D;

//This is the class of the ordinary Wall
//This Wall use Regular Object Policy
public class RegularWall extends Wall {
	public RegularWall() {
		super();
	}
	public RegularWall(Position2D position){
		super(position);
	}
}
