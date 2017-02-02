package model.entities.creators;

import model.entities.UnsolidEntity;

//Each UnsolidEntity we have in the game has its own creator class which implements from this interface.
public interface UnsolidCreator {
	//create method produce the specific entity for each creator. 
	public UnsolidEntity create();
}
