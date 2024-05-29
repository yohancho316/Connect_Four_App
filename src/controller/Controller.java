package controller;

import model.Model;
import view.CircleNode;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class Controller {
	
	// Model Class Node
	private Model model;
	
	// Model Getter Method
	public Model getModel() {
		return this.model;
	}
	
	// Model Setter Method
	public void setModel(Model model) {
		if(model == null) throw new NullPointerException("Model cannot be null");
		this.model = model;
	}
	
	// Default Controller Constructor Method
	public Controller() {
		this.model = new Model();
	}
	
	// Controller Constructor Method
	public Controller(Model model) {
		this.model = model;
	}
	
	public EventHandler<MouseEvent> circleMouseEventHandler = new EventHandler<MouseEvent>() {
		
		// Stop Game Method
		private void stopGame() {
			System.out.println("Game is over");
		}
		
		// Mouse Click Event Handler
		@Override
		public void handle(MouseEvent event) {
			
			// Retrieve Reference Address of MouseEvent Source 
			CircleNode circle = (CircleNode) event.getSource();
			
			// Print Row/Column Position of Circle
			System.out.println("Selected Circle (" + circle.getRow() + "/" + circle.getColumn() + ")");
			
			if(getModel().getGamePlay() == false) { System.out.println("Game is over!"); }
			
			
			// Check for Player's Turn
			if(getModel().getRedTurn() == true) {
				
				// Change to Yellow Player's Turn
				model.changePlayerTurn();
				
				// Set Circle Background to Red
				circle.setBackground(Color.RED);
				
				System.out.println("Red Turn");
				
			} else if(model.getRedTurn() == false){
				
				// Change to Red Player's Turn
				model.changePlayerTurn();
				
				// Set Circle Background to Yellow
				circle.setBackground(Color.YELLOW);
				
				System.out.println("Yellow Turn");
			}
		}
		
		
	};
}
