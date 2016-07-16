package sample;

import javafx.stage.Stage;

public class Main {

    public static void main(String[] args) throws Exception {
        startApplication();
    }

    private static void startApplication() {
        GameApplication gameApplication = new GameApplication();
        try {
            Stage primaryStage = new Stage();
            gameApplication.start(primaryStage);
            Thread.sleep(3000);
            System.out.println("Test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
