package sample;

import javafx.scene.canvas.GraphicsContext;

public interface Drawer {

    void draw(GraphicsContext graphicsContext, int[] tree);
}
