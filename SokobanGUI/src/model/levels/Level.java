package model.levels;

import java.io.Serializable;
import java.util.ArrayList;

import commons.CommonEntity;
import commons.CommonLevel;
import model.Position2D;
import model.entities.Box;
import model.entities.BoxTarget;
import model.entities.Figure;
import model.entities.SolidEntity;
import model.entities.UnsolidEntity;

//This class represent a game level, Each level have is own Level Object with the field (LevelField) and the current score.
public class Level implements Serializable, Cloneable{
	LevelField field;
	int score;
	
	public Level() {
		this.field = new LevelField();
		this.score = 0;
	}
	
	public Level(Level level)
	{
		this.field = new LevelField(level.field);
		this.score = level.score;
	}
	
	public Object clone() throws CloneNotSupportedException{  
		return super.clone();  
	}  
	public CommonLevel getCommon()
	{
		SolidEntity[] seArray = getSolidArray();
		UnsolidEntity[] useArray = getUnsolidArray();
		String[][] field = new String[getHeight()][getWidth()];
		CommonEntity[] entities = new CommonEntity[seArray.length+useArray.length];
		for(int i=0;i<getHeight();i++)
			for(int j=0;j<getWidth();j++)
				field[i][j] = "";
		for(int i=0;i<useArray.length;i++)
		{
			UnsolidEntity tempEntity = useArray[i];
			field[tempEntity.getPosition().getY()][tempEntity.getPosition().getX()] = tempEntity.getCommon().getType();
			entities[i] = tempEntity.getCommon();
		}
		
		for(int i=0;i<seArray.length;i++)
		{
			SolidEntity tempEntity = seArray[i];
			if(field[tempEntity.getPosition().getY()][tempEntity.getPosition().getX()].equals("RegularBoxTarget"))
				field[tempEntity.getPosition().getY()][tempEntity.getPosition().getX()]+= " "+tempEntity.getCommon().getType();
			else
				field[tempEntity.getPosition().getY()][tempEntity.getPosition().getX()]=tempEntity.getCommon().getType();
			//field[tempEntity.getPosition().getY()][tempEntity.getPosition().getX()] = tempEntity.getCommon().getType();
			entities[i+useArray.length] = tempEntity.getCommon();
		}
		
		return new CommonLevel(field,entities);
	}
	
	public void addEntity(SolidEntity se)
	{
		field.addEntity(se);
	}
	
	public void addEntity(UnsolidEntity use)
	{
		field.addEntity(use);
	}
	
	public void removeSolidEntity(Position2D pos)
	{
		field.removeSolidEntity(pos);
	}
	
	public void removeUnsolidEntity(Position2D pos)
	{
		field.removeUnsolidEntity(pos);
	}
	
	public SolidEntity getSolidEntity(Position2D pos)
	{
		return field.getSolidEntity(pos);
	}
	public UnsolidEntity getUnsolidEntity(Position2D pos)
	{
		return field.getUnsolidEntity(pos);
	}
	
	public int getBoxesInPlace()
	{
		int boxesInPlace = 0;
		ArrayList<BoxTarget> al = field.getBoxTargetList();
		for(int i=0;i<al.size();i++)
		{
			if(getSolidEntity(al.get(i).getPosition())!=null)
				if(getSolidEntity(al.get(i).getPosition()) instanceof Box)
					boxesInPlace++;
		}
		return boxesInPlace;
	}
	
	public int getBoxesLeft(){
		return field.getBoxTargetList().size()-getBoxesInPlace();
	}
	
	public int getWidth()
	{
		SolidEntity[] solidArray = this.getSolidArray();
		
		int width = 0;
		
		//This loop run over all the solid entities and set width and height of the level
		for(int i=0;i<solidArray.length;i++)
		{
			Position2D temp = solidArray[i].getPosition(); 
			if(temp.getX()>width)
				width = temp.getX();
		}
		width++;
		return width;
	}
	
	public int getHeight()
	{
		SolidEntity[] solidArray = this.getSolidArray();
		
		int height = 0;
		
		//This loop run over all the solid entities and set width and height of the level
		for(int i=0;i<solidArray.length;i++)
		{
			Position2D temp = solidArray[i].getPosition(); 
			if(temp.getY()>height)
				height = temp.getY();
		}
		height++;
		return height;
	}
	
	public SolidEntity[] getSolidArray()
	{
		return field.getSolidMap().values().toArray(new SolidEntity[0]);//Take the HashMap of the solid entities and copy it to array
	}
	
	public UnsolidEntity[] getUnsolidArray()
	{
		return field.getUnsolidMap().values().toArray(new UnsolidEntity[0]);//Take the HashMap of the no-solid entities and copy it to array
	}
	
	public Figure getFirstFigure()
	{
		return field.getFigureList().get(0);
	}

	public LevelField getField() {
		return field;
	}

	public void setField(LevelField field) {
		this.field = field;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
