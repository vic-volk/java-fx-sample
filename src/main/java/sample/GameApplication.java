package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Rectangle;

public class GameApplication extends Application {

    private Drawer drawer;
    private model.Scene scene;
    private Canvas canvas;
    private Rectangle rectangle;
    private SceneRealityImpl sceneReality;

    public static final double W = 800; // canvas dimensions.
    public static final double H = 600;

    public GameApplication() {
        drawer = new DrawerImpl();
        scene = new model.Scene();
        rectangle = new Rectangle(100, 100, 100, 100);
        sceneReality = new SceneRealityImpl(W, H);
        scene.add(rectangle);
    }

    @Override
    public void start(Stage stage) throws Exception{
        DoubleProperty x  = new SimpleDoubleProperty();
        DoubleProperty y  = new SimpleDoubleProperty();

        canvas = new Canvas(W, H);
        AnimationTimer timer = initAnimationTimer(x, y);

        stage.setScene(
                new Scene(
                        new Group(
                                canvas
                        )
                )
        );
        stage.show();
        timer.start();
    }

    private AnimationTimer initAnimationTimer(DoubleProperty x, DoubleProperty y) {
        return new AnimationTimer() {
            private int tick = 0;

            @Override
            public void handle(long now) {
                GraphicsContext gc = canvas.getGraphicsContext2D();
                drawBackground(gc);
                drawer.drawScene(gc, scene);
                System.out.println(tick++);
                sceneReality.changeRectangle(rectangle);
            }
        };
    }

    private void drawBackground(GraphicsContext gc) {
        gc.setFill(Color.CORNSILK);
        gc.fillRect(0, 0, W, H);
    }
}
