package view;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.shape.Circle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background; 
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View extends Application {
	
	// Static & Final Fields
	private final double GRID_PANE_PADDING = 50.0;
	private final double GRID_PANE_VGAP = 0.5;
	private final double GRID_PANE_HGAP = 0.5;
	private final Pos GRID_PANE_POSITION = javafx.geometry.Pos.CENTER;
	
	// Layout Wrapper Nodes
	private GridPane grid;
	private BorderPane border;
	
	// GridPane Collection
	private List<ViewStackPane> stackPaneList;
	
	// GridPane Getter Method
	public GridPane getGridPane() {
		return this.grid;
	}
	
	// BorderPane Getter Method
	public BorderPane getBorderPane() {
		return this.border;
	}
	
	// StackPane Collection Getter Method
	public List<ViewStackPane> getStackPaneList() {
		return this.stackPaneList;
	}
	
	// GridPane Setter Method
	public void setGridPane(GridPane root) {
		if(root == null) throw new NullPointerException("GridPane cannot be null");
		this.grid = root;
	}
	
	// BorderPane Setter Method
	public void setBorderPane(BorderPane border) {
		if(border == null) throw new NullPointerException("BorderPane cannot be null");
		this.border = border;
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
				
				// Debugging Print Statement
				System.out.println("Added ViewStackPane at row " + row + " and column " + column);
				
				Circle circle = new Circle(100, 100, 70);
				
				circle.setFill(Color.DARKBLUE);
				
				// Instantiate ViewStackPane Wrapper 
				ViewStackPane stack = new ViewStackPane(circle, row, column);
				
				// Decorate ViewStackPane Wrapper
				initViewStackPane(stack);
				
				// Add StackPane Wrapper in Each Cell within GridPane Wrapper
				getGridPane().add(stack, column, row);
				
				// Add StackPane Wrapper in StackPane Collection
				getStackPaneList().add(stack);
				
			}
			
			column = 0;
			
		}
		
	}
	
	// Initialize ViewStackPane Wrapper
	private void initViewStackPane(StackPane stack) {
		
		// Instantiate Background Fill Node
		BackgroundFill dodger_blue_background_fill = new BackgroundFill(Color.DODGERBLUE, CornerRadii.EMPTY, Insets.EMPTY);;
		
		// Instantiate Background Node
		Background dodger_blue_background = new Background(dodger_blue_background_fill);
		
		// Configure Background for each StackPane Wrapper
		stack.setBackground(dodger_blue_background);
	}
	
	// Initialize BorderPane Wrapper
	public void initBorderPane() {
		
		System.out.println("Initiating BorderPane Wrapper");
		
		if(getGridPane() == null) throw new NullPointerException("GridPane cannot be null");
		setBorderPane(new BorderPane());
		getBorderPane().setCenter(getGridPane());
		BorderPane.setAlignment(getGridPane(), GRID_PANE_POSITION);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Initialize GridPane Layout Wrapper
		initGridPane();
		
		System.out.println("List Size: " + this.getStackPaneList().size());
		
		// Initialize BorderPane Layout Wrapper
		initBorderPane();
	
        // Create a scene with the layout
        Scene scene = new Scene(getBorderPane(), 1120, 1000);

        // Set the title of the stage
        primaryStage.setTitle("Connect-4 Application");
        // Add the scene to the stage
        primaryStage.setScene(scene);
        // Show the stage
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
