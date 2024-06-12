package controller;

import model.Model;
import view.CircleNode;
import view.EndGameScene;
import view.ViewStackPane;
import view.View;

import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {
	
	// Column Subtract Value
	private final int SUBTRACTION = 5;
	
	// View Class Node
	private View view;
	
	// Model Class Node
	private Model model;
	
	// Primary Stage Node
	private Stage primaryStage;
	
	// Game Scene Node
	private Scene gameScene;
	
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
	
	// Primary Stage Getter Method
	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
	
	// Game Scene Getter Method
	public Scene getGameScene() {
		return this.gameScene;
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
	
	// Primary Stage Setter Method
	public void setPrimaryStage(Stage primaryStage) {
		if(primaryStage == null) throw new NullPointerException("Primary Stage cannot be null");
		this.primaryStage = primaryStage;
	}
	
	// Game Scene Setter Method
	public void setGameScene(Scene gameScene) {
		if(gameScene == null) throw new NullPointerException("Scene cannot be null");
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
	public Controller(Model model, View view, Stage primaryStage, Scene scene) {
		if(model == null || view == null || primaryStage == null) throw new NullPointerException("Model/View/Stage cannot be null");
		this.model = model;
		this.view = view;
		this.primaryStage = primaryStage;
		this.gameScene = scene;
		this.stackPaneList = view.getStackPaneList();
		this.circleNodeList = view.getCircleNodeList();
		this.attachEventHandlers();
	}
	
	// Check Vertical Win Condition Method
	private boolean checkVerticalWinCondition(int column) {
		return model.checkVerticalWinCondition(column);
	}
	
	// Check Horizontal Win Condition Method
	private boolean checkHorizontalWinCondition(int row) {
		return model.checkHorizontalWinCondition(row);
	}
	
	// Check Diagonal Left Win Condition Method
	private boolean checkDiagonalLeftWinCondition(int column) {
		return model.checkDiagonalLeftWinCondition(column);
	}
	
	// Check Diagonal Right Win Condition Method
	private boolean checkDiagonalRightWinCondition(int column) {
		return model.checkDiagonalRightWinCondition(column);
	}
	
	// Terminate Game Process Method
	private void terminateGame() {
		
		// Initialize Winning Color String
		String winner = model.getRedTurn() == true ? "RED" : "YELLOW";
		
		// Store Reference to Game Scene
		this.gameScene = this.primaryStage.getScene();
	
		// Instantiate EndGameScene Instance & Pass Winning Color
		EndGameScene endScene = new EndGameScene(winner);
		
		// Attach Reset Game Event Handler
		endScene.getReplayButton().addEventHandler(MouseEvent.MOUSE_CLICKED, resetGameEventHandler);
		
		// Update Primary Stage Scene to End Game Scene
		getPrimaryStage().setScene(endScene.getScene());
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
			System.out.println("Selected Circle (" + column + "/" + row + ")");
			
			// Check if Space Exists at Given Column to Drop Chip
			boolean columnSpace = getModel().checkColumnSpace(column);
			
			// If Space Exists Place Chip in View & Model Matrix 
			if(columnSpace && getModel().getRedTurn() == true) {
				
				// Get Open Row Position
				
				// Place Coin in Model Matrix (RED)
				model.dropCoin(column);
				
				// Place Coin in View Matrix Visually (RED)
				view.changeChipColor(model.getRedTurn(), SUBTRACTION - openPosition, column);
				
				// Check for Vertical Win Condition
				if(checkVerticalWinCondition(column)) {
					
					// Invoke Terminate Game Method
					terminateGame();
					
					return;
				}
				
				// Check for Horizontal Win Condition
				else if(checkHorizontalWinCondition(column)) {
					
					// Invoke Terminate Game Method
					terminateGame();
					
					return;
				}
				
				// Check for Diagonal Left Win Condition
				else if(checkDiagonalLeftWinCondition(column)) {
					
					// Invoke Terminate Game Method
					terminateGame();
					
					return;
				}
				
				// Check for Diagonal Right Win Condition
				else if(checkDiagonalRightWinCondition(column)) {
					
					// Invoke Terminate Game Method
					terminateGame();
					
					return;
				}

			} else if(columnSpace && model.getRedTurn() == false ) {
				
				// Place Coin in Model Matrix (YELLOW)
				model.dropCoin(column);
				
				// Place Coin in View Matrix Visually (YELLOW)
				view.changeChipColor(model.getRedTurn(), SUBTRACTION - openPosition, column);
				
				// Check for Vertical Win Condition
				if(checkVerticalWinCondition(column)) {
					
					// Invoke Terminate Game Method
					terminateGame();
					
					return;
				}
				
				// Check for Horizontal Win Condition
				else if(checkHorizontalWinCondition(column)) {
					
					// Invoke Terminate Game Method
					terminateGame();
					
					return;
				}
				
				// Check for Diagonal Left Win Condition
				else if(checkDiagonalLeftWinCondition(column)) {
					
					// Invoke Terminate Game Method
					terminateGame();
					
					return;
				}
				
				// Check for Diagonal Right Win Condition
				else if(checkDiagonalRightWinCondition(column)) {
					
					// Invoke Terminate Game Method
					terminateGame();
					
					return;
				}
			}
			
			// Change Player View
			model.changePlayerTurn();
		}

	};

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

	// Reset Game Event handler
	private EventHandler<MouseEvent> resetGameEventHandler = new EventHandler<MouseEvent>() {
		
		@Override
		public void handle(MouseEvent event) {
			
			// Invoke Reset Game Method via Model
			model.resetGame();
			
			// Invoke Reset Game Method via View
			view.resetGame();
			
			// Update Primary Stage Scene to Game Scene
			getPrimaryStage().setScene(gameScene);
			
		}
	};
	
}
