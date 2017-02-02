package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Observable;

import controller.SokobanController;

public class SokobanServer{
	private ServerSocket serverSocket;
	private Socket socket;
	private CLI client;
	private boolean wait;
	private SokobanController controller;
	int port;
	
	public SokobanServer(int port) {
		this.port = port;
	}
	
	public void start(){
		System.out.println("server starting!");
		try{
			serverSocket = new ServerSocket(port);
			serverSocket.setSoTimeout(10000);
			this.wait=true;
			lookingForClient();
				
		}catch(IOException ex){
			System.out.println("SERVER ERROR");
		}
	}
	
	public void lookingForClient() {
		new Thread(new Runnable()
		{
			@Override
			public void run() 
			{
				while(wait)
				{
					try{
						socket = serverSocket.accept();
						System.out.println("log in");
						client = new CLI(socket.getInputStream(),socket.getOutputStream());
						client.addObserver(controller);
						client.start();
						wait=false;
					}catch(IOException ex){
						System.out.println("CHANNEL ERROR");
					}
				}
			}
		}).start();
		
	}

	public View getClient(){
		return this.client;
	}
	
	public void setController(SokobanController controller)
	{
		this.controller = controller;
	}
	
	public void stop()
	{
		wait=false;
		if(client!=null)
			client.stop();
		try {
			serverSocket.close();
			//socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeConnection()
	{
		try {
			//socket.getInputStream().close();
			//socket.getOutputStream().close();
			if(socket!=null)
				socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait=true;
	}
}
