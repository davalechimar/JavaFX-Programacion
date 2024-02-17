module co.edu.uniquindio.programacion.almacen {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens co.edu.uniquindio.programacion.almacen to javafx.fxml;
    exports co.edu.uniquindio.programacion.almacen;
}