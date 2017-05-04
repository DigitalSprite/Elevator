package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.awt.*;
import java.awt.Rectangle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        scene creation = new scene();
        Group root = creation.Create_Scene();
        Scene scene = new Scene(root, 1450, 850, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
        Controller.Allocate_Task();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
