package view;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View extends Application {
		

	@Override
	public void start(Stage primaryStage) throws Exception {
        // Create a Button and set an action on it
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(event -> System.out.println("Hello World!"));

        // Create a layout and add the button to it
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Create a scene with the layout
        Scene scene = new Scene(root, 800, 600);

        // Set the title of the stage
        primaryStage.setTitle("JavaFX Application");
        // Add the scene to the stage
        primaryStage.setScene(scene);
        // Show the stage
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
