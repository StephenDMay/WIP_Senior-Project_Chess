package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class Board extends Pane {
	
	private static final int BOARD_SIZE = 8;
	private static final int SQUARE_SIZE = 40;
	static GridPane board;
	
	public Board() {
		
		board = new GridPane();
		
	}
	
	public static void addSquaresToBoard() {
		Color[] squareColors = new Color[] {Color.WHITE, Color.BLACK};
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				board.add(new Rectangle(SQUARE_SIZE, SQUARE_SIZE, squareColors[(row+col)%2]), col, row);
			}
		}
	}
	
	public static void configureBoardLayout() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setMinHeight(SQUARE_SIZE);
			rowConstraints.setPrefHeight(SQUARE_SIZE);
			rowConstraints.setMaxHeight(SQUARE_SIZE);
			rowConstraints.setValignment(VPos.CENTER);
			board.getRowConstraints().add(rowConstraints);
			
			ColumnConstraints colConstraints = new ColumnConstraints();
			colConstraints.setMinWidth(SQUARE_SIZE);
			colConstraints.setPrefWidth(SQUARE_SIZE);
			colConstraints.setMaxWidth(SQUARE_SIZE);
			colConstraints.setHalignment(HPos.CENTER);
			board.getColumnConstraints().add(colConstraints);
		}
	}

}
