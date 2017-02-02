package controller.commands;

import view.SokobanServer;
import view.View;

public class FinishLevelCommand extends Command {

	View view;
	SokobanServer server;
	
	public FinishLevelCommand(View view,SokobanServer server) {
		this.view=view; 
		this.server=server;
	}
	
	@Override
	public void execute() {
		View client=null;
		if(server!=null)
			client= server.getClient();
		view.levelHasFinished();
		if(server!=null)
			if(client!=null)
				client.levelHasFinished();
	}

}
