package com.calculadora.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Project extends Application {

    private double  x = 0;
    private double y = 0;


    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Project.class.getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);

        root.setOnMousePressed((MouseEvent event) -> {
           x = event.getSceneX();
           y = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent evenet) -> {
            stage.setX(evenet.getSceneX() - x);
            stage.setY(evenet.getSceneY() - y);
        });

        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Calculadora!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}