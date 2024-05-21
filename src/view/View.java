package view;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View extends Application {
	
	// Layout Wrapper Nodes
	private GridPane grid;
	private StackPane stack;
	
	// GridPane Getter Method
	public GridPane getGridPane() {
		return this.grid;
	}
	
	// StackPane Getter Method
	public StackPane getStackPane() {
		return this.stack;
	}
	
	// GridPane Setter Method
	public void setGridPane(GridPane grid) {
		if(grid == null) throw new NullPointerException("GridPane cannot be null");
		this.grid = grid;
	}
	
	// StackPane Setter Method
	public void setStackPane(StackPane stack) {
		if(stack == null) throw new NullPointerException("StackPane cannot be null");
		this.stack = stack;
	}
	
	// Initialize Layout Node Method
	public void initLayoutWrappers() {
		System.out.println("Initializing Layout Wrapper Nodes");
		this.grid = new GridPane();
		this.stack = new StackPane();
	}
	
	// Initialize GridPane Wrapper Method
	public void initGridPane() {
		System.out.println("Initializing GridPane Wrapper Node");
		
	}

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
