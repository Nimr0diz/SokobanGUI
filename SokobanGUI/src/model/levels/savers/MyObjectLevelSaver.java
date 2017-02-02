package model.levels.savers;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import model.levels.Level;
//This class represent Level Saver base on regular binary loading
public class MyObjectLevelSaver implements LevelSaver {

	@Override
	public void saveLevel(Level level, OutputStream os) throws IOException{

		ObjectOutputStream ois;

			ois = new ObjectOutputStream(os);
			ois.writeObject(level);
			ois.close();
		
	}

}
