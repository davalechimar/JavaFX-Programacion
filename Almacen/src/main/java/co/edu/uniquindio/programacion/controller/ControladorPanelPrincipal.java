package co.edu.uniquindio.programacion.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import co.edu.uniquindio.programacion.aplicacion.aplicacion;

public class ControladorPanelPrincipal {
    public static ControladorPanelPrincipal instanciaPanelPrincipal;
    @FXML
    private Button BttCerrar;

    @FXML
    private AnchorPane admin_form;

    @FXML
    private Button admin_loginBtn;

    @FXML
    private PasswordField admin_password;

    @FXML
    private TextField admin_username;

    @FXML
    private ImageView imgAdmin;

    @FXML
    private ImageView imgAlmacen;

    @FXML
    private Label lblAlmacen;

    @FXML
    private AnchorPane main_form;

    @FXML
    void initialize() {
        instanciaPanelPrincipal = this;

    }

    @FXML
    void cerrar(MouseEvent event) {
        // Obtener la ventana actual
        Stage stage = (Stage) BttCerrar.getScene().getWindow();
        // Cerrar la ventana
        stage.close();
    }

    @FXML
    void iniciarSesion(MouseEvent event) {
        if(admin_password.getText().equals("123") && admin_username.getText().equals("admin")){
            ControladorMenuOpciones();
        }
    }
    void ControladorMenuOpciones() {
        aplicacion.cambiarAPanelOpciones();
    }

    public void iniciarSesionBtt(KeyEvent keyEvent) {
        if(admin_password.getText().equals("123") && admin_username.getText().equals("admin")){
            ControladorMenuOpciones();
        }
    }
}