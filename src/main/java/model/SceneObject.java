package model;

import javafx.scene.canvas.GraphicsContext;

public abstract class SceneObject {

    private double x;
    private double y;

    public abstract void draw(GraphicsContext graphicsContext);

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
