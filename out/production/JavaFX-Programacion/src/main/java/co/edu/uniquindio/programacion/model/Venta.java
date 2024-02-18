package co.edu.uniquindio.programacion.model;

import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Venta {
    public Cliente getCliente;
    private String codigo;
    private Date fecha;
    private Double total;
    private Double iva;
    private Cliente cliente;

    public Venta() {
    }

    public Venta(String codigo, Date fecha, Double total, Double iva, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
        this.iva = iva;
        this.cliente = cliente;
    }

    public Venta(String text, Date from, String text1) {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venta venta)) return false;
        return Objects.equals(codigo, venta.codigo) && Objects.equals(fecha, venta.fecha) && Objects.equals(total, venta.total) && Objects.equals(iva, venta.iva) && Objects.equals(cliente, venta.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, fecha, total, iva, cliente);
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", total=" + total +
                ", iva=" + iva +
                ", cliente=" + cliente +
                '}';
    }

    public <E> ObservableList<E> getDetallesVenta() {
        return null;
    }
}

