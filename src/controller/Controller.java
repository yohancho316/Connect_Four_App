package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class Controller {
	

	
	public static EventHandler<MouseEvent> circleMouseEventHandler = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			System.out.println("You've clicked on a circle!");
		}
	};
}
