package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import controller.commands.Command;
import controller.commands.DisplayLevelCommand;
import controller.commands.ExitCommand;
import controller.commands.FinishLevelCommand;
import controller.commands.LoadLevelCommand;
import controller.commands.MoveInLevelCommand;
import controller.commands.ResetLevelCommand;
import controller.commands.SaveLevelCommand;
import model.Model;
import view.SokobanServer;
import view.View;

public class SokobanController implements Observer{

	private Model model;
	private View view;
	private SokobanServer server;
//	private CLI client;
	private Controller controller;
	
	
	private HashMap<String,Command> commands;
	
	public SokobanController(Model model,View view) {
		this.view = view;
		this.model = model;
		this.server = null;
		this.controller = new Controller();
		controller.start();
		
		initCommands();
	}
	
/*	public SokobanController(Model model,View view,CLI client) {
		this.view = view;
		this.model = model;
	//	this.client = client;
		this.controller = new Controller();
		controller.start();
		
		initCommands();
	}*/
	
	public SokobanController(Model model,View view,SokobanServer server)
	{
		this.view = view;
		this.model = model;
		this.server = server;
		this.controller = new Controller();
		controller.start();
		System.out.println(server);
		initCommands();
	}
	
	private void initCommands(){
		commands = new HashMap<String, Command>();
		
		commands.put("Display", new DisplayLevelCommand(model,view,server));
		commands.put("Exit", new ExitCommand(view,server,controller));
		commands.put("Load", new LoadLevelCommand(model, view,server));
		commands.put("Move", new MoveInLevelCommand(model, view,server));
		commands.put("Save", new SaveLevelCommand(model,view,server));
		commands.put("Reset", new ResetLevelCommand(model, view,server));
		commands.put("FinishLevel", new FinishLevelCommand(view,server));
		
	}
	
	@Override
	public void update(Observable o, Object args) {
		String[] lineArr = ((String)args).split(" ");
		LinkedList<String> params = new LinkedList<String>();
		for(String param : lineArr)
			params.add(param);
		String commandName= params.removeFirst();
		Command c=commands.get(commandName);
		if(c==null)
		{
			return;
		}
		c.setParams(params);
		controller.insertCommand(c);
		
	}

	public void start() {
		controller.start();
		view.start();
	}
	
	public void stop() {
		controller.insertCommand(new ExitCommand(view,server,controller));
	}
	
/*	public void thereIsClient()
	{
		this.client = (CLI)server.getClient();
		client.addObserver(this);
		
		
	}*/
}
