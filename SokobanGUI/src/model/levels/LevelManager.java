package model.levels;

import commons.Direction2D;
import model.Position2D;
import model.entities.RegularFigure;
import model.entities.SolidEntity;
import model.policies.SokobanPolicy;


//This class managing all the methods we will want to apply on the Level
public class LevelManager {
	Level level;
	SokobanPolicy policy;
	
	public LevelManager(Level level,SokobanPolicy policy) {
		this.level = level;
		this.policy = policy;
	}
	
	//This method move entity by his policy along a given Direction.
	public boolean move(SolidEntity se,Direction2D dir)
	{
		return policy.move(level, se, dir);
	}

	
	//This is a recursion method that check for each solid entity if the next one after able him to move or not

	
		
}

