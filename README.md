# Connect Four Game

This project implements a Connect Four game using Java and JavaFX. Connect Four is a classic two-player game where the players take turns dropping colored discs from the top into a vertically suspended grid. The objective is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs.

```
Click on the Image to Watch My Project in Action on YouTube
```
[![Watch my Project in Action on YouTube](https://raw.githubusercontent.com/yohancho316/Connect_Four_App/main/src/demo/connector_four_demo.gif)](https://www.youtube.com/watch?v=O-70gu_kez8)

## Design Pattern Architecture

The project follows the **MVC (Model-View-Controller)** design pattern to separate concerns and organize code structure effectively:

- **Model**: Responsible for maintaining data (game state) and business logic. It includes the `Model` class, which manages the game board, checks for win conditions, and handles player turns.

- **View**: Represents the user interface components and their layout. It includes classes such as `CircleNode`, `EndGameScene`, `ViewStackPane`, and `View`. These classes manage the visual representation of the game board, the end game scene, and individual circles (discs) in the game grid.

- **Controller**: Acts as an intermediary between the `Model` and `View`, handling user input and updating both as necessary. The `Controller` class manages event handling (like mouse clicks), updates the `Model` based on user actions, and updates the `View` to reflect changes in the game state.

## Object-Oriented Principles

The project adheres to several object-oriented principles:

- **Encapsulation**: Each class encapsulates its own state and behavior, providing clear interfaces for interaction with other parts of the application.

- **Inheritance**: `CircleNode` extends `javafx.scene.shape.Circle` to represent each game disc visually.

- **Polymorphism**: Different types of nodes (`ViewStackPane`, `EndGameScene`) can be treated uniformly through their common superclass (`javafx.scene.layout.Pane`).

- **Abstraction**: Interfaces (`EventHandler`, `List`) are used to generalize handling of events and collections, respectively.

- **Composition**: Classes like `View` compose instances of other classes (like `GridPane`, `BorderPane`) to build the user interface.

## Classes Overview

1. **Model**
   - Manages the game logic, including the game board state, checking win conditions, and handling player turns.

2. **View**
   - Handles the visual representation of the game:
     - `CircleNode`: Represents a single game disc.
     - `EndGameScene`: Displays the end game scene with options to replay.
     - `ViewStackPane`: Manages the layout of game discs in a stack pane.
     - `View`: Constructs and manages the overall game UI using JavaFX components.

3. **Controller**
   - Bridges user interactions with the game logic and UI:
     - Handles mouse events (clicks, hovers) to drop discs and manage game state transitions.
     - Coordinates updates between `Model` and `View`.

4. **Main**
   - Entry point of the application, initializing `Model`, `View`, and `Controller`, and setting up the primary stage with the game scene.

## Running the Project

To run the Connect Four game:

1. Ensure you have Java JDK and JavaFX installed.
2. Compile and run the `Main` class, which launches the game window.

   ```bash
   javac Main.java
   java Main
# Connect_Four_App
