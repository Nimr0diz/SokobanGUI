package view;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Stack;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import commons.CommonLevel;
import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.WindowEvent;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import view.settings.KeyboardHashMap;
import view.settings.KeyboardHashMapLoader;
import view.settings.KeyboardMap;
import view.settings.KeyboardMapLoader;
import view.settings.KeyboardSettingsController;

public class MainWindowController extends Observable implements Initializable, View{
	@FXML
	BorderPane mainStage;
	@FXML
	SokobanDisplayer fieldData;
	@FXML
	Button startBtn;
	@FXML
	Button restartBtn;
	@FXML
	Button stopBtn;
	@FXML
	Label stepsField;
	@FXML
	Label timeField;
	
	KeyboardMap keyboardMap;
	static KeyboardHashMap keyboardHashMap;
	GameStatus status;
	
	int steps;
	int time;
	
	
	Timer timer;
	
	MediaPlayer mediaPlayer;
	boolean enableMusic;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		updateStatus(GameStatus.PRELOAD);
		steps=0;
		time=0;
		//steps.set(0);
		//steps=0;
		startBtn.setFocusTraversable(false);
		restartBtn.setFocusTraversable(false);
		stopBtn.setFocusTraversable(false);
		
		fieldData.initImageMap();
/*
		keyboardMap = new KeyboardMap();
		keyboardMap.setKeyUp(KeyCode.UP);
		keyboardMap.setKeyDown(KeyCode.DOWN);
		keyboardMap.setKeyLeft(KeyCode.LEFT);
		keyboardMap.setKeyRight(KeyCode.RIGHT);
		
		try {
			XMLEncoder xml = new XMLEncoder(new FileOutputStream("keyset.xml"));
			xml.writeObject(keyboardMap);
			xml.flush();
			xml.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		/*
		keyboardHashMap = new KeyboardHashMap();
		keyboardHashMap.setKey("Up",KeyCode.UP);
		keyboardHashMap.setKey("Down",KeyCode.DOWN);
		keyboardHashMap.setKey("Left",KeyCode.LEFT);
		keyboardHashMap.setKey("Right",KeyCode.RIGHT);
		
		try {
			XMLEncoder xml = new XMLEncoder(new FileOutputStream("keymap.xml"));
			xml.writeObject(keyboardHashMap);
			xml.flush();
			xml.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		//Media sound = new Media("./resources/backgroundSound.mp3");
		//Media sound = new Media(new File("./resources/backgroundSound.mp3").toURI().toString());
		Media media = new Media(new File("./resources/backgroundSound.wav").toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		//mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(Animation.INDEFINITE);
		MediaView mediaView = new MediaView(mediaPlayer);
		mediaPlayer.play();
		enableMusic=true;
		
		timer = new Timer(new Runnable() {
			
			@Override
			public void run() {
				time++;
				updateTime(time);
			}
		});
		
			//keyboardMap = new KeyboardMapLoader().load("keyset.xml");
			updateKeyboardSettings(false);
		
		fieldData.addEventFilter(MouseEvent.MOUSE_CLICKED, (e)->fieldData.requestFocus());

		fieldData.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event)
			{
				if(status==GameStatus.PLAYING)
				{
					String notifyString = "Move ";
					if(event.getCode() == keyboardHashMap.getKey("Down"))
						notifyString+="Down";
					else if(event.getCode() == keyboardHashMap.getKey("Up"))
						notifyString+="Up";
					else if(event.getCode() == keyboardHashMap.getKey("Right"))
						notifyString+="Right";	
					else if(event.getCode() == keyboardHashMap.getKey("Left"))
						notifyString+="Left";
					else
						return;
					setChanged();
					notifyObservers(notifyString);
				}
			}
		});
		
	}
	
	
	public void openFile()
	{
		FileChooser fc = new FileChooser();
		fc.setTitle("Open Level File");
		fc.setInitialDirectory(new File("./levels"));
		fc.getExtensionFilters().add(new ExtensionFilter ("Level File (*.txt; *.obj; *.xml)", "*.txt", "*.obj","*.xml"));
		//fc.setSelectedExtensionFilter(new ExtensionFilter("Level File", exts));
		File levelFile = fc.showOpenDialog(mainStage.getScene().getWindow());//change the F*cking NULL
		if(levelFile!=null)
		{
			setChanged();
			notifyObservers("Load "+levelFile.getPath());
		}
	}
	
	public void saveFile()
	{
		FileChooser fc= new FileChooser();
		fc.setTitle("Save Level");
		fc.setInitialDirectory(new File("./levels"));
		fc.getExtensionFilters().add(new ExtensionFilter("Text File (*.txt)","*.txt"));
		fc.getExtensionFilters().add(new ExtensionFilter("Object File (*.obj)","*.obj"));
		fc.getExtensionFilters().add(new ExtensionFilter("XML File (*.xml)","*.xml"));
		File levelFile=fc.showSaveDialog(mainStage.getScene().getWindow());
		if(levelFile!=null)
		{
			setChanged();
			notifyObservers("Save "+levelFile.getPath());
		}
		
	}
	
	public void startGame()
	{
		if(status==GameStatus.LOADED)
		{
			updateStatus(GameStatus.PLAYING);
			timer.start();
		}
	}
	
	public void stopGame()
	{
		updateStatus(GameStatus.LOADED);
		timer.stop();
	}
	
	public void resetLevel()
	{
		setChanged();
		notifyObservers("Reset");
		updateStatus(GameStatus.LOADED);
	}
	
	public void closeWindow()
	{
		setChanged();
		notifyObservers("Exit");
	}
	

	@Override
	public void showSaveLevelMessage(boolean succeed, String params) {
		System.out.println(params);
		Platform.runLater(new Runnable()
		{
			@Override
			public void run()
			{
				Alert alert;
				if(succeed)
				{
					alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("Level Saved Successfully!");
				}
				else
				{
					alert= new Alert(AlertType.ERROR);
					alert.setContentText("Level Saving Failed!\n Error: "+params);
				}
				alert.setTitle("Saving Message");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
		});
	}


	@Override
	public void showLoadLevelMessage(boolean succeed, String params) {
		if(succeed)
		{
			requestDisplay();
			updateStatus(GameStatus.LOADED);
		}
		else
		{
			Platform.runLater(new Runnable()
			{
				@Override
				public void run()
				{
					Alert alert= new Alert(AlertType.ERROR);
					alert.setContentText("Level Loading Failed!\n Error: "+params);
					alert.setTitle("Load Message");
					alert.setHeaderText(null);
					alert.showAndWait();
				}
			});
		}
		
	}


	@Override
	public void positionHasChanged(boolean isMoved) {
		if(isMoved)
		{
			steps++;
			updateSteps(steps);
		}
		requestDisplay();
	}


	@Override
	public void displayLevel(CommonLevel level) {
		fieldData.setSokobanField(level.getField());
		fieldData.draw();
	}


	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void stop() {
		setChanged();
		notifyObservers("Exit -gui");
	}


	@Override
	public void levelHasRestarted() {
		requestDisplay();
		timer.stop();
		updateSteps(0);
		updateTime(0);
	}
	
	public void requestDisplay()
	{
		setChanged();
		notifyObservers("Display");
	}


	@Override
	public void levelHasFinished() {
		updateStatus(GameStatus.FINISH);
		timer.stop();
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				Alert alert;
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Finish Game");
				alert.setHeaderText(null);
				alert.setContentText("You Win!");
				alert.showAndWait();
			}
		});
	}
	
	public void updateSteps(int steps)
	{
		this.steps=steps;
		Platform.runLater(new Runnable() {public void run() {stepsField.setText(""+steps);}});
	}
	
	public void updateTime(int time)
	{
		this.time=time;
		Platform.runLater(new Runnable() {public void run() {timeField.setText(timeToString(time));} });
	}
	
	protected String timeToString(int time) {
		String sec;
		String min;
		
		if(time%60<10)
			sec="0"+time%60;
		else
			sec=""+time%60;
		min=""+time/60;
		
		return min+":"+sec;
		
	}


	public void setButtonStatus(GameStatus gs)
	{
		switch(gs)
		{
		case LOADED:
			startBtn.setDisable(false);
			restartBtn.setDisable(true);
			stopBtn.setDisable(true);
			break;
			
		case PLAYING:
			startBtn.setDisable(true);
			restartBtn.setDisable(false);
			stopBtn.setDisable(false);
			break;
			
		case FINISH:
			startBtn.setDisable(true);
			restartBtn.setDisable(false);
			stopBtn.setDisable(true);
			break;
		case PRELOAD:
			startBtn.setDisable(true);
			restartBtn.setDisable(true);
			stopBtn.setDisable(true);
			break;
		}
	}
	
	public void updateStatus(GameStatus gs)
	{
		status = gs;
		setButtonStatus(gs);
	}
	
	public void loadKeyboardSettingsWindow()
	{
		MainWindowController mwc = this;
			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					try {
					FXMLLoader fxml = new FXMLLoader();
					BorderPane root = fxml.load(getClass().getResource("./settings/KeyboardSettings.fxml").openStream());
					KeyboardSettingsController ksc = (KeyboardSettingsController)fxml.getController();
					ksc.setParent(mwc);
					Stage secondStage = new Stage();
					Scene scene = new Scene(root,360,200);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					secondStage.setScene(scene);
					secondStage.show();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			
			
	}
	
	public void updateKeyboardSettings(boolean showMessage)
	{
		try {
			keyboardHashMap = new KeyboardHashMapLoader().load("./resources/keymap.xml");
			if(showMessage)
					showAlertMessage(AlertType.INFORMATION, "Keyboard Settings", "Changes saved succesfully");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void toggleMusic()
	{
		enableMusic=!enableMusic;
		if(enableMusic)
			mediaPlayer.play();
		else
			mediaPlayer.pause();
	}
	
	private void showAlertMessage(AlertType type,String title,String context)
	{
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				Alert alert;
				alert = new Alert(type);
				alert.setTitle(title);
				alert.setHeaderText(null);
				alert.setContentText(context);
				alert.showAndWait();
			}
		});
	}
	
}
