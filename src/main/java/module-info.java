module com.krieger.animationplayground {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires javafx.base;

    exports com.krieger.animationplayground;
    opens com.krieger.animationplayground to javafx.fxml;
    exports com.krieger.animationplayground.sandbox;
    exports com.krieger.animationplayground.layers;
    opens com.krieger.animationplayground.sandbox to javafx.fxml;
    opens com.krieger.animationplayground.layers to javafx.fxml;
}
