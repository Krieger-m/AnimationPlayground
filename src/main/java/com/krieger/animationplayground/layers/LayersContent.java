package com.krieger.animationplayground.layers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class LayersContent {

    Group root;
    BorderPane borderPane;
    ChoiceBox<String> cb;
    ColorPicker picker;
    HBox menuContainer;

    double x = 1080;
    double y = 740;

    Canvas layer1;
    Canvas layer2;
    Canvas layer3;
    GraphicsContext gc1;
    GraphicsContext gc2;
    GraphicsContext gc3;


    public LayersContent() {
        this.menuContainer= new HBox();
        this.root = new Group();
        this.borderPane = new BorderPane();
        this.layer1 = new Canvas(x,y);
        this.layer2 = new Canvas(x,y);
        this.layer3 = new Canvas(x,y);
        this.gc1 = layer1.getGraphicsContext2D();
        this.gc2 = layer2.getGraphicsContext2D();
        this.gc3 = layer3.getGraphicsContext2D();


    }

    public void addLayers(){
        createChoiceBox();
        createColorPicker();
        menuContainer.getChildren().addAll(cb,picker);
        borderPane.setTop(menuContainer);
        Pane pane = new Pane();
        pane.getChildren().add(layer1);
        pane.getChildren().add(layer2);
        pane.getChildren().add(layer3);
        layer1.toFront();
        borderPane.setCenter(pane);
        root.getChildren().add(borderPane);

    }
    public void createColorPicker(){
        this.picker = new ColorPicker();
        // picker.
        // -->>> weiter hier mit dem colorPicker

    } 



    public void createChoiceBox(){
        this.cb = new ChoiceBox<>();
        this.cb.setItems(FXCollections.observableArrayList(
                "Layer 1 is GREEN", "Layer 2 is BLUE", "Layer 3 is RED"));
        this.cb.getSelectionModel().selectedItemProperty().
            addListener(new ChangeListener(){
                @Override
                public void changed(ObservableValue o, Object o1, Object o2){
                    if(o2.toString().contains("Layer 1")){
                        layer1.toFront();
                    }else if(o2.toString().contains("Layer 2")){
                        layer2.toFront();
                    }else if(o2.toString().contains("Layer 3")){
                        layer3.toFront();
                    }
                }
            }
        );
        this.cb.setValue("Layer 1 is GREEN");
    }

    public void drawDropShadow(GraphicsContext _g){
        _g.applyEffect(new DropShadow(20,20,20,Color.web("#00000065")));
    }

    public void handleLayers(){
        // Handler for Layer 1
        EventHandler<MouseEvent> layer1Handler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    gc1.setFill(
                            new LinearGradient(0, 0, 1, 1, true,
                                    CycleMethod.REFLECT,
                                    new Stop(0.0, Color.web("#BABDBF")),
                                    new Stop(1.0,  Color.web("#55FA9B")))
                    );
                    gc1.setEffect(new DropShadow(5,5,5,Color.web("#00000065")));
                    gc1.fillOval(e.getX()-35,e.getY()-35,70,70);
                }
            };
        layer1.addEventHandler(MouseEvent.MOUSE_CLICKED, layer1Handler);
        layer1.addEventHandler(MouseEvent.MOUSE_DRAGGED, layer1Handler);

        // Handler for Layer 2
        EventHandler<MouseEvent> layer2Handler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    gc2.setFill(
                            new LinearGradient(0, 0, 1, 1, true,
                                    CycleMethod.REFLECT,
                                    new Stop(0.0, Color.web("#BABDBF")),
                                    new Stop(1.0,  Color.web("#070086")))
                    );
                    gc2.setEffect(new DropShadow(8,8,8,Color.web("#00000065")));
                    gc2.fillOval(e.getX()-35,e.getY()-35,70,70);
                }
                
            };
        layer2.addEventHandler(MouseEvent.MOUSE_DRAGGED, layer2Handler);
        layer2.addEventHandler(MouseEvent.MOUSE_CLICKED, layer2Handler);
        

        // Handler for Layer 3
        EventHandler<MouseEvent> layer3Handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                gc3.setFill(
                        new LinearGradient(0, 0, 1, 1, true,
                                CycleMethod.REFLECT,
                                new Stop(0.0, Color.web("#BABDBF")),
                                new Stop(1.0,  Color.web("#FA518B")))
                );
                gc3.setEffect(new DropShadow(12,12,10,Color.web("#00000065")));
                gc3.fillOval(e.getX()-35,e.getY()-35,70,70);
            }
        };
        layer3.addEventHandler(MouseEvent.MOUSE_DRAGGED, layer3Handler);
        layer3.addEventHandler(MouseEvent.MOUSE_CLICKED, layer3Handler);
    }
}
