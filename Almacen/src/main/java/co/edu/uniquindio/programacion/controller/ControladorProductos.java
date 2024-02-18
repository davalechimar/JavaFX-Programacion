package main.java.co.edu.uniquindio.programacion.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.java.co.edu.uniquindio.programacion.aplicacion.aplicacion;
import main.java.co.edu.uniquindio.programacion.model.Producto;

import java.time.LocalDate;

public class ControladorProductos {
    public static ControladorProductos instanciaProductos;
    @FXML
    private Button bttSalir;
    @FXML
    private Button bttVolver;
    @FXML
    private TextField codigoField;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField descripcionField;
    @FXML
    private TextField valorField;
    @FXML
    private TextField cantidadField;
    @FXML
    private ComboBox<String> tipoComboBox;
    @FXML
    private DatePicker fechaVencimientoPicker;
    @FXML
    private TextField codigoAproField;
    @FXML
    private DatePicker fechaEnvasadoPicker;
    @FXML
    private TextField tempRefrigeField;
    @FXML
    private TextField pesoEnvaseField;
    @FXML
    private ComboBox<String> paisOrigenComboBox;
    @FXML
    private TableView<Producto> tablaProductos;
    @FXML
    private TableColumn<Producto, String> codigoColumna;
    @FXML
    private TableColumn<Producto, String> nombreColumna;
    @FXML
    private TableColumn<Producto, String> descripcionColumna;
    @FXML
    private TableColumn<Producto, Double> valorColumna;
    @FXML
    private TableColumn<Producto, Integer> cantidadColumna;
    @FXML
    private TableColumn<Producto, LocalDate> fechaVenceColumna;
    @FXML
    private TableColumn<Producto, String> codigoAproColumna;
    @FXML
    private TableColumn<Producto, LocalDate> fechaEnvasadoColumna;
    @FXML
    private TableColumn<Producto, Double> tempRefriColumna;
    @FXML
    private TableColumn<Producto, Double> pesoEnvaseColumna;
    @FXML
    private TableColumn<Producto, String> paisColumna;
    @FXML
    private Button botonEditar;

    @FXML
    private Button botonActualizar;

    @FXML
    private Button botonEliminar;

    private ObservableList<Producto> productos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        instanciaProductos = this;
        tipoComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            fechaVencimientoPicker.setVisible("Producto Perecedero".equals(newValue));
            codigoAproField.setVisible("Producto Refrigerado".equals(newValue));
            tempRefrigeField.setVisible("Producto Refrigerado".equals(newValue));
            fechaEnvasadoPicker.setVisible("Producto Envasado".equals(newValue));
            pesoEnvaseField.setVisible("Producto Envasado".equals(newValue));
            paisOrigenComboBox.setVisible("Producto Envasado".equals(newValue));
            if ("Producto Perecedero".equals(newValue)) {
                fechaVencimientoPicker.setVisible(true);
            } else {
                fechaVencimientoPicker.setVisible(false);
            }
            if ("Producto Refrigerado".equals(newValue)) {
                codigoAproField.setVisible(true);
                tempRefrigeField.setVisible(true);
            } else {
                codigoAproField.setVisible(false);
                tempRefrigeField.setVisible(false);
            }
            if ("Producto Envasado".equals(newValue)) {
                fechaEnvasadoPicker.setVisible(true);
                pesoEnvaseField.setVisible(true);
                paisOrigenComboBox.setVisible(true);
            } else {
                fechaEnvasadoPicker.setVisible(false);
                pesoEnvaseField.setVisible(false);
                paisOrigenComboBox.setVisible(false);
            }
            // Configuración de visibilidad de campos según el tipo...
            // Asignar un valor por defecto para el campo pesoEnvase en caso de que esté vacío
            if ("Producto Envasado".equals(newValue)) {
                pesoEnvaseField.setText("0.0");
            } else {
                pesoEnvaseField.clear();
            }
            tablaProductos.setItems(productos);
        });

        /// Vincula las columnas con las propiedades del modelo
        codigoColumna.setCellValueFactory(cellData -> cellData.getValue().codigoProperty());
        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        descripcionColumna.setCellValueFactory(cellData -> cellData.getValue().descripcionProperty());
        valorColumna.setCellValueFactory(cellData -> cellData.getValue().valorUnitarioProperty().asObject());
        cantidadColumna.setCellValueFactory(cellData -> cellData.getValue().cantidadExistenciasProperty().asObject());
        fechaVenceColumna.setCellValueFactory(cellData -> cellData.getValue().fechaVencimientoProperty());
        codigoAproColumna.setCellValueFactory(cellData -> cellData.getValue().codigoAprobacionProperty());
        fechaEnvasadoColumna.setCellValueFactory(cellData -> cellData.getValue().fechaEnvasadoProperty());
        tempRefriColumna.setCellValueFactory(cellData -> cellData.getValue().temperaturaRefrigeracionProperty().asObject());
        pesoEnvaseColumna.setCellValueFactory(cellData -> cellData.getValue().pesoEnvaseProperty().asObject());
        paisColumna.setCellValueFactory(cellData -> cellData.getValue().paisOrigenProperty());
    }

    @FXML
    private void registrarProducto() {
        String codigo = codigoField.getText();
        String nombre = nombreField.getText();
        String descripcion = descripcionField.getText();
        String valorText = valorField.getText();
        String cantidadText = cantidadField.getText();
        String tempRefrigeText = tempRefrigeField.getText();

        double valor = 0.0;
        int cantidad = 0;
        double temperaturaRefrigeracion = 0.0;

        if (!valorText.isEmpty()) {
            valor = Double.parseDouble(valorText);
        }

        if (!cantidadText.isEmpty()) {
            cantidad = Integer.parseInt(cantidadText);
        }

        if (!tempRefrigeText.isEmpty()) {
            temperaturaRefrigeracion = Double.parseDouble(tempRefrigeText);
        }

        String tipoProducto = tipoComboBox.getValue(); // Obtener el tipo seleccionado

        // Resto del código para obtener los otros valores

        Producto nuevoProducto = new Producto(codigo, nombre, descripcion, valor, cantidad, tipoProducto,
                fechaVencimientoPicker.getValue(), codigoAproField.getText(),
                fechaEnvasadoPicker.getValue(), temperaturaRefrigeracion,
                0.0, paisOrigenComboBox.getValue());  // Asignar un valor por defecto, como 0.0

        if (!pesoEnvaseField.getText().isEmpty()) {
            nuevoProducto.setPesoEnvase(Double.parseDouble(pesoEnvaseField.getText()));
        }

        productos.add(nuevoProducto);

        // Limpiar campos
        codigoField.clear();
        nombreField.clear();
        descripcionField.clear();
        valorField.clear();
        cantidadField.clear();
        tipoComboBox.getSelectionModel().clearSelection();
        fechaVencimientoPicker.setValue(null);
        codigoAproField.clear();
        fechaEnvasadoPicker.setValue(null);
        tempRefrigeField.clear();
        pesoEnvaseField.clear();
    }

    @FXML
    void cerrar(MouseEvent event) {
        // Obtener la ventana actual
        Stage stage = (Stage) bttSalir.getScene().getWindow();
        // Cerrar la ventana
        stage.close();
    }

    public void limpiarCampos(ActionEvent actionEvent) {
        codigoField.clear();
        nombreField.clear();
        descripcionField.clear();
        valorField.clear();
        cantidadField.clear();
        tipoComboBox.getSelectionModel().clearSelection();
        fechaVencimientoPicker.setValue(null);
        codigoAproField.clear();
        fechaEnvasadoPicker.setValue(null);
        tempRefrigeField.clear();
        pesoEnvaseField.clear();
        paisOrigenComboBox.getSelectionModel().clearSelection();
    }

    public void editarProducto(ActionEvent actionEvent) {
        Producto productoSeleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (productoSeleccionado != null) {
            // Cargar los valores del producto seleccionado en los campos de edición
            codigoField.setText(productoSeleccionado.getCodigo());
            nombreField.setText(productoSeleccionado.getNombre());
            descripcionField.setText(productoSeleccionado.getDescripcion());
            valorField.setText(Double.toString(productoSeleccionado.getValorUnitario()));
            cantidadField.setText(Integer.toString(productoSeleccionado.getCantidadExistencias()));
            tipoComboBox.getSelectionModel().select(productoSeleccionado.getTipo()); // Aquí está la corrección
            fechaVencimientoPicker.setValue(productoSeleccionado.getFechaVencimiento());
            codigoAproField.setText(productoSeleccionado.getCodigoAprobacion());
            fechaEnvasadoPicker.setValue(productoSeleccionado.getFechaEnvasado());
            tempRefrigeField.setText(Double.toString(productoSeleccionado.getTemperaturaRefrigeracion()));
            pesoEnvaseField.setText(Double.toString(productoSeleccionado.getPesoEnvase()));
            paisOrigenComboBox.getSelectionModel().select(productoSeleccionado.getPaisOrigen());
        } else {
            mostrarMensaje("Editar Producto", "Seleccione un producto para editar.");
        }
    }


    public void eliminarProducto(ActionEvent actionEvent) {
        Producto productoSeleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (productoSeleccionado != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar Producto");
            alert.setHeaderText("¿Está seguro de eliminar el producto seleccionado?");
            alert.setContentText("Esta acción no se puede deshacer.");

            if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
                productos.remove(productoSeleccionado);
                mostrarMensaje("Eliminar Producto", "Producto eliminado exitosamente.");
            }
        } else {
            mostrarMensaje("Eliminar Producto", "Seleccione un producto para eliminar.");
        }
    }

    private void mostrarMensaje(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public void actualizarProducto(ActionEvent actionEvent) {
        Producto productoSeleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (productoSeleccionado != null) {
            // Actualizar los valores del producto seleccionado con los valores editados
            productoSeleccionado.setCodigo(codigoField.getText());
            productoSeleccionado.setNombre(nombreField.getText());
            productoSeleccionado.setDescripcion(descripcionField.getText());
            productoSeleccionado.setValorUnitario(Double.parseDouble(valorField.getText()));
            productoSeleccionado.setCantidadExistencias(Integer.parseInt(cantidadField.getText()));
            productoSeleccionado.setTipo(tipoComboBox.getValue());
            productoSeleccionado.setFechaVencimiento(fechaVencimientoPicker.getValue());
            productoSeleccionado.setCodigoAprobacion(codigoAproField.getText());
            productoSeleccionado.setFechaEnvasado(fechaEnvasadoPicker.getValue());
            productoSeleccionado.setTemperaturaRefrigeracion(Double.parseDouble(tempRefrigeField.getText()));
            productoSeleccionado.setPesoEnvase(Double.parseDouble(pesoEnvaseField.getText()));
            productoSeleccionado.setPaisOrigen(paisOrigenComboBox.getValue());

            // Actualizar la tabla
            tablaProductos.refresh();
            mostrarMensaje("Actualizar Producto", "Producto actualizado exitosamente.");
        } else {
            mostrarMensaje("Actualizar Producto", "Seleccione un producto para actualizar.");
        }
    }

    public void volver(MouseEvent mouseEvent) {
        aplicacion.cambiarAPanelOpciones();
    }
}
