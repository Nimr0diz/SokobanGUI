package model.policies;

import commons.Direction2D;
import model.Position2D;
import model.entities.SolidEntity;
import model.levels.Level;

public class MySokobanPolicy implements SokobanPolicy{

	public MySokobanPolicy() {
	
	}
	
	@Override
	public boolean move(Level level, SolidEntity se, Direction2D dir) {
		SolidEntity base = se;
		SolidEntity nextEntity = getNextSolidEntity(level,base,dir);
		//System.out.println(level.getFirstFigure());
		if(recMove(level,nextEntity,dir,base.getPolicy().getShifting().getStrength()-1))
		{
			level.removeSolidEntity(se.getPosition());
			boolean isMove = se.move(dir);
			level.addEntity(se);
			return isMove;
		}
		return false;
	}

	private boolean recMove(Level level, SolidEntity se,Direction2D dir,int shiftLeft)
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
				if(recMove(level,neighbor,dir,shiftLeft-1))
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
	private SolidEntity getNextSolidEntity(Level level,SolidEntity se,Direction2D dir)
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
	
	/*
	 public boolean moveAndDrag(SolidEntity se, Direction2D dir)
	{
		Position2D oppositePos = new Position2D(se.getPosition());
		oppositePos.move(dir.getOppositeDirection(), 1);
		//Position2D nextPos = new Position2D(se.getPosition());
		//oppositePos.move(dir, 1);
		SolidEntity dragEntity = level.getSolidEntity(oppositePos);
		//SolidEntity nextEntity = level.getSolidEntity(nextPos);
		System.out.println(se);
		if(recMove(se,dir,0))
		{
			level.removeSolidEntity(dragEntity.getPosition());
			boolean isMove = dragEntity.move(dir);
			level.addEntity(dragEntity);
			return isMove;

		}
		return false;
	
		
	}
	 */
		
}

