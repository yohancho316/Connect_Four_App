package model;

public class Model {
	
	// Game State Variables
	private boolean gamePlay;
	private boolean redTurn;
	
	// Game Play Getter Method
	public boolean getGamePlay() {
		return this.gamePlay;
	}
	
	// Red Turn Getter Method
	public boolean getRedTurn() {
		return this.redTurn;
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
	
	// Constructor Method
	public Model() {
		this.gamePlay = true;
		this.redTurn = true;
	}

}
