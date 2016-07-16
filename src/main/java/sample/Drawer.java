package sample;

import javafx.scene.canvas.GraphicsContext;
import model.Scene;

public interface Drawer {

    void draw(GraphicsContext graphicsContext, int[] tree);

    void drawScene(GraphicsContext graphicsContext, Scene scene);
}
