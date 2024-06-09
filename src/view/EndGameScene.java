package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

public class EndGameScene {
	
	// Final Variables
	private final double SCENE_HEIGHT = 900;
	private final double SCENE_WIDTH = 900;
	private final double VBOX_CHILD_SPACING = 5.0;
	private final Insets VBOX_PADDING = new Insets(5.0);
	
	// VBox Layout Wrapper
	private VBox vbox;
	
	// Replay Button Node
	private Button replay;
	
	// Scene Node
	private Scene scene;
	
	// Wining Player Label
	private Label winLabel;

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
	
	// EndGameScene Constructor
	public EndGameScene(String winColor) {
		
		// Execute Initializing Methods
		this.initWinLabel(winColor);
		this.initReplayButton();
		this.initVBox();
		this.initScene();
	}
	
	// Initialize Win Label
	private void initWinLabel(String winColor) {
		this.winLabel = new Label();
		System.out.println("Winning Argument Passed: " + winColor);
		this.winLabel.setText(winColor.toString() + " PLAYER WINS!!");
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
