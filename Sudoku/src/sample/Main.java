package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    private static final int NUM_ROWS = 9;
    private static final int NUM_COLS = 9;
    private static final int ROW_HEIGHT = 75;
    private static final int COL_WIDTH = 75;


    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();

        MenuBar menuBar = new MenuBar();
            Menu menuFile = new Menu("File");
            menuBar.getMenus().addAll(menuFile);

        GridPane gridPane = new GridPane();

        for (int row=0; row<NUM_ROWS; row++) {
            gridPane.getColumnConstraints().add(new ColumnConstraints(COL_WIDTH));
            gridPane.getRowConstraints().add(new RowConstraints(ROW_HEIGHT));

            for (int col=0; col<NUM_COLS; col++) {
                StackPane stackPane;
                // Creates a light gray rectangle and a gray rectangle both with a black border.
                Rectangle lightGrayRectangle = new Rectangle(COL_WIDTH, ROW_HEIGHT, Color.LIGHTGRAY);
                lightGrayRectangle.setStroke(Color.BLACK);
                lightGrayRectangle.setStrokeWidth(1);
                Rectangle grayRectangle = new Rectangle(COL_WIDTH, ROW_HEIGHT, Color.GRAY);
                grayRectangle.setStroke(Color.BLACK);
                grayRectangle.setStrokeWidth(1);
                // Chooses which rectangle to use depending on the row and column.
                if (row<3 || row>=6) {
                    if (col<3 || col>=6) {
                        stackPane = new StackPane(lightGrayRectangle);
                    } else {
                        stackPane = new StackPane(grayRectangle);
                    }
                } else {
                    if (col<3 || col>=6) {
                        stackPane = new StackPane(grayRectangle);
                    } else {
                        stackPane = new StackPane(lightGrayRectangle);
                    }
                }

                Text text = new Text("2");
                text.setStyle("-fx-font: 76 arial;");
                stackPane.getChildren().add(text);
                gridPane.add(stackPane, col, row);
            }
        }
        root.getChildren().addAll(menuBar, gridPane);

        // Apply all stage settings.
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Jack Worman's Sudoku");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
        System.out.println(menuBar.getHeight());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
