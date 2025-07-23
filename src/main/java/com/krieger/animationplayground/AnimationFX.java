package com.krieger.animationplayground;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AnimationFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");

        Group group = new Group(){};


        ContentGenerator gen = new ContentGenerator();
        ContentGenerator gen2 = new ContentGenerator();
        
        Canvas gridLayer = new ContentGenerator().getC();
        Canvas can = gen.getC();
        Canvas can2 = new Canvas(can.getWidth(),can.getHeight());


//        gen.drawShapes();
//        gen.moveCanvas(50,50);


// Fill the Canvas with a Blue rectnagle when the user double-clicks
       can2.addEventHandler(MouseEvent.MOUSE_CLICKED, 
        new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {            
                if (t.getClickCount() >1) {
                    gen.reset(can2, Color.BLUEVIOLET);
                }  
            }
        });

        // Clear away portions as the user drags the mouse
       can2.addEventHandler(MouseEvent.MOUSE_DRAGGED, 
       new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent e) {
               can2.getGraphicsContext2D().clearRect(e.getX() - 5, e.getY() - 5, 10, 10);
           }
       });
    
        
        gen2.drawGrid(gridLayer.getGraphicsContext2D());
        
        
        gen.drawRedPath();
            gen.drawRadialGradient(Color.web("#d7b1b1ff"),Color.web("#7f1616ff"));
            gen.drawLinearGradient(Color.web("#803232ff"),Color.web("#d3adadff"));

        gen.drawBluePath();
            gen.drawRadialGradient(Color.web("#a2a4daff"),Color.web("#363347ff"));
            gen.drawLinearGradient(Color.web("#325480ff"),Color.web("#adb1d3ff"));
         
        gen.drawGreenPath();
            gen.drawRadialGradient(Color.web("#88bbaa"),Color.web("#334740"));
            gen.drawLinearGradient(Color.web("#328051ff"),Color.web("#add3beff"));
                gen.drawDropShadow();
                
        gen.drawDropShadow();
                
        



        group.getChildren().addAll(gridLayer,gen.createBasic(),can2);

        Scene scene = new Scene(group);
        scene.setFill(Color.web
        ("#2c3033"));
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}