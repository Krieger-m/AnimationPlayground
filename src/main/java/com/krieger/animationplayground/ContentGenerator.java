package com.krieger.animationplayground;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;

public class ContentGenerator {

    Pane p;
    Canvas c;
    GraphicsContext gc;

    public ContentGenerator(){
        p=new Pane();
        c=new Canvas(1080,740);
        gc=c.getGraphicsContext2D();
    }

    public Pane createBasic(){

        
        p.getChildren().add(c);
        
        return p;
    }
    
    

    public Canvas getC() {
        return c;
    }

    public void drawShapes(){

        gc.setFill(Color.BLUEVIOLET);
        gc.setStroke(null);

        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);
                                    //////

        gc.fillRect(c.getWidth()/2,c.getHeight()/2,c.getWidth()/2,c.getHeight()/2 );

        gc.fillRect(50,10,40,40);

        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
    }

    public void moveCanvas(int x, int y) {
        c.setTranslateX(x);
        c.setTranslateY(y);
    }

    public void drawGrid(GraphicsContext gc_){
        gc_.setStroke(Color.web("#a6a6a6ff"));
        gc_.setLineWidth(1);
        gc_.setFill(Color.WHITE);

        double width = c.widthProperty().get();
        System.out.println("width: "+width);
        double height = c.heightProperty().get();
        System.out.println("height: "+ height);

        gc_.fillText(String.valueOf(0), 20,20);


        for(int x = 10; x<width;x++){
            if ((x%(width/10))==0){
                //       start[x,y] , end[x,y]
                gc_.strokeLine(x,0,x,height);
                
                gc_.fillText(String.valueOf(x), x,20);
                for(int y = 0; y<height;y++){
                    if ((y%(height/10))==0){

                        gc_.strokeLine(0,y,width,y);
                    
                        gc_.fillText(String.valueOf(y), 20,y);
                    }
                }

                
            }
           
        }
    }

    public void drawRedPath(){
        gc.setLineWidth(10);

        double x = 100;
        double y = 100;
        gc.setStroke(Color.web("#a0237dff"));
        gc.beginPath();
        gc.moveTo(x, y);
        gc.bezierCurveTo(108, 324, 10, 122, 432, 296);
        // gc.bezierCurveTo(18+x, 500+x, 10+x, 10+x, 224+x, 100+x);
        gc.closePath();
        gc.stroke();


    }

    public void drawBluePath(){
        gc.setLineWidth(10);

        double x = 500;
        double y = 700;

        gc.setStroke(Color.web("#2e55b8ff"));
        gc.beginPath();
        gc.moveTo(500,500);
        gc.bezierCurveTo(230+x, 90+x, 230+x, 230+x, 155+x, 10+x);
        gc.closePath();
        gc.stroke();
    }
    public void drawGreenPath(){
        gc.setLineWidth(10);

        double x = 548;
        double y = 200;

        gc.setStroke(Color.web("#17c47fff"));
        gc.beginPath();
        gc.moveTo(x,y);
        gc.bezierCurveTo(230+x, 230+y,230+x, 432+y,  155+x, 10+y);
        gc.closePath();
        gc.stroke();
        
    }

    public void drawRadialGradient(Color firstColor, Color lastColor) {
        gc.setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.1, true,
               CycleMethod.REFLECT,
               new Stop(0.0, firstColor),
               new Stop(1.0, lastColor)));
        gc.fill();
    }

    public void drawLinearGradient(Color firstColor, Color secondColor) {
        LinearGradient lg = new LinearGradient(0, 0, 1, 1, true,
            CycleMethod.REFLECT,
            new Stop(0.0, firstColor),
            new Stop(1.0, secondColor));
        gc.setStroke(lg);
        gc.setLineWidth(10);
        gc.stroke();
    }

    public void drawDropShadow(){
        gc.applyEffect(new DropShadow(20,20,20,Color.web("#00000065")));
    }

    public void reset(Canvas canvas, Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(canvas.getWidth()/3, canvas.getHeight()/3, canvas.getWidth()/3, canvas.getHeight()/3);
    }

}
