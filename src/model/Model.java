package model;

import view.CircleNode;

public class Model {
	
	// Model Class Properties 
	private final int COLUMNS = 7;
	private final int ROWS = 7;
	private boolean gamePlay;
	private boolean redTurn; 
	
	// Matrix Collection
	private final int[][] board;
	
	// Game Play Getter Method
	public boolean getGamePlay() {
		return this.gamePlay;
	}
	
	// Red Turn Getter Method
	public boolean getRedTurn() {
		return this.redTurn;
	}
	
	// Board Matrix Getter Method
	public int[][] getBoard() {
		return this.board;
	}
	
	// Game Play Setter Method
	public void setGamePlay(boolean gamePlay) {
		this.gamePlay = gamePlay;
	}
	
	// Red Turn Setter Method
	public void setRedTurn(boolean redTurn) {
		this.redTurn = redTurn;
	}
	
	
	// Change Player Turn Method
	public void changePlayerTurn() {
		this.redTurn = !this.redTurn;
	}
	
	// Drop Chip Logic Method
	public boolean dropCoin(int column) {
		
	    // Check Column Bounds
	    if(column < 0 || column >= COLUMNS) throw new IllegalArgumentException("Column argument is out of bounds");
	    
	    // Check if Space Exists
	    if(checkColumnSpace(column)) throw new IllegalArgumentException("Cannot place coin. Column is currently full");
	    
	    // Get Next Open Column Position
	    int openPos = this.board[column][6];
	    
		System.out.println("Open Position: " + openPos);
		
	    
	    // Place Chip in Open Spot in a Given Column
	    
        if(redTurn) {
            board[column][openPos] = 2;
        } else {
            board[column][openPos] = 3;
        }
        
        // Change Player Turn
        changePlayerTurn();
        
        // Update Open Position
        board[column][6] = ++openPos;
        
        return true;
	}

	
	// Print Board
	public void printBoard() {
		for(int i = 0; i < COLUMNS; i++) {
			for(int j = 0; j < ROWS; j++) {
				System.out.println("[" + i + "][" + j + "] = " + board[i][j]);
			}
			System.out.println("\n");
		}
	}
	
	// Check Column Space Method
	private boolean checkColumnSpace(int column) {
		
		if(this.board[column][ROWS - 1] >= 6) return true;
		
		return false;
	}
	
	// Constructor Method
	public Model() {
		System.out.println("Instantiating Model Object");
		this.gamePlay = true;
		this.redTurn = true;
		this.board = new int[COLUMNS][ROWS];
		//printBoard();
	}

}
