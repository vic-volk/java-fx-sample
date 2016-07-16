package sample;

import model.Rectangle;
import model.Scene;
import model.SceneObject;

import java.util.Random;

public class SceneRealityImpl implements SceneReality {

    private double Width;
    private double Height;
    private double xIncrement = 1;
    private double yIncrement = 1;
    private double incrementInterval = 1;

    public SceneRealityImpl(double width, double height) {
        Width = width;
        Height = height;
    }

    @Override
    public void changeScene(Scene scene) {
    }

    public void changeRectangle(Rectangle rectangle) {
        xIncrement = calculateIncrement(rectangle.getX(), Width, xIncrement, rectangle.getWidth());
        yIncrement = calculateIncrement(rectangle.getY(), Height, yIncrement, rectangle.getHeight());
        rectangle.setX(rectangle.getX() + xIncrement);
        rectangle.setY(rectangle.getY() + yIncrement);
    }

    private double calculateIncrement(double value, double sideSize, double increment, double rectangleSideSize) {
        if (value > sideSize - 1 - rectangleSideSize || value < 1) {
            increment = increment > 0 ? -1 * (1 + getRandomDynamicValue()) : 1 + getRandomDynamicValue();
        }
        return increment;
    }

    private double getRandomDynamicValue() {
        return new Random().nextDouble() / Double.MAX_VALUE;
    }
}
