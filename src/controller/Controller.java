package controller;

import model.Model;
import view.CircleNode;
import view.ViewStackPane;
import view.View;

import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Controller {
	
	// Column Subtract Value
	private final int SUBTRACTION = 5;
	
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
			circle.addEventHandler(MouseEvent.MOUSE_ENTERED, circleMouseHoverEventHandler);
			circle.addEventHandler(MouseEvent.MOUSE_EXITED, circleMouseHoverExitEventHandler);
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
			
			// Open Column CircleNode Position
			int openPosition = model.getBoard()[column][6];
			
			// Print Row/Column Position of Circle
			System.out.println("Selected Circle (" + row + "/" + column + ")");
			
			// Check if Space Exists at Given Column to Drop Chip
			boolean columnSpace = getModel().checkColumnSpace(column);
			
			
			// Check for Player's Turn
			if(columnSpace && getModel().getRedTurn() == true) {
				 
				// Place Red Chip 
				model.dropCoin(column);
				
				// Set Circle Background to Red
				view.changeChipColor(model.getRedTurn(), SUBTRACTION - openPosition, column);
				
				System.out.println("Red Turn");
				
			} else if(columnSpace && model.getRedTurn() == false){
				
				// Place Yellow Chip
				model.dropCoin(column);
				
				// Set Circle Background to Yellow
				view.changeChipColor(model.getRedTurn(), SUBTRACTION - openPosition, column);
				
				System.out.println("Yellow Turn");
			}
		}
		
		
	};

	// Mouse Hover Event Handler
	
	// Mouse Hover Event Handler
	private EventHandler<MouseEvent> circleMouseHoverEventHandler = new EventHandler<MouseEvent>() {
		
		@Override
		public void handle(MouseEvent event) {
			
			// Retrieve Reference Address of MouseEvent Source 
			CircleNode circle = (CircleNode) event.getSource();
			
			// Retrieve Column Position of CircleNode
			int column = circle.getColumn();
			
			// Configure  Stroke Property for all CircleNode Instances at the Specified Column
			view.highlightColumn(column);

		}
	};
	
	// Mouse Hover Exit Event Handler
	private EventHandler<MouseEvent> circleMouseHoverExitEventHandler = new EventHandler<MouseEvent>() {
		
		@Override
		public void handle(MouseEvent event) {
			
			// Retrieve Reference Address of MouseEvent Source 
			CircleNode circle = (CircleNode) event.getSource();
			
			// Retrieve Column Position of CircleNode
			int column = circle.getColumn();
			
			// Remove Stroke Property for all CircleNode Instances at the Specified Column
			view.removeHighlightColumn(column);
			
		}
	};
}
