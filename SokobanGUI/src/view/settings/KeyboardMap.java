package view.settings;

import java.io.Serializable;

import javafx.scene.input.KeyCode;

public class KeyboardMap implements Serializable{
	KeyCode keyUp;
	KeyCode keyDown;
	KeyCode keyRight;
	KeyCode keyLeft;
	
	public KeyboardMap() {
		keyUp = null;
		keyDown = null;
		keyRight = null;
		keyLeft = null;
	}

	public KeyCode getKeyUp() {
		return keyUp;
	}

	public void setKeyUp(KeyCode keyUp) {
		this.keyUp = keyUp;
	}

	public KeyCode getKeyDown() {
		return keyDown;
	}

	public void setKeyDown(KeyCode keyDown) {
		this.keyDown = keyDown;
	}

	public KeyCode getKeyRight() {
		return keyRight;
	}

	public void setKeyRight(KeyCode keyRight) {
		this.keyRight = keyRight;
	}

	public KeyCode getKeyLeft() {
		return keyLeft;
	}

	public void setKeyLeft(KeyCode keyLeft) {
		this.keyLeft = keyLeft;
	}
	
	
}
