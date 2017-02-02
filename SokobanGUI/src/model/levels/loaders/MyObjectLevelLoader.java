package model.levels.loaders;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import model.levels.Level;

//This class represent Level Loader base on regular binary loading
public class MyObjectLevelLoader implements LevelLoader {

	@Override
	public Level loadLevel(InputStream in) throws IOException,ClassNotFoundException{
		Level level=null;
		ObjectInputStream ois;

			ois = new ObjectInputStream(in);
			level = (Level)ois.readObject();
	
		return level;
	}

}
