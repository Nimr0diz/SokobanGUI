package view;
	
import controller.SokobanController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.MyModel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	SokobanController sokoban;
	static String[] arguments;
	@Override
	public void start(Stage primaryStage) {
		try {
			int port;
			
			FXMLLoader fxml = new FXMLLoader();
			BorderPane root = fxml.load(getClass().getResource("MainWindow.fxml").openStream());
			
			MainWindowController view = fxml.getController();
			MyModel model = new MyModel();
			if(arguments.length>=3)
				if(arguments[1].equals("-server"))
				{
					port=Integer.parseInt(arguments[2]);
					SokobanServer server = new SokobanServer(port);
					sokoban = new SokobanController(model, view,server);
					server.setController(sokoban);
					server.start();
				}
				else
					sokoban = new SokobanController(model, view);
			else
				sokoban = new SokobanController(model, view);
			model.addObserver(sokoban);
			view.addObserver(sokoban);
			
			Scene scene = new Scene(root,500,590);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				
				@Override
				public void handle(WindowEvent event) {
					view.stop();
					sokoban.stop();
				}
			});
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		arguments=args;
		launch(args);
		
	}

}
