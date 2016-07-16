package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Scene;
import model.SceneObject;

public class DrawerImpl implements Drawer {

    public void draw(GraphicsContext graphicsContext, int[] tree) {
        int height = 20;
        int shift = 20;
        int x = 10, y = 10, r = 15;
        for (int i = 0; i < tree.length; i++) {
            drawCircle(graphicsContext, x + shift, y + height, r);
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

    public void drawScene(GraphicsContext graphicsContext, Scene scene) {
        scene.getSceneObjects()
                .forEach(so -> drawSceneObject(graphicsContext, so));
    }

    private void drawCircle(GraphicsContext gc, int x, int y, int r) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.fillOval(x, y, r, r);
    }

    private void drawSceneObject(GraphicsContext gc, SceneObject sceneObject) {
        sceneObject.draw(gc);
    }
}
