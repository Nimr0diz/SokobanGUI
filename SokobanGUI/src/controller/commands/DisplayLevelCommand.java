package controller.commands;
import commons.CommonLevel;
import model.Model;
import view.SokobanServer;
import view.View;

public class DisplayLevelCommand extends Command{

	Model model;
	View view;
	SokobanServer server;

	public DisplayLevelCommand(Model model,View view,SokobanServer server) {
		this.model=model;
		this.view= view;
		//this.server=server;
		this.server=null;
	}
	
	@Override
	//This method get level and display it through the System.out
	//The str parameter is irrelevant.
	//The Command use the text levelSaver to "save" the level to the screen (System.out). 
	public void execute() {
		CommonLevel level = model.getLevel();
		view.displayLevel(level);
		if(server!=null)
		{
			View client= server.getClient();
			if(client!=null)
				client.displayLevel(level);
		}

	}


}
