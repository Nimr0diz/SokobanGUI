package model.entities;

import model.Position2D;
import model.entities.policies.RegularObjectPolicy;;

//This is the class of the ordinary Figure
//This Figure use Regular Object Policy
public class RegularFigure extends Figure {
	public RegularFigure() {
		super(new RegularObjectPolicy());
	}
	
	public RegularFigure(Position2D position) {
		super(position,new RegularObjectPolicy());

	}
}
