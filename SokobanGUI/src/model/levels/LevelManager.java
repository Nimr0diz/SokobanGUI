package model.levels;

import commons.Direction2D;
import model.Position2D;
import model.entities.SolidEntity;


//This class managing all the methods we will want to apply on the Level
public class LevelManager {
	Level level;
	public LevelManager(Level level) {
		this.level = level;
	}
	
	//This method move entity by his policy along a given Direction.
	public boolean move(SolidEntity se,Direction2D dir)
	{
		SolidEntity base = se;
		SolidEntity nextEntity = getNextSolidEntity(base,dir);
		if(recMove(nextEntity,dir,base.getPolicy().getShifting().getStrength()-1))
		{
			se.move(dir);
			return true;
		}
		return false;
	}
	
	public boolean moveAndDrag(SolidEntity se, Direction2D dir)
	{
		Position2D oppositePos = new Position2D(se.getPosition());
		oppositePos.move(dir.getOppositeDirection(), 1);
		Position2D nextPos = new Position2D(se.getPosition());
		oppositePos.move(dir, 1);
		SolidEntity dragEntity = level.getSolidEntity(oppositePos);
		SolidEntity nextEntity = level.getSolidEntity(nextPos);
		if(nextEntity!=null)
		{
			return recMove(dragEntity, dir, 2);
		}
		return false;
		
	}
	
	//This is a recursion method that check for each solid entity if the next one after able him to move or not
	private boolean recMove(SolidEntity se,Direction2D dir,int shiftLeft)
	{
		if(se==null)
			return true;
		else
		{
			Position2D newPos = new Position2D(se.getPosition());
			newPos.move(dir,1);
			SolidEntity neighbor = level.getSolidEntity(newPos);
			if(neighbor==null) //There is EmptySpace
			{
				level.removeSolidEntity(se.getPosition());
				boolean isMove = se.move(dir);
				level.addEntity(se);
				return isMove;
			}
			if(shiftLeft!=0)
			{
				if(recMove(neighbor,dir,shiftLeft-1))
				{
					level.removeSolidEntity(neighbor.getPosition());
					boolean isMove = neighbor.move(dir);
					level.addEntity(neighbor);
					return isMove;
				}
			}
			
			return false;
		}
	}
	//This is private method that get the next solid entity the base entity will meet in his movement
	private SolidEntity getNextSolidEntity(SolidEntity se,Direction2D dir)
	{
		Position2D newPos = new Position2D(se.getPosition());
		se.getPolicy().getMovement().move(newPos,dir);
		Position2D tempPos = new Position2D(se.getPosition());
		SolidEntity tempNextSE;
		do{
			tempPos.move(dir,1);
			tempNextSE = level.getSolidEntity(tempPos);
		}while(tempNextSE==null && !tempPos.equals(newPos));
		return tempNextSE;
	}
	
		
}

