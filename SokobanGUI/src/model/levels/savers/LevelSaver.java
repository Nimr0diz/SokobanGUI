package model.levels.savers;

import java.io.IOException;
import java.io.OutputStream;

import model.levels.Level;

//Each Saving method the user will use to save a level have its own LevelSaver class which implements from this interface.
public interface LevelSaver {
	//This method get any kind of OutputStream and save a Level into it.
	public void saveLevel(Level level, OutputStream os) throws IOException;
}
