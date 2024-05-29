package controller;

import view.CircleNode;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class Controller {
	

	
	public static EventHandler<MouseEvent> circleMouseEventHandler = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			
			// Retrieve Reference Address of MouseEvent Source 
			CircleNode circle = (CircleNode) event.getSource();
			
			// Print Row/Column Position of Circle
			System.out.println("Selected Circle (" + circle.getRow() + "/" + circle.getColumn() + ")");
			
			// Does not Work
			circle.setBackground(Color.RED);
		}
		
		
	};
}
