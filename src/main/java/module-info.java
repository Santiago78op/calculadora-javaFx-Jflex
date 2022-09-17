module com.calculadora.calculadora {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.calculadora.calculadora to javafx.fxml;
    exports com.calculadora.calculadora;
}