package view.settings;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import model.levels.Level;

public class KeyboardMapLoader {
	
	public KeyboardMap load(String filepath) throws FileNotFoundException
	{
		KeyboardMap map = new KeyboardMap();
		XMLDecoder xml = new XMLDecoder(new FileInputStream(filepath));
		map = (KeyboardMap)xml.readObject();
		xml.close();
		return map;
	}
}
