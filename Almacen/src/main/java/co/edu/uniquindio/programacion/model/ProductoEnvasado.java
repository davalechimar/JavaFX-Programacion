package co.edu.uniquindio.programacion.model;

import java.time.LocalDate; // Importa LocalDate en lugar de java.util.Date
import java.util.Objects;

public class ProductoEnvasado extends Producto {
    private LocalDate fechaEnvasado; // Usa LocalDate en lugar de java.util.Date
    private Double pesoEnvase;
    private PaisOrigen paisOrigen;

    public ProductoEnvasado(String codigo, String nombre, String descripcion, Double valorUnitario, Integer cantidadExistencias,
                            LocalDate fechaEnvasado, Double pesoEnvase, PaisOrigen paisOrigen) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistencias);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
        this.paisOrigen = paisOrigen;
    }

    public LocalDate getFechaEnvasado() { // Cambia el tipo de retorno a LocalDate
        return fechaEnvasado;
    }

    public void setFechaEnvasado(LocalDate fechaEnvasado) { // Cambia el tipo de parámetro a LocalDate
        this.fechaEnvasado = fechaEnvasado;
    }

    public double getPesoEnvase() {
        return pesoEnvase;
    }



    public void setPesoEnvase(Double pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }

    public String getPaisOrigen() {
        return paisOrigen.toString(); // Si PaisOrigen implementa toString()
    }


    public void setPaisOrigen(PaisOrigen paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoEnvasado)) return false;
        if (!super.equals(o)) return false;
        ProductoEnvasado that = (ProductoEnvasado) o;
        return Objects.equals(fechaEnvasado, that.fechaEnvasado) && Objects.equals(pesoEnvase, that.pesoEnvase) && paisOrigen == that.paisOrigen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fechaEnvasado, pesoEnvase, paisOrigen);
    }

    @Override
    public String toString() {
        return "ProductoEnvasado{" +
                "fechaEnvasado=" + fechaEnvasado +
                ", pesoEnvase=" + pesoEnvase +
                ", paisOrigen=" + paisOrigen +
                '}';
    }
}

