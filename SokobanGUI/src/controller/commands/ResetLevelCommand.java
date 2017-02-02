package controller.commands;

import controller.SokobanController;
import model.Model;
import view.SokobanServer;
import view.View;

public class ResetLevelCommand extends Command {

	Model model;
	View view;
	SokobanServer server;
	
	public ResetLevelCommand(Model model, View view,SokobanServer server) {
		this.model=model;
		this.view=view;
		this.server=server;
	}
	@Override
	public void execute() {
		model.restart();
		view.levelHasRestarted();
		if(server!=null)
			if(server.getClient()!=null)
				server.getClient().levelHasRestarted();

	}

}
