package model;

public class Model {
	
	// Model Class Properties 
	private final int COLUMNS = 7;
	private final int ROWS = 7;
	private boolean gamePlay;
	private boolean redTurn; 
	
	// Matrix Collection
	private final int[][] board;
	
	// Constructor Method
	public Model() {
		System.out.println("Instantiating Model Object");
		this.gamePlay = true;
		this.redTurn = true;
		this.board = new int[COLUMNS][ROWS];
	}
	
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
	    if(checkColumnSpace(column) == false) return false;
	    
	    // Get Next Open Column Position
	    int openPos = this.board[column][6];
	    
		System.out.println("Open Position: " + openPos);
		
	    // Place Chip in Open Spot in a Given Column
        if(redTurn) {
            board[column][openPos] = 2;
        } else {
            board[column][openPos] = 3;
        }
        
        // Update Open Position
        board[column][6] = ++board[column][6];
        
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
	public boolean checkColumnSpace(int column) {
		if(this.board[column][ROWS - 1] >= 6) return false;
		return true;
	}

	// Check Vertical Win Condition
	public boolean checkVerticalWinCondition(int column) {
		
        System.out.println("Hitting Vertical Win Check Condition");

		
		// Left & Right State
		int left = 0;
		int right = 0;
		int matchCount = 0;
		int currentColor = this.getRedTurn() == true ? 2 : 3;
		
		// Iterate through Vertical Column 
		while(right < COLUMNS) {
			
			// Check for Matching Chips
			if(board[column][right] == currentColor) {
				
				// Increment Consecutive Match Count
				++matchCount;
				
				// Check Win Condition
				if(matchCount == 4) return true;
				
				// Increment Right
				++right;
				
			} else {
				
				// Reset Match Count
				matchCount = 0;
				
				// Increment Right
				++right;
				
				// Reset Left Count Position
				left = right;
			}
		}
		
		// No Vertical Win Condition Found
		return false;
	}
	
	// Check Horizontal Win Condition
	public boolean checkHorizontalWinCondition(int column) {
		
        System.out.println("Hitting Horizontal Win Check Condition");
        
        int row = board[column][6] - 1;
        int currentColor = this.getRedTurn() ? 2 : 3;
        int matchCount = 0;

        for (int col = 0; col < COLUMNS; col++) {
            if (board[col][row] == currentColor) {
                matchCount++;
                if (matchCount == 4) return true;
            } else {
                matchCount = 0;
            }
        }

        return false;
	}	
	
	// Check Right Diagonal Win Condition
	public boolean checkDiagonalRightWinCondition(int column) {
		
		// Tracking State Variables
		int matchCount = 0;
		int currentColor = this.getRedTurn() ? 2 : 3;
		
		// Identify Column & Row
		int col = column;
		int row = this.board[col][6] - 1;
		
		// Find Smallest Value
		int min = Math.min(col, row);
		
		// Assign Left Starting Positions
		int leftX = col - min;
		int leftY = row - min;
		
		// Determine the farthest possible right end of the diagonal:
		int maxLeftX = 6;
		int maxLeftY = 5;
		
		// Determine Total Iterations to Reach Right Most Col & Row Index Positions
		int steps = Math.min(maxLeftX - leftX, maxLeftY - leftY);
		
		for(int i = 0; i <= steps; i++, leftX++, leftY++) {
			
			System.out.println("Checking (" + leftX + "," + leftY+ ")");
			
			if(this.board[leftX][leftY] == currentColor) {
				++matchCount;
				if(matchCount == 4) return true;
			} else {
				matchCount = 0;
			}
			
			System.out.println();
		}
		
		// No Match Found
		return false;
	}
	
}
