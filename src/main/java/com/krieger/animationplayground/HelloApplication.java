package com.krieger.animationplayground;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");

        ContentGenerator gen = new ContentGenerator();


//        gen.drawShapes();
//        gen.moveCanvas(50,50);
        gen.drawRedPath();
        gen.drawBluePath();

        gen.drawGrid();

        Scene scene = new Scene(gen.createBasic());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}