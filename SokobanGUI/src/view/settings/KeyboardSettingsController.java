package view.settings;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.MainWindowController;

public class KeyboardSettingsController implements Initializable {
	@FXML
	BorderPane borderPane;
	@FXML
	TextField keyDragTextBox;
	@FXML
	TextField keyUpTextBox;
	@FXML
	TextField keyDownTextBox;
	@FXML
	TextField keyRightTextBox;
	@FXML
	TextField keyLeftTextBox;
	@FXML
	Button keyDragBtn;
	@FXML
	Button keyUpBtn;
	@FXML
	Button keyDownBtn;
	@FXML
	Button keyRightBtn;
	@FXML
	Button keyLeftBtn;
	
	MainWindowController parent;
	
	HashMap<Button,TextField> btnToText;
	HashMap<Button,String> btnToKeyCode;
	KeyboardHashMap keymap;
	
	EventHandler<MouseEvent> clickEvent;
	EventHandler<KeyEvent> inputEvent;

	Button currButton;
	
	public KeyboardSettingsController() {
		btnToText = new HashMap<Button,TextField>();
		btnToKeyCode = new HashMap<Button,String>();
		currButton=null;
	}
	/*public KeyboardSettingsController(MainWindowController parent) {
		this.parent = parent;
		btnToText = new HashMap<Button,TextField>();
		btnToKeyCode = new HashMap<Button,String>();
		currButton=null;

	}*/
	
	public void updateTextFields()
	{
		for(Map.Entry<Button,TextField> entry: btnToText.entrySet())
			entry.getValue().setText(keymap.getKey((btnToKeyCode.get(entry.getKey()))).getName());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnToText.put(keyDragBtn, keyDragTextBox);
		btnToText.put(keyUpBtn,keyUpTextBox);
		btnToText.put(keyDownBtn,keyDownTextBox);
		btnToText.put(keyLeftBtn,keyLeftTextBox);
		btnToText.put(keyRightBtn,keyRightTextBox);
		/*
		XMLEncoder xml;
		try {
			xml = new XMLEncoder(new FileOutputStream("./resources/keymap.xml"));
			KeyboardHashMap keyboardmap = new KeyboardHashMap();
			keyboardmap.setKey("Up", KeyCode.UP);
			keyboardmap.setKey("Down", KeyCode.DOWN);
			keyboardmap.setKey("Left", KeyCode.LEFT);
			keyboardmap.setKey("Right", KeyCode.RIGHT);
			keyboardmap.setKey("Drag", KeyCode.SHIFT);
			xml.writeObject(keymap);
			xml.flush();
			xml.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			keymap = new KeyboardHashMapLoader().load("./resources/keymap.xml");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		btnToKeyCode.put(keyDragBtn, "Drag");
		btnToKeyCode.put(keyUpBtn,"Up");
		btnToKeyCode.put(keyDownBtn,"Down");
		btnToKeyCode.put(keyLeftBtn,"Left");
		btnToKeyCode.put(keyRightBtn,"Right");
	/*	
		try {
			//keymap = new KeyboardMapLoader().load("keyset.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	*/
		//When I pressed on key what happened?
		borderPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(currButton!=null)
				{
					keymap.setKey(btnToKeyCode.get(currButton),event.getCode());//link the action of the clicked button to the last pressed key!!! 
					updateTextFields();
					currButton=null;
				}
			}
			
		});
		
		clickEvent = new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						currButton = (Button)(event.getSource());
						btnToText.get(currButton).setText("Press Any Key...");
					}
				});
			}
		};
		
		keyDragBtn.setOnMouseClicked(clickEvent);
		keyUpBtn.setOnMouseClicked(clickEvent);
		keyDownBtn.setOnMouseClicked(clickEvent);
		keyRightBtn.setOnMouseClicked(clickEvent);
		keyLeftBtn.setOnMouseClicked(clickEvent);
		
		updateTextFields();
		
	}
	
	public void saveChanges()
	{
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					XMLEncoder xml = new XMLEncoder(new FileOutputStream("./resources/keymap.xml"));
					xml.writeObject(keymap);
					xml.flush();
					xml.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				parent.updateKeyboardSettings(true);
				Stage stage = (Stage)borderPane.getScene().getWindow();
				stage.close();
			}
		});
		
	}
	
	public void setParent(MainWindowController parent)
	{
		this.parent = parent;
	}
}
