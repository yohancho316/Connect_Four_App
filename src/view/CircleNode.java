package view;

import javafx.scene.shape.Circle;

public class CircleNode extends Circle{
	
	// Final Fields
	private static final float CENTER_X = 100.0f;
	private static final float CENTER_Y = 100.0f;
	private static final float RADIUS = 70.0f;
	
	// Primitive Fields
	private int row;
	private int column;
	
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
	
    // Overloaded Circle constructor Method
	public CircleNode(int row, int column) {
		super(CENTER_X, CENTER_Y, RADIUS);
		this.row = row;
		this.column = column;
	}

}
