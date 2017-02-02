package model.levels.savers;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.OutputStream;

import model.levels.Level;
//This class represent Level Saver base on XML Saving
public class MyXMLLevelSaver implements LevelSaver {

	@Override
	public void saveLevel(Level level, OutputStream os) throws IOException {
		XMLEncoder xml = new XMLEncoder(os);
		xml.writeObject(level);
		xml.close();
		
	}

}
