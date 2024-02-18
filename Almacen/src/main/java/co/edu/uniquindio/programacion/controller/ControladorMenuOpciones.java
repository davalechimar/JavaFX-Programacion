package co.edu.uniquindio.programacion.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import co.edu.uniquindio.programacion.aplicacion.aplicacion;

public class ControladorMenuOpciones {
    public static ControladorMenuOpciones instanciaPrincipal;

    @FXML
    void initialize() {
        instanciaPrincipal = this;
    }

    @FXML
    private Label LabelVentas;

    @FXML
    private Button botonCerrar;

    @FXML
    private Button bttCerrarSesion;

    @FXML
    private ImageView imagenAlmacenUQ;

    @FXML
    private ImageView imagenCarritoCompra;

    @FXML
    private ImageView imagenLibro;

    @FXML
    private ImageView imagenPersonas;

    @FXML
    private Label label1;

    @FXML
    private Label labelPersonas;

    @FXML
    private AnchorPane panelFondo;


    @FXML
    void abrirPanelClientes(MouseEvent event) {
        aplicacion.cambiarAPanelClientes();
    }

    @FXML
    void abrirPanelProductos(MouseEvent event) {
        aplicacion.cambiarAPanelProductos();
    }
    @FXML

    void abrirPanelVentas(MouseEvent event) {
        aplicacion.cambiarAPanelVentas();
    }
    @FXML
    void devolverVentana(MouseEvent event) {
        aplicacion.cambiarAPanelPrincipal();
    }



    @FXML
    void salir(MouseEvent event) {
        // Obtener la ventana actual
        Stage stage = (Stage) botonCerrar.getScene().getWindow();
        // Cerrar la ventana
        stage.close();
    }

}
