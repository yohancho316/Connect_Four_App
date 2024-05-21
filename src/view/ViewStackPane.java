package view;

import javafx.scene.layout.StackPane;

public class ViewStackPane extends StackPane {
	
	// Primitive Fields
	private int row;
	private int column;
		
	// Row Getter Method
	public int getRow() {
		return this.row;
	}
	
	// Column Getter Method
	public int getColumn() {
		return this.column;
	}
	
	// Row Setter Method
	public void setRow(int row) {
		if(row < 0 || row > 5) throw new IllegalArgumentException("Row # is out of bounds");
		this.row = row;
	}
	
	// Column Setter Method
	public void setColumn(int column) {
		if(column < 0 || column > 6) throw new IllegalArgumentException("Column # is out of bounds");
		this.column = column;
	}
	
	
	// ViewStackPane Constructor
	public ViewStackPane(int row, int column) {
		
		// Set Row
		setRow(row);
		
		// Set Column
		setColumn(column);
	}
	

}
