package controller;

import model.Model;
import view.CircleNode;
import view.ViewStackPane;
import view.View;

import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class Controller {
	
	// View Class Node
	private View view;
	
	// Model Class Node
	private Model model;
	
	// StackPane Collection
	private List<ViewStackPane> stackPaneList;
	
	// CircleNode Collection
	private List<CircleNode> circleNodeList;
	
	// View Getter Method
	public View getView() {
		return this.view;
	}
	
	// Model Getter Method
	public Model getModel() {
		return this.model;
	}
	
	// StackPane Collection Getter Method
	public List<ViewStackPane> getStackPaneList() {
		return this.stackPaneList;
	}
	
	// CircleNode Collection Getter Method
	public List<CircleNode> getCircleNodeList() {
		return this.circleNodeList;
	}
	
	// View Setter Method
	public void setView(View view) {
		if(view == null) throw new NullPointerException("View cannot be null");
	}
	
	// Model Setter Method
	public void setModel(Model model) {
		if(model == null) throw new NullPointerException("Model cannot be null");
		this.model = model;
	}
	
	// StackPane Collection Setter Method
	public void setStackPaneList(List<ViewStackPane> stackPaneList) {
		if(stackPaneList == null) throw new NullPointerException("StackPane collection cannot be null");
		if(stackPaneList.isEmpty()) throw new IllegalArgumentException("StackPane collection cannot be empty");
		this.stackPaneList = stackPaneList;
	}
	
	// CircleNode Collection Setter Method
	public void setCircleNodeList(List<CircleNode> circleNodeList) {
		if(circleNodeList == null) throw new NullPointerException("circleNode collection cannot be null");
		if(circleNodeList.isEmpty()) throw new IllegalArgumentException("circleNode collection cannot be empty");
		this.circleNodeList = circleNodeList;
	}
	
	// Attach EventHandlers to CircleNode Instances
	private void attachEventHandlers() {
		for(CircleNode circle : this.circleNodeList) {
			circle.addEventHandler(MouseEvent.MOUSE_CLICKED, circleMouseClickEventHandler);
		}
	}
	
	// Controller Constructor Method
	public Controller(Model model, View view) {
		if(model == null || view == null) throw new NullPointerException("Model/View cannot be null");
		this.model = model;
		this.view = view;
		this.stackPaneList = view.getStackPaneList();
		this.circleNodeList = view.getCircleNodeList();
		this.attachEventHandlers();
	}
	
	// Mouse Click Event Handler
	private EventHandler<MouseEvent> circleMouseClickEventHandler = new EventHandler<MouseEvent>() {
		
		@Override
		public void handle(MouseEvent event) {
			
			// Retrieve Reference Address of MouseEvent Source 
			CircleNode circle = (CircleNode) event.getSource();
			
			// Retrieve Column # of Selected CircleNode
			int column = circle.getColumn();
			
			// Retrieve Row # of Selected CircleNode
			int row = circle.getRow();
			
			// Print Row/Column Position of Circle
			System.out.println("Selected Circle (" + row + "/" + column + ")");
			
			// Check if Space Exists at Given Column to Drop Chip
			boolean columnSpace = getModel().checkColumnSpace(column);
			
			// Check for Player's Turn
			if(columnSpace && getModel().getRedTurn() == true) {
				 
				// Change to Yellow Player's Turn
				model.changePlayerTurn();
				
				// Set Circle Background to Red
				circle.setBackground(Color.RED);
				
				System.out.println("Red Turn");
				
			} else if(columnSpace && model.getRedTurn() == false){
				
				// Change to Red Player's Turn
				model.changePlayerTurn();
				
				// Set Circle Background to Yellow
				circle.setBackground(Color.YELLOW);
				
				System.out.println("Yellow Turn");
			}
		}
		
		
	};
}
