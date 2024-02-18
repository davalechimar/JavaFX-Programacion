package main.java.co.edu.uniquindio.programacion.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import main.java.co.edu.uniquindio.programacion.aplicacion.aplicacion;
import main.java.co.edu.uniquindio.programacion.model.DetalleVenta;
import main.java.co.edu.uniquindio.programacion.model.Producto;
import main.java.co.edu.uniquindio.programacion.model.Venta;

import java.time.Instant;
import java.util.Date;

public class ControladorVentas {
    @FXML
    private static ControladorVentas instanciaPanelVentas;
    public Button bttVolver;
    @FXML
    private TextField codigoField;
    @FXML
    private DatePicker fechaPicker;

    @FXML
    private TableView<DetalleVenta> tablaDetalleVentas;
    @FXML
    private TableColumn<DetalleVenta, Integer> cantidadColumn;
    @FXML
    private TableColumn<DetalleVenta, Double> subtotalColumn;
    @FXML
    private TableColumn<DetalleVenta, Producto> productoColumn;

    @FXML
    private TextField clienteField;
    @FXML
    private TextField totalField;
    @FXML
    private TextField ivaField;

    private ObservableList<DetalleVenta> detallesVenta;

    @FXML
    public void initialize() {
        instanciaPanelVentas = this;
        detallesVenta = FXCollections.observableArrayList();
        tablaDetalleVentas.setItems(detallesVenta);

        // Configurar columnas de la tabla
        cantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty().asObject());
        subtotalColumn.setCellValueFactory(cellData -> cellData.getValue().subtotalProperty().asObject());
        productoColumn.setCellValueFactory(cellData -> cellData.getValue().productoProperty());
    }

    @FXML
    private void mostrarDetalleVentaSeleccionada(DetalleVenta detalleVenta) {
        if (detalleVenta != null) {
            // Mostrar los detalles de la venta seleccionada en los campos correspondientes
            // Aquí debes definir cantidadField y subtotalField según su tipo (TextField u otros)
            // cantidadField.setText(String.valueOf(detalleVenta.getCantidad()));
            // subtotalField.setText(String.valueOf(detalleVenta.getSubtotal()));
            // Agregar lógica para mostrar los detalles del producto vendido si es necesario
        } else {
            // Si no se selecciona ningún detalle, limpiar los campos
            // cantidadField.clear();
            // subtotalField.clear();
            // Limpiar los detalles del producto vendido
        }
    }

    @FXML
    public void registrarVenta() {
        // Obtener los valores de los campos y crear un objeto Venta
        Venta venta = new Venta(codigoField.getText(), Date.from(Instant.from(fechaPicker.getValue())), clienteField.getText());

        // ...

        // Agregar detalles de venta a la venta
        venta.getDetallesVenta().addAll(detallesVenta);

        // Calcular el total y el IVA
        double total = 0;
        for (DetalleVenta detalle : detallesVenta) {
            total += detalle.getSubtotal();
        }
        venta.setTotal(total);

        double iva = total * 0.19; // Ejemplo de cálculo del 19% de IVA
        venta.setIva(iva);

        // Limpiar los campos después de registrar la venta
        codigoField.clear();
        fechaPicker.setValue(null);
        detallesVenta.clear();
        clienteField.clear();
        totalField.clear();
        ivaField.clear();
    }

    public void volver(MouseEvent mouseEvent) {
        aplicacion.cambiarAPanelOpciones();
    }

    // ...
}












/*-----------------------------------------------------------------------------------------------*/
/*
package main.java.co.edu.uniquindio.programacion.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.java.co.edu.uniquindio.programacion.model.DetalleVenta;
import main.java.co.edu.uniquindio.programacion.model.Producto;
import main.java.co.edu.uniquindio.programacion.model.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.Instant;
import java.util.Date;

public class ControladorVentas {
    @FXML
    private static ControladorVentas instanciaPanelVentas;
    @FXML
    private TextField codigoField;
    @FXML
    private DatePicker fechaPicker;

    @FXML
    private TableView<DetalleVenta> tablaDetalleVentas;
    @FXML
    private TableColumn<DetalleVenta, Integer> cantidadColumn;
    @FXML
    private TableColumn<DetalleVenta, Double> subtotalColumn;
    @FXML
    private TableColumn<DetalleVenta, Producto> productoColumn;

    @FXML
    private TextField clienteField;
    @FXML
    private TextField totalField;
    @FXML
    private TextField ivaField;

    private ObservableList<DetalleVenta> detallesVenta;

    @FXML
    public void initialize() {
        instanciaPanelVentas = this;
        detallesVenta = FXCollections.observableArrayList();
        tablaDetalleVentas.setItems(detallesVenta);

        // Configurar columnas de la tabla
        cantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty().asObject());
        subtotalColumn.setCellValueFactory(cellData -> cellData.getValue().subtotalProperty().asObject());
        productoColumn.setCellValueFactory(cellData -> cellData.getValue().productoProperty());
    }

    @FXML
    private void mostrarDetalleVentaSeleccionada(DetalleVenta detalleVenta) {
        if (detalleVenta != null) {
            // Mostrar los detalles de la venta seleccionada en los campos correspondientes
            cantidadField.setText(String.valueOf(detalleVenta.getCantidad()));
            subtotalField.setText(String.valueOf(detalleVenta.getSubtotal()));
            // Agregar lógica para mostrar los detalles del producto vendido si es necesario
        } else {
            // Si no se selecciona ningún detalle, limpiar los campos
            cantidadField.clear();
            subtotalField.clear();
            // Limpiar los detalles del producto vendido
        }
    }

    @FXML
    public void registrarVenta() {
        // Obtener los valores de los campos y crear un objeto Venta
        Venta venta = new Venta(codigoField.getText(), Date.from(Instant.from(fechaPicker.getValue())), clienteField.getText());

        // ...

        // Agregar detalles de venta a la venta
        venta.getDetallesVenta().addAll(detallesVenta);

        // Calcular el total y el IVA
        double total = 0;
        for (DetalleVenta detalle : detallesVenta) {
            total += detalle.getSubtotal();
        }
        venta.setTotal(total);

        double iva = total * 0.19; // Ejemplo de cálculo del 19% de IVA
        venta.setIva(iva);

        // Limpiar los campos después de registrar la venta
        codigoField.clear();
        fechaPicker.setValue(null);
        detallesVenta.clear();
        clienteField.clear();
        totalField.clear();
        ivaField.clear();
    }

    // ...
}
*/