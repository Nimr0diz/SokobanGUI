package controller.commands;

import java.util.HashMap;

import commons.Direction2D;
import model.Model;
import view.SokobanServer;
import view.View;

public class MoveInLevelCommand extends Command {
	Model model;
	View view;
	SokobanServer server;
	
	HashMap<String,Direction2D> directionList; //The HashMap link each string of direction to the specific Direction
		public MoveInLevelCommand(Model model,View view,SokobanServer server) {
			this.model=model;
			this.view=view;
			this.server=server;
			//Initializing the HashMap.
			directionList = new HashMap<String,Direction2D>();
			
			directionList.put("Up", Direction2D.UP);
			directionList.put("Right", Direction2D.RIGHT);
			directionList.put("Down", Direction2D.DOWN);
			directionList.put("Left", Direction2D.LEFT);

			
		}
		@Override
		//The method moves the first figure to the direction he get from the user. 
		public void execute() {
			boolean isMoved=false;
			String specialMove;
			Direction2D dir = directionList.get(params.get(0));
			if(params.size()>=2)
			{
				specialMove= params.get(1);
				if(specialMove.equals("Drag"))
					isMoved=model.moveAndDrag(dir);
			}
			else
				isMoved = model.move(dir); //Create new LevelManager who control the Level and moves the first figure.
			
			view.positionHasChanged(isMoved);
			if(server!=null)
				if(server.getClient()!=null)
					server.getClient().positionHasChanged(isMoved);
		}
}
