package view;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background; 
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class View {
	
	// Static & Final Fields
	private final double GRID_PANE_PADDING = 50.0;
	private final double GRID_PANE_VGAP = 0.5;
	private final double GRID_PANE_HGAP = 0.5;
	private final Pos GRID_PANE_POSITION = javafx.geometry.Pos.CENTER;
	private final BackgroundFill dodger_blue_background_fill = new BackgroundFill(Color.DODGERBLUE, CornerRadii.EMPTY, Insets.EMPTY);;
	private final Background dodger_blue_background = new Background(dodger_blue_background_fill);
	
	// Layout Wrapper Nodes
	private GridPane grid;
	private BorderPane border;
	
	// CircleNode Collection
	private List<CircleNode> circleNodeList;
	
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
	
	// CircleNode Collection Getter Method
	public List<CircleNode> getCircleNodeList() {
		return this.circleNodeList;
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
	
	// CircleNode Collection Setter Method
	public void setCircleNodeList(List<CircleNode> circleNodeList) {
		if(circleNodeList == null) throw new NullPointerException("CircleNodeList cannot be null");
		this.circleNodeList = circleNodeList;
	}
	
	// View Constructor Method
	public View() {
		
		// Initialize GridPane Wrapper
		this.initGridPaneWrapper();
		
		// Initialize Node Collections
		this.initNodeCollections();
		
		// Populate GridPane Wrapper
		this.populateGridPaneWrapper();
		
		// Initialize BorderPane Wrapper
		this.initBorderPane();	
	}
	
	// Initialize GridPane Wrapper Method
	private void initGridPaneWrapper() {
		
		// Instantiate GridPane Wrapper
		this.grid = new GridPane();
		
		// Configure Padding (amount of space between the edges of the GridPane and its child nodes)
		getGridPane().setPadding(new Insets(GRID_PANE_PADDING));
		
		// Configure Horizontal Gap (amount of horizontal space to be added between each column)
		getGridPane().setHgap(GRID_PANE_HGAP);
		
		// Configure Vertical Gap (amount of vertical space to be added between each row)
		getGridPane().setVgap(GRID_PANE_VGAP);
	}
	
	// Initialize JavaFX Node Collections
	private void initNodeCollections() {
		
		// Initialize StackPane Collection
		setStackPaneList(new ArrayList<ViewStackPane>());
		
		// Initialize CircleNode Collection
		setCircleNodeList(new ArrayList<CircleNode>());
	}
	
	// Populate GridPane Wrapper
	private void populateGridPaneWrapper() {
		
		int row = 0;
		int column = 0;
		
		// Populate the GridPane w/ StackPane Wrapper Nodes
		for(;row < 6; ++row) {
			
			for(;column < 7; ++column) {
				
				// Debugging Print Statement
				System.out.println("Added ViewStackPane at row " + row + " and column " + column);
				
				// Instantiate CircleNode
				CircleNode circle = new CircleNode(row, column, null);
				
				// Add CircleNode to CircleNode Collection
				getCircleNodeList().add(circle);
				
				// Instantiate ViewStackPane Wrapper 
				ViewStackPane stack = new ViewStackPane(circle, row, column);
				
				// Configure Background for each StackPane Wrapper
				stack.setBackground(dodger_blue_background);
				
				// Sets the Parent of the CircleNode to be the StackPane Wrapper
				circle.setStackpaneParent(stack);
				
				// Add StackPane Wrapper in Each Cell within GridPane Wrapper
				getGridPane().add(stack, column, row);
				
				// Add StackPane Wrapper in StackPane Collection
				getStackPaneList().add(stack);
				
			}
			
			column = 0;
			
		}
	}
	
	// Initialize BorderPane Wrapper
	public void initBorderPane() {
		
		// Check if GridPane Wrapper is Null
		if(getGridPane() == null) throw new NullPointerException("GridPane cannot be null");
		
		// Instantiate BorderPane Wrapper 
		setBorderPane(new BorderPane());
		
		// Set GridPane to Center Position in BorderPane Wrapper
		getBorderPane().setCenter(getGridPane());
		
		// Configure the Starting Location of GridPane Wrapper within BorderPane Wrapper
		BorderPane.setAlignment(getGridPane(), GRID_PANE_POSITION);
	}

}
