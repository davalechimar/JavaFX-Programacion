package co.edu.uniquindio.programacion.model;

import javafx.beans.property.*;
import java.time.LocalDate;
import java.util.Objects;

public class Producto {

    private final StringProperty codigo = new SimpleStringProperty();
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty descripcion = new SimpleStringProperty();
    private final StringProperty tipo = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> fechaVencimiento = new SimpleObjectProperty<>();
    private final StringProperty codigoAprobacion = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> fechaEnvasado = new SimpleObjectProperty<>();
    private final DoubleProperty temperaturaRefrigeracion = new SimpleDoubleProperty();
    private final DoubleProperty pesoEnvase = new SimpleDoubleProperty();
    private final StringProperty paisOrigen = new SimpleStringProperty();
    private final DoubleProperty valorUnitario = new SimpleDoubleProperty();
    private final IntegerProperty cantidadExistencias = new SimpleIntegerProperty();

    public Producto(String codigo, String nombre, String descripcion, Double valorUnitario, Integer cantidadExistencias,
                    String tipo, LocalDate fechaVencimiento, String codigoAprobacion,
                    LocalDate fechaEnvasado, Double temperaturaRefrigeracion,
                    Double pesoEnvase, String paisOrigen) {
        setCodigo(codigo);
        setNombre(nombre);
        setDescripcion(descripcion);
        setValorUnitario(valorUnitario);
        setCantidadExistencias(cantidadExistencias);
        setTipo(tipo);
        setFechaVencimiento(fechaVencimiento);
        setCodigoAprobacion(codigoAprobacion);
        setFechaEnvasado(fechaEnvasado);
        setTemperaturaRefrigeracion(temperaturaRefrigeracion);
        setPesoEnvase(pesoEnvase);
        setPaisOrigen(paisOrigen);
    }


    public Producto(String codigo, String nombre, String descripcion, double valor, int cantidad, String tipo) {
    }

    public Producto(String codigo, String nombre, String descripcion, Double valorUnitario, Integer cantidadExistencias) {
    }


    public String getCodigo() {
        return codigo.get();
    }

    public StringProperty codigoProperty() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public double getValorUnitario() {
        return valorUnitario.get();
    }

    public DoubleProperty valorUnitarioProperty() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario.set(valorUnitario);
    }

    public int getCantidadExistencias() {
        return cantidadExistencias.get();
    }

    public IntegerProperty cantidadExistenciasProperty() {
        return cantidadExistencias;
    }

    public void setCantidadExistencias(int cantidadExistencias) {
        this.cantidadExistencias.set(cantidadExistencias);
    }

    public String getTipo() {
        return tipo.get();
    }

    public StringProperty tipoProperty() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento.get();
    }

    public ObjectProperty<LocalDate> fechaVencimientoProperty() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento.set(fechaVencimiento);
    }

    public String getCodigoAprobacion() {
        return codigoAprobacion.get();
    }

    public StringProperty codigoAprobacionProperty() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(String codigoAprobacion) {
        this.codigoAprobacion.set(codigoAprobacion);
    }

    public LocalDate getFechaEnvasado() {
        return fechaEnvasado.get();
    }

    public ObjectProperty<LocalDate> fechaEnvasadoProperty() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(LocalDate fechaEnvasado) {
        this.fechaEnvasado.set(fechaEnvasado);
    }

    public double getTemperaturaRefrigeracion() {
        return temperaturaRefrigeracion.get();
    }

    public DoubleProperty temperaturaRefrigeracionProperty() {
        return temperaturaRefrigeracion;
    }

    public void setTemperaturaRefrigeracion(double temperaturaRefrigeracion) {
        this.temperaturaRefrigeracion.set(temperaturaRefrigeracion);
    }

    public double getPesoEnvase() {
        return pesoEnvase.get();
    }

    public DoubleProperty pesoEnvaseProperty() {
        return pesoEnvase;
    }

    public void setPesoEnvase(double pesoEnvase) {
        this.pesoEnvase.set(pesoEnvase);
    }

    public String getPaisOrigen() {
        return paisOrigen.get();
    }

    public StringProperty paisOrigenProperty() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen.set(paisOrigen);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(getCodigo(), producto.getCodigo()) &&
                Objects.equals(getNombre(), producto.getNombre()) &&
                Objects.equals(getDescripcion(), producto.getDescripcion()) &&
                Objects.equals(getValorUnitario(), producto.getValorUnitario()) &&
                Objects.equals(getCantidadExistencias(), producto.getCantidadExistencias());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getNombre(), getDescripcion(), getValorUnitario(), getCantidadExistencias());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + getCodigo() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", valorUnitario=" + getValorUnitario() +
                ", cantidadExistencias=" + getCantidadExistencias() +
                '}';
    }
}
