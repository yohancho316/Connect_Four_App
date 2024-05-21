package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View extends Application {
	
	// Final Fields
	private final double GRID_PANE_PADDING = 50.0;
	private final double GRID_PANE_VGAP = 15.0;
	private final double GRID_PANE_HGAP = 30.0;
	
	// Layout Wrapper Nodes
	private GridPane grid;
	
	// GridPane Getter Method
	public GridPane getGridPane() {
		return this.grid;
	}
	
	// GridPane Setter Method
	public void setGridPane(GridPane grid) {
		if(grid == null) throw new NullPointerException("GridPane cannot be null");
		this.grid = grid;
	}
	
	// Initialize GridPane Wrapper Method
	public void initGridPane() {
		
		System.out.println("Initializing GridPane Wrapper Node");
		setGridPane(new GridPane());
		
		// Configure Padding (amount of space between the edges of the GridPane and its child nodes)
		getGridPane().setPadding(new Insets(GRID_PANE_PADDING));
		
		// Configure Horizontal Gap (amount of horizontal space to be added between each column)
		getGridPane().setHgap(GRID_PANE_HGAP);
		
		// Configure Vertical Gap (amount of vertical space to be added between each row)
		getGridPane().setVgap(GRID_PANE_VGAP);
	}
	
	// Initialize StackPane Wrapper Method
	public void initStackPane() {
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Instantiate GridPane Layout Wrapper
		this.initGridPane();
		
		
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
