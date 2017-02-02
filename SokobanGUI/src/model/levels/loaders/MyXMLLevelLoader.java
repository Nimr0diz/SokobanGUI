package model.levels.loaders;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;

import model.levels.Level;

//This class represent Level Loader base on XML loading
public class MyXMLLevelLoader implements LevelLoader {

	@Override
	public Level loadLevel(InputStream in) {
		Level level = new Level();
		XMLDecoder xml = new XMLDecoder(in);
		level = (Level)xml.readObject();
		xml.close();
		return level;
	}

}
