module com.krieger.animationplayground {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires javafx.base;

    opens com.krieger.animationplayground to javafx.fxml;
    exports com.krieger.animationplayground;
}