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
	private final int COLUMN = 7;
	private final int ROW = 6;
	private final double STROKE_WIDTH = 5.0;
	private final double GRID_PANE_PADDING = 50.0;
	private final double GRID_PANE_VGAP = 0.5;
	private final double GRID_PANE_HGAP = 0.5;
	private final Pos GRID_PANE_POSITION = javafx.geometry.Pos.CENTER;
	private final BackgroundFill DODGER_BLUE_BACKGROUND_FILL = new BackgroundFill(Color.DODGERBLUE, CornerRadii.EMPTY, Insets.EMPTY);;
	private final Background DODGER_BLUE_BACKGROUND = new Background(DODGER_BLUE_BACKGROUND_FILL);
	
	// Layout Wrapper Nodes
	private GridPane grid;
	private BorderPane border;
	
	// CircleNode Collection
	private List<CircleNode> circleNodeList;
	
	// GridPane Collection
	private List<ViewStackPane> stackPaneList;
	
	// Matrix Collection
	private CircleNode[][] board;
	
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
	
	// Matrix Getter Method
	public CircleNode[][] getBoard() {
		return this.board;
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
	
	// Matrix Setter Method
	public void setBoard(CircleNode[][] board) {
		if(board == null) throw new NullPointerException("Matrix cannot be null");
	}
	
	// View Constructor Method
	public View() {
		
		// Initialize Matrix Board
		this.initMatrix();
		
		// Initialize GridPane Wrapper
		this.initGridPaneWrapper();
		
		// Initialize Node Collections
		this.initNodeCollections();
		
		// Populate GridPane Wrapper
		this.populateGridPaneWrapper();
		
		// Initialize BorderPane Wrapper
		this.initBorderPane();	
	}
	
	// Initialize Matrix Method
	private void initMatrix() {
		this.board = new CircleNode[COLUMN][ROW];
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
	
	// Initialize JavaFX Node Collections Method
	private void initNodeCollections() {
		
		// Initialize StackPane Collection
		setStackPaneList(new ArrayList<ViewStackPane>());
		
		// Initialize CircleNode Collection
		setCircleNodeList(new ArrayList<CircleNode>());
	}
	
	// Populate GridPane Wrapper Method
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
				stack.setBackground(DODGER_BLUE_BACKGROUND);
				
				// Sets the Parent of the CircleNode to be the StackPane Wrapper
				circle.setStackpaneParent(stack);
				
				// Add StackPane Wrapper in Each Cell within GridPane Wrapper
				getGridPane().add(stack, column, row);
				
				// Add StackPane Wrapper in StackPane Collection
				getStackPaneList().add(stack);
				
				// Add CircleNode to Matrix Board
				board[column][row] = circle;
				
			}
			
			column = 0;
			
		}
	}
	
	// Initialize BorderPane Wrapper Method
	private void initBorderPane() {
		
		// Check if GridPane Wrapper is Null
		if(getGridPane() == null) throw new NullPointerException("GridPane cannot be null");
		
		// Instantiate BorderPane Wrapper 
		setBorderPane(new BorderPane());
		
		// Set GridPane to Center Position in BorderPane Wrapper
		getBorderPane().setCenter(getGridPane());
		
		// Configure the Starting Location of GridPane Wrapper within BorderPane Wrapper
		BorderPane.setAlignment(getGridPane(), GRID_PANE_POSITION);
	}
	
	// Change Chip Background Color Method
	public void changeChipColor(boolean isRed, int row, int column) {
		
		System.out.println("ROW = " + row);
		System.out.println("COLUMN = " + column);
		
		// Place Red Chip
		if(isRed) {
			board[column][row].setBackground(Color.RED);
		} else {
			board[column][row].setBackground(Color.YELLOW);
		}
		
	}

	// Configure Stroke Property Method
	public void highlightColumn(int column) {
		
		// Iterate through each CircleNode in the specified column
		for(CircleNode circle : this.board[column]) {
		
			// Configure CircleNode Boundary Color by Setting Stroke Property
			circle.setStroke(Color.PURPLE);
			
			// COnfigure Stroke Width Property
			circle.setStrokeWidth(STROKE_WIDTH);
		}
	}
	
	// Remove Stroke Property Method
	public void removeHighlightColumn(int column) {
		
		// Iterate through each CircleNode in the specified column
		for(CircleNode circle : this.board[column]) {
		
			// Configure CircleNode Boundary Color by Setting Stroke Property
			circle.setStroke(null);
			
		}
	}
}
