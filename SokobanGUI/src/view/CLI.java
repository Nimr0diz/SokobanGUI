package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;

import commons.CommonLevel;

public class CLI extends Observable implements View{
	protected BufferedReader reader;
	protected PrintWriter writer;
	
	protected HashMap<String,Character> displayer;
	protected boolean stop;
	
	protected CLI(){
		reader = null;
		writer = null;
	}
	
	public CLI(InputStream in, OutputStream out){
		this.reader = new BufferedReader(new InputStreamReader(in));
		this.writer = new PrintWriter(new OutputStreamWriter(out));
		initDisplayer();
	}
	
	private void initDisplayer()
	{
		displayer = new HashMap<String,Character>();
		
		displayer.put("RegularBox", '@');
		displayer.put("RegularWall",'#');
		displayer.put("RegularFigure",'A');
		displayer.put("RegularBoxTarget",'O');
		displayer.put("Nothing", ' ');
	}
	/*
	@Override
	public void showSaveCompletedMessage(String filepath) {
		writer.println("Save completed! ");
		writer.println("Level saved in \""+filepath+"\"" );
		writer.flush();
	}

	@Override
	public void showSaveFailedMessage(String message) {
		writer.println("Save failed! ");
		writer.println("error: "+message);
		writer.flush();
	}

	@Override
	public void showLoadCompletedMessge(String filepath) {
		writer.println("Load completed! ");
		writer.println("Level loaded from \""+filepath+"\"" );
		writer.flush();

	}

	@Override
	public void showLoadFailedMessage(String message) {
		writer.println("Load failed! ");
		writer.println("error: "+message);
		writer.flush();
	}
	*/
	
	@Override
	public void positionHasChanged(boolean isMoved) {}
	
	@Override
	public void displayLevel(CommonLevel level) {
		String line;
		for(int i=0;i<level.getField().length;i++)
		{
			line="";
			for(int j=0;j<level.getField()[i].length;j++)
			{
				line+=displayer.get(level.getField()[i][j]);
				//line+=level.getField()[i][j]+", ";
			}
			writer.println(line);
		}
		writer.flush();
	}

	@Override
	public void start() 
	{
		Thread thread = new Thread(new Runnable(){
			
			@Override
			public void run(){
				String line="";
				while(!stop)
				{
					try
					{
					line = reader.readLine();
					setChanged();
					notifyObservers(line);
					}catch(IOException ex){
						//System.out.println("asd");
						//ex.printStackTrace();
					}
				}
			}
		});
		thread.start();		
		
		
		
	}

	@Override
	public void stop() {
		stop=true;
		writer.println("EXIT");
		writer.flush();
	}

	@Override
	public void showSaveLevelMessage(boolean succeed,String param) 
	{
		if(succeed)
		{
			writer.println("Save completed! ");
			writer.println("Level saved in \""+param+"\"" );
			writer.flush();
		}else{
			writer.println("Save failed! ");
			writer.println("error: "+param);
			writer.flush();
		}
	}

	@Override
	public void showLoadLevelMessage(boolean succeed,String param) 
	{
		if(succeed)
		{
			writer.println("Load completed! ");
			writer.println("Level loaded from \""+param+"\"" );
			writer.flush();
		}else{
			writer.println("Load failed! ");
			writer.println("error: "+param);
			writer.flush();
		}
		
	}

	@Override
	public void levelHasRestarted() {
		
	}

	@Override
	public void levelHasFinished() {
		writer.println("Finish!");
		writer.flush();
		
	}

}
