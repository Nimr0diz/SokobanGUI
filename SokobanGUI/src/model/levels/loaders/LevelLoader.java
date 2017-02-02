package model.levels.loaders;

import java.io.IOException;
import java.io.InputStream;

import model.levels.Level;


//Each loading method the user will use to load a level have its own LevelLoader class which implements from this interface.
public interface LevelLoader {
	//This method get any kind of InputStream, loads Level from it and return the Level.
	public Level loadLevel(InputStream in) throws IOException,ClassNotFoundException;
}
