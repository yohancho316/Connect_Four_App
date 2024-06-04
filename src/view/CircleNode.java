package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleNode extends Circle{
	
	// Static & Final Fields
	private static final float CENTER_X = 90.0f;
	private static final float CENTER_Y = 90.0f;
	private static final float RADIUS = 55.0f;
	private static final Color START_CIRCLE_COLOR = Color.DARKBLUE;
	
	// Primitive Fields
	private int row;
	private int column;
	
	// Color Instance
	private Color background;
	
	// Parent Field
	private ViewStackPane parent;
	
	// Row Getter Method
	public int getRow() {
		return this.row;
	}
	
	// Column Getter Method 
	public int getColumn() {
		return this.column;
	}
	
	// ViewStackPane Parent Getter
	public ViewStackPane getStackPaneParent() {
		return this.parent;
	}
	
	// Color Background Getter Method
	public Color getBackground() {
		return this.background;
	}
	
	// ViewStackPane Parent Setter
	public void setStackpaneParent(ViewStackPane parent) {
		if(parent == null || parent.getChildren().isEmpty()) throw new NullPointerException("ViewStackPane Parent cannot be null");
		this.parent = parent;
	}

    // Row Setter Method
    public void setRow(int row) {
        if (row < 0 || row > 5) throw new IllegalArgumentException("Row # is out of bounds");
        this.row = row;
    }

    // Column Setter Method
    public void setColumn(int column) {
        if (column < 0 || column > 6) throw new IllegalArgumentException("Column # is out of bounds");
        this.column = column;
    }
    
    // Color Background Setter Method
    public void setBackground(Color background) {
    	if(background == null) throw new NullPointerException("Background cannot be null");
    	System.out.println(background.toString());
    	this.background = (Color) background;
    	this.setFill(this.background);
    }
    
    // Overloaded Circle constructor Method
	public CircleNode(int row, int column, ViewStackPane parent) {
		super(CENTER_X, CENTER_Y, RADIUS, START_CIRCLE_COLOR);
		this.row = row;
		this.column = column;
		this.parent = parent;
		this.background = START_CIRCLE_COLOR;
	}

}
