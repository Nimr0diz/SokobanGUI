package controller.commands;

//import exceptions.InvalidFileTypeException;
//import exceptions.SokobanException;
//import levels.Level;
//import levels.LevelSaver;
//import levels.MyObjectLevelSaver;
//import levels.MyTextLevelSaver;
//import levels.MyXMLLevelSaver;
import model.Model;
import view.SokobanServer;
import view.View;

public class SaveLevelCommand extends Command {
	Model model;
	View view;
	SokobanServer server;
	
	public SaveLevelCommand(Model model,View view,SokobanServer server) {
		this.model=model;
		this.view = view;
		this.server=server;
	}
	@Override
	//The Method Save Level to any type of file and return it.
	//If the file isn't exist the method create new one.
	public void execute() {
		View client=null;
		
		if(server!=null)
			client= server.getClient();
		String filetype = params.get(0).substring(params.get(0).lastIndexOf(".")+1);//Get the letters after the '.' to get the file type
		try {
			model.save(params.get(0), filetype);
			view.showSaveLevelMessage(true, params.get(0));
			if(server!=null)
				if(client!=null)
					client.showSaveLevelMessage(true, params.get(0));
		} catch (Exception e) {
			view.showSaveLevelMessage(false, e.getMessage());
			if(server!=null)
				if(client!=null)
					client.showSaveLevelMessage(false, e.getMessage());
		}

	}
	

}
