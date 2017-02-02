package model.entities.creators;

import java.util.HashMap;


//This class link each ASCII character to Entity Creator.
public class CharToEntity {
	HashMap<Character,SolidCreator> solidhm; //This HashMap link ASCII character to SolidEntity Creator
	HashMap<Character,UnsolidCreator> unsolidhm; //This HashMap link ASCII character to UnsolidEntity Creator
	
	public CharToEntity() {
		//Initializing HashMap.
		solidhm = new HashMap<Character,SolidCreator>();
		solidhm.put('#', new RegularWallCreator());
		solidhm.put('@', new RegularBoxCreator());
		solidhm.put('A', new RegularFigureCreator());
		
		//Initializing HashMap.
		unsolidhm = new HashMap<Character,UnsolidCreator>();
		unsolidhm.put('O', new RegularBoxTargetCreator());
		
	}
	
	//This method get char and return the concurrent SolidCreator
	public SolidCreator getSolidCreator(char c)
	{
		return solidhm.get(c); 
	}
	
	//This method get char and return the concurrent UnsolidCreator
	public UnsolidCreator getUnsolidCreator(char c)
	{
		return unsolidhm.get(c); 
	}
}
