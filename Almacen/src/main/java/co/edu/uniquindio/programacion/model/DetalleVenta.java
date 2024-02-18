package co.edu.uniquindio.programacion.model;

import javafx.beans.binding.BooleanExpression;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.binding.IntegerExpression;
import javafx.beans.value.ObservableValue;

import java.beans.Expression;
import java.util.Date;
import java.util.Objects;

public class DetalleVenta extends Venta{
    private Integer cantidad;
    private Double subtotal;
    private Producto producto;

    public DetalleVenta() {
    }

    public DetalleVenta(String codigo, Date fecha, Double total, Double iva, Cliente cliente, Integer cantidad, Double subtotal, Producto producto) {
        super(codigo, fecha, total, iva, cliente);
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    public DetalleVenta(Integer cantidad, Double subtotal, Producto producto) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleVenta that)) return false;
        return Objects.equals(cantidad, that.cantidad) && Objects.equals(subtotal, that.subtotal) && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad, subtotal, producto);
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", producto=" + producto +
                '}';
    }

    public IntegerExpression cantidadProperty() {
        return null;
    }

    public DoubleExpression subtotalProperty() {
        return null;
    }

    public ObservableValue<Producto> productoProperty() {
        return null;
    }
}