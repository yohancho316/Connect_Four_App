package view;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background; 
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View extends Application {
	
	// Final Fields
	private final double GRID_PANE_PADDING = 50.0;
	private final double GRID_PANE_VGAP = 15.0;
	private final double GRID_PANE_HGAP = 30.0;
	
	// Layout Wrapper Nodes
	private GridPane grid;
	
	// GridPane Collection
	private List<ViewStackPane> stackPaneList;
	
	// GridPane Getter Method
	public GridPane getGridPane() {
		return this.grid;
	}
	
	// StackPane Collection Getter Method
	public List<ViewStackPane> getStackPaneList() {
		return this.stackPaneList;
	}
	
	// GridPane Setter Method
	public void setGridPane(GridPane grid) {
		if(grid == null) throw new NullPointerException("GridPane cannot be null");
		this.grid = grid;
	}
	
	// StackPane Collection Setter Method
	public void setStackPaneList(List<ViewStackPane> stackPaneList) {
		if(stackPaneList == null) throw new NullPointerException("StackPaneList cannot be null");
		this.stackPaneList = stackPaneList;
	}
	
	// Initialize GridPane Wrapper Method
	private void initGridPane() {
		
		System.out.println("Initializing GridPane Wrapper Node");
		setGridPane(new GridPane());
		
		// Configure Padding (amount of space between the edges of the GridPane and its child nodes)
		getGridPane().setPadding(new Insets(GRID_PANE_PADDING));
		
		// Configure Horizontal Gap (amount of horizontal space to be added between each column)
		getGridPane().setHgap(GRID_PANE_HGAP);
		
		// Configure Vertical Gap (amount of vertical space to be added between each row)
		getGridPane().setVgap(GRID_PANE_VGAP);
		
		// Initialize StackPane Collection
		setStackPaneList(new ArrayList<ViewStackPane>());
		
		int row = 0;
		int column = 0;
		
		// Populate the GridPane w/ StackPane Wrapper Nodes
		for(;row < 6; ++row) {
			
			for(;column < 7; ++column) {
				
				// Instantiate ViewStackPane Wrapper 
				ViewStackPane stack = new ViewStackPane(row,column);
				
				// Decorate ViewStackPane Wrapper
				initViewStackPane(stack);
			}
			
		}
		
	}
	
	// Initialize ViewStackPane Wrapper
	private void initViewStackPane(StackPane stack) {
		
		// Instantiate Background Fill Node
		BackgroundFill dodger_blue_background_fill = new BackgroundFill(Color.DODGERBLUE, new CornerRadii(0), Insets.EMPTY);
		
		// Instantiate Background Node
		Background dodger_blue_background = new Background(dodger_blue_background_fill);
		
		// Configure Background for each StackPane Wrapper
		stack.setBackground(dodger_blue_background);
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
