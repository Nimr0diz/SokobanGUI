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
		solidhm.put('L', new RegularBoxCreator());//Box + Left Door
		solidhm.put('R', new RegularBoxCreator());//Box + Right Door
		solidhm.put('l', new RegularFigureCreator());//Figure + Left Door
		solidhm.put('r', new RegularFigureCreator());//Figure + Right Door
		
		//Initializing HashMap.
		unsolidhm = new HashMap<Character,UnsolidCreator>();
		unsolidhm.put('O', new RegularBoxTargetCreator());
		unsolidhm.put('L', new RegularLeftDoorCreator());
		unsolidhm.put('l', new RegularLeftDoorCreator());
		unsolidhm.put('R', new RegularRightDoorCreator());
		unsolidhm.put('r', new RegularRightDoorCreator());
		
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
