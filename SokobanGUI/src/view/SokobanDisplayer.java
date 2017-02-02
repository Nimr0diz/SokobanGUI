package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SokobanDisplayer extends Canvas {
	String[][] sokobanField;
	StringProperty wallFileName;
	StringProperty figureFileName;
	StringProperty boxFileName;
	StringProperty targetBoxFileName;
	StringProperty placedBoxFileName;
	
	
	HashMap<String,Image> imageMap;

	public SokobanDisplayer() {
		wallFileName = new SimpleStringProperty();
		figureFileName = new SimpleStringProperty();
		boxFileName = new SimpleStringProperty();
		targetBoxFileName = new SimpleStringProperty();
		placedBoxFileName = new SimpleStringProperty();
		
	}
	
	public void initImageMap()
	{
		try{
		imageMap = new HashMap<String,Image>();
		imageMap.put("RegularWall",new Image(new FileInputStream(wallFileName.get())));
		imageMap.put("RegularFigure",new Image(new FileInputStream(figureFileName.get())));
		imageMap.put("RegularBox", new Image(new FileInputStream(boxFileName.get())));
		imageMap.put("RegularBoxTarget", new Image(new FileInputStream(targetBoxFileName.get())));
		imageMap.put("RegularBoxTarget RegularBox", new Image(new FileInputStream(placedBoxFileName.get())));
		
		}catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void setSokobanField(String[][] sokobanField) {
		this.sokobanField = sokobanField;
		draw();
	}
	
	
	public void draw()
	{
		if(sokobanField!=null)
		{
			double width = getWidth();
			double height = getHeight();
			double entityWidth,entityHeight;
			entityHeight = height/sokobanField.length;
			entityWidth =  width/sokobanField[0].length;
			
			GraphicsContext gc = getGraphicsContext2D();
			gc.clearRect(0, 0, width, height);
			for(int i=0;i<sokobanField.length;i++)
				for(int j=0;j<sokobanField[0].length;j++)
				{
					if(!sokobanField[i][j].equals(" "))
					{
							gc.drawImage(imageMap.get(sokobanField[i][j]),entityWidth*j,entityHeight*i,entityWidth,entityHeight);
					}
				}
		}
		
	}


	public String getWallFileName() {
		return wallFileName.get();
	}


	public void setWallFileName(String wallFileName) {
		this.wallFileName.set(wallFileName);
	}


	public String getFigureFileName() {
		return figureFileName.get();
	}


	public void setFigureFileName(String figureFileName) {
		this.figureFileName.set(figureFileName);
	}


	public String getBoxFileName() {
		return boxFileName.get();
	}


	public void setBoxFileName(String boxFileName) {
		this.boxFileName.set(boxFileName);
	}

	public String getTargetBoxFileName() {
		return targetBoxFileName.get();
	}

	public void setTargetBoxFileName(String boxTartgetName) {
		this.targetBoxFileName.set(boxTartgetName);
	}

	public String getPlacedBoxFileName() {
		return placedBoxFileName.get();
	}

	public void setPlacedBoxFileName(String placedBoxName) {
		this.placedBoxFileName.set(placedBoxName);
	}
	
	
	
	
}
