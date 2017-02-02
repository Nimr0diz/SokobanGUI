package view.settings;

import java.io.Serializable;
import java.util.HashMap;

import javafx.scene.input.KeyCode;

public class KeyboardHashMap implements Serializable{
	HashMap<String,KeyCode> keylist;
	
	public KeyboardHashMap() {
		keylist = new HashMap<String,KeyCode>();
	}
	
	public KeyCode getKey(String operation)
	{
		return keylist.get(operation);
	}
	
	public void setKey(String operation,KeyCode keycode)
	{
		keylist.put(operation, keycode);
	}

	public HashMap<String, KeyCode> getKeylist() {
		return keylist;
	}

	public void setKeylist(HashMap<String, KeyCode> keylist) {
		this.keylist = keylist;
	}

	
	
}
