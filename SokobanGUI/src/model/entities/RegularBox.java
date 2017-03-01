package model.entities;

import model.Position2D;
import model.entities.policies.RegularObjectPolicy;;

//This is the class of the ordinary Box
//This Box use Regular Object Policy
public class RegularBox extends Box {
	public RegularBox() {
		super(new RegularObjectPolicy());
	}
	
	public RegularBox(Position2D position)
	{
		super(position,new RegularObjectPolicy());
	}
}
