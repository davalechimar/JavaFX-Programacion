package co.edu.uniquindio.programacion.model;

import java.time.LocalDate;
import java.util.Objects;

public class ProductoRefrigerado extends Producto{
    private String codigoAprobacion;
    private Double tempRefrigeracion;



    public ProductoRefrigerado(String codigo, String nombre, String descripcion, double valor, int cantidad,
                               String tipo, LocalDate fechaVencimiento, String codigoAprobacion,
                               LocalDate fechaEnvasado, double temperaturaRefrigeracion,
                               double pesoEnvase, String paisOrigen) {
        super(codigo, nombre, descripcion, valor, cantidad, tipo, fechaVencimiento, codigoAprobacion, fechaEnvasado, temperaturaRefrigeracion, pesoEnvase, paisOrigen);
        this.codigoAprobacion = codigoAprobacion;
        this.tempRefrigeracion = temperaturaRefrigeracion;
    }

    public ProductoRefrigerado(String codigoAprobacion, Double tempRefrigeracion) {
        super("", "", "", 0.0, 0, "", null, "", null, 0.0, 0.0, "");
        this.codigoAprobacion = codigoAprobacion;
        this.tempRefrigeracion = tempRefrigeracion;
    }

    public String getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(String codigoAprobacion) {
        this.codigoAprobacion = codigoAprobacion;
    }

    public Double getTempRefrigeracion() {
        return tempRefrigeracion;
    }

    public void setTempRefrigeracion(Double tempRefrigeracion) {
        this.tempRefrigeracion = tempRefrigeracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoRefrigerado that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(codigoAprobacion, that.codigoAprobacion) && Objects.equals(tempRefrigeracion, that.tempRefrigeracion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codigoAprobacion, tempRefrigeracion);
    }

    @Override
    public String toString() {
        return "ProductoRefrigerado{" +
                "codigoAprobacion='" + codigoAprobacion + '\'' +
                ", tempRefrigeracion=" + tempRefrigeracion +
                '}';
    }
}

