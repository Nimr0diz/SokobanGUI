package view.settings;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class KeyboardHashMapLoader {

	public KeyboardHashMap load(String filepath) throws FileNotFoundException
	{
		KeyboardHashMap map = new KeyboardHashMap();
		XMLDecoder xml = new XMLDecoder(new FileInputStream(filepath));
		map = (KeyboardHashMap)xml.readObject();
		xml.close();
		return map;
	}
}
