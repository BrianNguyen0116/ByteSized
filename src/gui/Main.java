package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
		@Override
		public void start(Stage primaryStage) throws Exception {
			Parent root = FXMLLoader.load(getClass().getResource("\scene.fxml"));
			primaryStage.setTitle("Byte-Sized");
			
			// Content
			
			
			// Scene Configuration
			Scene scene = new Scene(root, 400, 400);
			
			
			// Start-up
			primaryStage.setScene(scene);
			primaryStage.show();
		}

		public static void main(String[] args) {
			launch(args);
		}

}
