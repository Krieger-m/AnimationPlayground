package com.krieger.animationplayground;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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

    public void drawGrid(){
        gc.setStroke(Color.web("#E1E5EE"));
        gc.setLineWidth(1);

        double width = c.widthProperty().get();
        System.out.println("width: "+width);
        double height = c.heightProperty().get();
        System.out.println("height: "+ height);

        for(int x = 0; x<width;x++){
            if ((x%(width/10))==0){
                gc.strokeLine(x,0,x,height);

            }
            for(int y = 0; y<height;y++){
                if ((y%(height/10))==0){
                    gc.strokeLine(0,y,width,y);

                }

            }

        }
    }

    public void drawRedPath(){

        gc.setFill(Color.BLUEVIOLET);
        gc.setStroke(Color.web("#E0323D"));
        gc.setLineWidth(10);

        double x = 100;
        double y = 100;
        gc.beginPath();
        gc.moveTo(x, y);
        gc.bezierCurveTo(180+x, 40+x, 180+x, 180+x, 105+x, 10+x);
        gc.closePath();
        gc.stroke();


    }

    public void drawBluePath(){

        gc.setFill(Color.BLUEVIOLET);
        gc.setStroke(Color.web("#E0323D"));
        gc.setLineWidth(10);

        double x = 500;
        double y = 700;

        gc.setStroke(Color.web("#55BBD9"));
        gc.beginPath();
        gc.moveTo(500,500);
        gc.bezierCurveTo(230+x, 90+x, 230+x, 230+x, 155+x, 10+x);
        gc.closePath();
        gc.stroke();
    }


}
