package model.policies;

import java.io.Serializable;

import model.policies.movements.Movement;
import model.policies.shifitings.Shifting;

//This abstract class is the super class of all the policies we will want to apply on Entity, how he moves and how much he can shift.
public abstract class Policy implements Serializable{
	Movement movement;
	Shifting shifting;
	
	public Policy() {
		
	}
	
	public Policy(Movement movement,Shifting shifting)
	{
		this.movement = movement;
		this.shifting = shifting;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public Shifting getShifting() {
		return shifting;
	}

	public void setShifting(Shifting shifting) {
		this.shifting = shifting;
	}
	
	
	
}
