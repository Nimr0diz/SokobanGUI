
package model.levels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import model.Position2D;
import model.entities.AbstractEntity;
import model.entities.Box;
import model.entities.BoxTarget;
import model.entities.Figure;
import model.entities.SolidEntity;
import model.entities.UnsolidEntity;
import model.entities.Wall;

//This class only represent the area that contain all the entities in the level and their position
public class LevelField implements Serializable{
	
	HashMap<Position2D,SolidEntity> solidMap;//This HashMap link each position to SolidEntity for access by position in O(1).
	HashMap<Position2D,UnsolidEntity> unsolidMap;//This HashMap link each position to UnsolidEntity for access by position in O(1).
	ArrayList<Figure> figureList;//This ArrayList allow me access to all Figures in O(1).
	ArrayList<Wall> wallList;//This ArrayList allow me access to all Walls in O(1).
	ArrayList<Box> boxList;//This ArrayList allow me access to all Boxes in O(1).
	ArrayList<BoxTarget> boxTargetList;//This ArrayList allow me access to all Box Targets in O(1).
	
	
	public LevelField() {
		this.solidMap = new HashMap<Position2D,SolidEntity>();
		this.unsolidMap = new HashMap<Position2D,UnsolidEntity>();
		this.figureList = new ArrayList<Figure>();
		this.wallList = new ArrayList<Wall>();
		this.boxList = new ArrayList<Box>();
		this.boxTargetList = new ArrayList<BoxTarget>();
	}
	
	public LevelField(LevelField field) {
		this.solidMap = new HashMap<Position2D,SolidEntity>(field.solidMap);
		this.unsolidMap = new HashMap<Position2D,UnsolidEntity>(field.unsolidMap);
		this.figureList = new ArrayList<Figure>(field.figureList);
		this.wallList = new ArrayList<Wall>(field.wallList);
		this.boxList = new ArrayList<Box>(field.boxList);
		this.boxTargetList = new ArrayList<BoxTarget>(field.boxTargetList);
	}

	public void addEntity(SolidEntity se)
	{
		solidMap.put(se.getPosition(), se);
		ArrayList<AbstractEntity> al = (ArrayList<AbstractEntity>)getArrayListOfSolid(se.getPosition());
		al.add(se);
	}
	public void addEntity(UnsolidEntity use)
	{
		unsolidMap.put(use.getPosition(), use);
		ArrayList<AbstractEntity> al = (ArrayList<AbstractEntity>)getArrayListOfUnsolid(use.getPosition());
		al.add(use);
	}
	public void removeSolidEntity(Position2D pos)
	{
		AbstractEntity ae = getSolidEntity(pos);
		ArrayList<? extends AbstractEntity> al = getArrayListOfSolid(pos);
		al.remove(ae);
		solidMap.remove(ae.getPosition());

	}
	public void removeUnsolidEntity(Position2D pos)
	{
		AbstractEntity ae = getUnsolidEntity(pos);
		ArrayList<? extends AbstractEntity> al = getArrayListOfUnsolid(pos);
		al.remove(ae);
		unsolidMap.remove(ae.getPosition());
		
	}
	
	public SolidEntity getSolidEntity(Position2D pos)
	{
		return solidMap.get(pos);
	}
	public UnsolidEntity getUnsolidEntity(Position2D pos)
	{
		return unsolidMap.get(pos);
	}
	
	public ArrayList<? extends AbstractEntity> getArrayListOfSolid(Position2D pos)
	{
		AbstractEntity ae = getSolidEntity(pos);
		if(ae instanceof Figure)
			return figureList;
		else if(ae instanceof Wall)
			return wallList;
		else if(ae instanceof Box)
			return boxList;
		else
			return null;
		
	}
	
	public ArrayList<? extends AbstractEntity> getArrayListOfUnsolid(Position2D pos)
	{
		AbstractEntity ae = getUnsolidEntity(pos);
		if(ae instanceof BoxTarget)
			return boxTargetList;
		else
			return null;
		
	}



	public HashMap<Position2D, SolidEntity> getSolidMap() {
		return solidMap;
	}

	public void setSolidMap(HashMap<Position2D, SolidEntity> solidMap) {
		this.solidMap = solidMap;
	}

	public HashMap<Position2D, UnsolidEntity> getUnsolidMap() {
		return unsolidMap;
	}

	public void setUnsolidMap(HashMap<Position2D, UnsolidEntity> unsolidMap) {
		this.unsolidMap = unsolidMap;
	}

	public ArrayList<Figure> getFigureList() {
		return figureList;
	}

	public void setFigureList(ArrayList<Figure> figureList) {
		this.figureList = figureList;
	}

	public ArrayList<Wall> getWallList() {
		return wallList;
	}

	public void setWallList(ArrayList<Wall> wallList) {
		this.wallList = wallList;
	}

	public ArrayList<Box> getBoxList() {
		return boxList;
	}

	public void setBoxList(ArrayList<Box> boxList) {
		this.boxList = boxList;
	}

	public ArrayList<BoxTarget> getBoxTargetList() {
		return boxTargetList;
	}

	public void setBoxTargetList(ArrayList<BoxTarget> boxTargetList) {
		this.boxTargetList = boxTargetList;
	}
	
	
}
