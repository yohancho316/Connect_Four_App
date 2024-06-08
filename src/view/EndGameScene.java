package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

public class EndGameScene {
	
	// Final Variables
	private final double SCENE_HEIGHT = 900;
	private final double SCENE_WIDTH = 900;
	private final double VBOX_CHILD_SPACING = 5.0;
	private final Insets VBOX_PADDING = new Insets(5.0);
	
	// Scene Node
	private Scene scene;
	
	// VBox Layout Wrapper
	private VBox vbox;
	
	// Replay Button Node
	private Button replay;
	
	// Wining Player Label
	private Label winLabel;
	
	// Winning Player String
	private String winner;
	
	// Scene Getter Method
	public Scene getScene() {
		return this.scene;
	}
	
	// VBox Getter Method
	public VBox getVBox() {
		return this.vbox;
	}
	
	// Replay Button Getter Method
	public Button getReplayButton() {
		return this.replay;
	}
	
	// Label Getter Method
	public Label getLabel() {
		return this.winLabel;
	}
	
	// Winner String Getter Method
	public String getWinner() {
		return this.winner;
	}
	
	// Scene Setter Method
	public void setScene(Scene scene) {
		if(scene == null) throw new NullPointerException("Scene cannot be null");
		this.scene = scene;
	}
	
	// VBox Setter Method
	public void setVBox(VBox vbox) {
		if(vbox == null) throw new NullPointerException("VBox cannot be null");
		this.vbox = vbox;
	}
	
	// Replay Button Setter Method
	public void setReplayButton(Button replay) {
		if(replay == null) throw new NullPointerException("Replay button cannot be null");
		this.replay = replay;
	}
	
	// Winning Player Label Setter Method
	public void setWinLabel(Label winLabel) {
		if(winLabel == null) throw new NullPointerException("Label cannot be null");
		this.winLabel = winLabel;
	}
	
	// Winner String Setter Method
	public void setWinner(String winner) {
		if(winner.isEmpty() || winner == null) throw new NullPointerException("Winner String cannot be null");
		this.winner = winner;
	}
	
	// EndGameScene Constructor
	public EndGameScene(boolean isRed) {
		
		// Execute Initializing Methods
		this.initWinnerString(isRed);
		this.initWinLabel();
		this.initReplayButton();
		this.initVBox();
		this.initScene();
	}
	
	// Initialize Winner String
	private void initWinnerString(boolean isRed) {
		if(isRed) this.winner = "RED";
		else this.winner = "YELLOW";
	}
	
	// Initialize Win Label
	private void initWinLabel() {
		this.winLabel = new Label();
		this.winLabel.setText(this.winner + " PLAYER WINS!!");
	}
	
	// Initialize Replay Button
	private void initReplayButton() {
		this.replay = new Button();
		this.replay.setText("Replay Game");
	}
	
	// Initialize VBox Layout Wrapper 
	private void initVBox() {
		
		// Instantiate VBox Layout Wrapper
		this.vbox = new VBox();
		
		// Set Spacing Between Child Nodes
		this.vbox.setSpacing(VBOX_CHILD_SPACING);
		
		// Add Padding around the VBox from its Parent Container
		this.vbox.setPadding(VBOX_PADDING);
		
		// Add All Child Nodes
		this.vbox.getChildren().addAll(this.winLabel, this.replay);
		
		// Center All Child Nodes
		this.vbox.setAlignment(Pos.CENTER);	
	}

	// Initialize Scene 
	private void initScene() {
		this.scene =  new Scene(this.vbox, SCENE_WIDTH, SCENE_HEIGHT);
	}
}
