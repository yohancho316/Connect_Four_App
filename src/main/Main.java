package main;

import model.Model;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			// Instantiate Model Node
			Model model = new Model();
			
			model.dropCoin(1);
			model.dropCoin(1);
			model.dropCoin(1);
			model.dropCoin(1);
			model.dropCoin(1);
			model.dropCoin(1);
			model.dropCoin(1);


			model.printBoard();
			
	        Scene scene = new Scene(new BorderPane(), 280, 240);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Connect Four");
	        primaryStage.show();
        
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
