package co.edu.uniquindio.programacion.aplicacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


import static co.edu.uniquindio.programacion.controller.ControladorClientes.instanciaClientes;
import static co.edu.uniquindio.programacion.controller.ControladorMenuOpciones.instanciaPrincipal;
import static co.edu.uniquindio.programacion.controller.ControladorPanelPrincipal.instanciaPanelPrincipal;
import static co.edu.uniquindio.programacion.controller.ControladorProductos.instanciaProductos;

public class aplicacion extends Application {

    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        mostrarPanel("../view/PanelPrincipal.fxml", "Panel Principal");
    }

    /**
     * esta funcion se utiliza para cambiar de un panel a otro
     * @param fxmlFileName este atributo es de tipo String y se utiliza para ingresar la direccion de la vista ej: "../view/PanelPrincipal.fxml",
     * @param ventanaTitulo nombre de la ventana ej: "Panel Principal"
     */
    public static void mostrarPanel(String fxmlFileName, String ventanaTitulo) {
        try {
            // Cargar el archivo FXML del panel
            FXMLLoader loader = new FXMLLoader(aplicacion.class.getResource(fxmlFileName));
            Parent root = loader.load();

            // Crear una nueva escena
            Scene scene = new Scene(root);

            // Configurar la escena en la ventana principal
            primaryStage.setTitle(ventanaTitulo);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Agregar métodos para cambiar entre diferentes paneles aquí...
    public static void abrirVentanaClientes() {
        String ventanaFXML = "../view/RegistroClientes.fxml"; // Coloca aquí el nombre del archivo FXML de la ventana que deseas abrir
        mostrarPanel(ventanaFXML, "Ventana Clientes");
    }
    public static void abrirMenuOpciones() {
        String ventanaFXML = "../view/MenuOpciones.fxml"; // Coloca aquí el nombre del archivo FXML de la ventana que deseas abrir
        mostrarPanel(ventanaFXML, "Ventana Opciones");
    }
    public static void abrirPanelPricipal() {
        String ventanaFXML = "../view/PanelPrincipal.fxml"; // Coloca aquí el nombre del archivo FXML de la ventana que deseas abrir
        mostrarPanel(ventanaFXML, "Panel Principal");
    }
    public static void abrirVentanaProductos() {
        String ventanaFXML = "../view/Productos.fxml"; // Coloca aquí el nombre del archivo FXML de la ventana que deseas abrir
        mostrarPanel(ventanaFXML, "Ventana Productos");
    }
    public static void abrirVentanaVentas() {
        String ventanaFXML = "../view/Ventas.fxml"; // Coloca aquí el nombre del archivo FXML de la ventana que deseas abrir
        mostrarPanel(ventanaFXML, "Ventana Ventas");
    }


    // metodos utilizados para pasar de un panel a otro
    public static void cambiarAPanelOpciones() {
        if (instanciaPrincipal != null || instanciaPanelPrincipal != null || instanciaClientes != null || instanciaProductos != null) {
            abrirMenuOpciones(); // O el método correspondiente para mostrar el panel opciones
        }
    }
    public static void cambiarAPanelProductos() {
        if (instanciaPrincipal != null || instanciaClientes != null || instanciaProductos != null) {
            abrirVentanaProductos(); // O el método correspondiente para mostrar el panel productos
        }
    }
    public static void cambiarAPanelClientes() {
        if (instanciaPrincipal != null) {
            abrirVentanaClientes(); // O el método correspondiente para mostrar el panel de clientes
        }
    }
    public static void cambiarAPanelVentas() {
        if (instanciaPrincipal != null) {
            abrirVentanaVentas(); // O el método correspondiente para mostrar el panel ventas
        }
    }
    public static void cambiarAPanelPrincipal() {
        if (instanciaPrincipal != null) {
            abrirPanelPricipal(); // O el método correspondiente para mostrar el panel principal
        }
    }
}