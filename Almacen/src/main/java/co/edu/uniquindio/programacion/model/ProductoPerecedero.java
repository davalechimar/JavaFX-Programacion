package co.edu.uniquindio.programacion.model;

import java.time.LocalDate;
import java.util.Objects;

public class ProductoPerecedero extends Producto {
    private LocalDate fechaVencimiento;

    public ProductoPerecedero(String codigo, String nombre, String descripcion, double valor, int cantidad,
                              String tipo, LocalDate fechaVencimiento) {
        super(codigo, nombre, descripcion, valor, cantidad, tipo);
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoPerecedero)) return false;
        if (!super.equals(o)) return false;
        ProductoPerecedero that = (ProductoPerecedero) o;
        return Objects.equals(fechaVencimiento, that.fechaVencimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fechaVencimiento);
    }

    @Override
    public String toString() {
        return "ProductoPerecedero{" +
                "fechaVencimiento=" + fechaVencimiento +
                '}';
    }
}

