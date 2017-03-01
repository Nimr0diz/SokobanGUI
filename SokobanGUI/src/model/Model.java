package model;

import java.io.FileNotFoundException;
import java.io.IOException;

import commons.CommonEntity;
import commons.CommonLevel;
import commons.Direction2D;

public interface Model {
	public boolean move(Direction2D dir);
	public void load(String filepath,String filetype) throws Exception;
	public void save(String filepath,String filetype) throws Exception;
	public void restart();
	public CommonLevel getLevel();
	public void finishLevel();
	//public boolean moveAndDrag(Direction2D dir);
}
