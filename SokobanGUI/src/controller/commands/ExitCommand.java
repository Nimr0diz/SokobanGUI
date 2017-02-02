package controller.commands;

import controller.Controller;
import view.SokobanServer;
import view.View;

public class ExitCommand extends Command {
	View view;
	SokobanServer server;
	Controller controller;

	public ExitCommand(View view,SokobanServer server,Controller controller) {
		this.view = view;
		this.server = server;
		this.controller = controller;
	}
	@Override
	public void execute() {
		//System.out.println("Exit Command");
		
		//Closing client connection
		if(server!=null)
		{	View client = server.getClient();
			if(client!=null)
				client.stop();
			
			server.closeConnection();
			server.lookingForClient();
		}
		//Closing the Application
		if(params.size()>=1)
			if(params.get(0).equals("-gui"))
			{
				if(server!=null)
					server.stop();
				
				controller.stop();
			}
		//if(client!=null)
		//	client.stop();
	}

}
