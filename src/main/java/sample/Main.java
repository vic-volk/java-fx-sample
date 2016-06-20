package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    int[] tree;

    public Main() {
        TreeFactory treeFactory = new SimpleTreeFactory();
        tree = treeFactory.generateTree();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        root.getChildren().add(drawGraphics(primaryStage));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private Canvas drawGraphics(Stage primaryStage) throws IOException, InterruptedException {
//        Parent parent = FXMLLoader.load(getClass().getResource("../sample.fxml"));
        primaryStage.setTitle("Drawing Operations Test");
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        draw(gc);
        return canvas;
    }

    private void draw(GraphicsContext gc) throws InterruptedException {
        int height = 20;
        int shift = 20;
        int x = 10, y = 10, r = 15;
        for (int i = 0; i < tree.length; i++) {
            drawCircle(gc, x + shift, y + height, r);
            if (i < 999) {
                if (tree[i] < tree[i + 1]) {
                    shift = 20;
                    height += 20;
                } else {
                    shift += 20;
                }
            }
        }
    }

    private void drawCircle(GraphicsContext gc, int x, int y, int r) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.fillOval(x, y, r, r);
    }
}
