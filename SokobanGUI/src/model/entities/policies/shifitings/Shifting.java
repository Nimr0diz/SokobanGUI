package model.entities.policies.shifitings;

import java.io.Serializable;
//Each shifting power will have its own Shifting class which implements it.
public interface Shifting extends Serializable{
	//This method return how much an entity can shift.
	public int getStrength();
}
