package view;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

public class ViewStackPane extends StackPane {

    // Primitive Fields
    private int row;
    private int column;
    private CircleNode circle;

    // Row Getter Method
    public int getRow() {
        return this.row;
    }

    // Column Getter Method
    public int getColumn() {
        return this.column;
    }
    
    // CircleNode Getter Method
    public CircleNode getCircleNode() {
    	return this.circle;
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
    
    // CircleNode Setter Method
    public void setCircleNode(CircleNode circle) {
    	if(circle == null) throw new NullPointerException("Circle cannot be null");
    	this.circle = circle;
    }

    // ViewStackPane Constructor
    public ViewStackPane(CircleNode circle, int row, int column) {
    	super(circle);
        // Set Row
        setRow(row);
        // Set Column
        setColumn(column);
        // Initialize Background
        initBackground();
    }

    // Method to initialize the background
    private void initBackground() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.DODGERBLUE, new CornerRadii(0), Insets.EMPTY);
        Background background = new Background(backgroundFill);
        this.setBackground(background);
    }

    @Override
    public String toString() {
        return "ViewStackPane[row=" + row + ", column=" + column + "]";
    }
}
