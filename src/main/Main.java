package main;

import model.Model;
import view.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	// Final Variables
	private final double SCENE_HEIGHT = 900;
	private final double SCENE_WIDTH = 900;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			// Instantiate Model Node
			Model model = new Model();
			
			// Instantiate View Node
			View view = new View();
			
			// Drop Chips into Connect-4 Board
			model.dropCoin(1);
			model.dropCoin(1);
			model.dropCoin(1);
			model.dropCoin(1);
			model.dropCoin(1);
			model.dropCoin(1);

			// Print All Chips in Play
			model.printBoard();
			
			// Instantiate Scene Container
	        Scene scene = new Scene(view.getBorderPane(), SCENE_WIDTH, SCENE_HEIGHT);
	        
	        // Set Scene onto Primary Stage
	        primaryStage.setScene(scene);
	        
	        // Set the Title for the Primary Stage Container
	        primaryStage.setTitle("Connect Four");
	        
	        // Show All Nodes within Primary Stage Container
	        primaryStage.show();
        
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
