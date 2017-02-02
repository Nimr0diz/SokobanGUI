package model.entities.creators;

import model.entities.SolidEntity;

//Each SolidEntity we have in the game has its own creator class which implements from this interface.
public interface SolidCreator {
	//create method produce the specific entity for each creator. 
	public SolidEntity create();
}
