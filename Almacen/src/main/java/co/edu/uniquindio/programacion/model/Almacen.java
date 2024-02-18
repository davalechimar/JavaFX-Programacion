package co.edu.uniquindio.programacion.model;


import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.time.LocalDate;


public class Almacen {
    private List<Cliente> listaClientes = new ArrayList<Cliente>();
    private List<Producto> listaProductos = new ArrayList<Producto>();
    private List<Venta> listaVentas = new ArrayList<Venta>();

    public Almacen() {
    }

    public Almacen(List<Cliente> listaClientes, List<Producto> listaProductos, List<Venta> listaVentas) {
        this.listaClientes = listaClientes;
        this.listaProductos = listaProductos;
        this.listaVentas = listaVentas;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Almacen almacen)) return false;
        return Objects.equals(listaClientes, almacen.listaClientes) && Objects.equals(listaProductos, almacen.listaProductos) && Objects.equals(listaVentas, almacen.listaVentas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaClientes, listaProductos, listaVentas);
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "listaClientes=" + listaClientes +
                ", listaProductos=" + listaProductos +
                ", listaVentas=" + listaVentas +
                '}';
    }

    /**
     * este metodo se usa para registrar un cliente natural, es decir, un cliente que es una persona natural
     * @param nombre nombre del cliente
     * @param apellido apellido del cliente
     * @param identificacion identificacion del cliente
     * @param direccion direccion del cliente
     * @param telefono telefono del cliente
     * @param email correo del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     */
    public void registrarClienteNatural(String nombre, String apellido, String identificacion, String direccion, String telefono, String email, Date fechaNacimiento){
        Cliente cliente = new Cliente("Nombre", "Apellidos", "Identificación", "Dirección", "Teléfono", "Email", "Persona Natural", "Persona Jurídica");
        listaClientes.add(cliente);
    }

    /**
     * este metodo se usa para registrar un cliente juridico, es decir, un cliente que es una persona juridica
     * @param nombre nombre del cliente
     * @param apellido apellido del cliente
     * @param identificacion identificacion del cliente
     * @param direccion direccion del cliente
     * @param telefono telefono del cliente
     * @param nit nit del cliente
     */
    public void registrarClienteJuridico(String nombre, String apellido, String identificacion, String direccion, String telefono, String nit){
        Cliente cliente = new Cliente("Nombre", "Apellidos", "Identificación", "Dirección", "Teléfono", "Email", "Persona Natural", "Persona Jurídica");
        listaClientes.add(cliente);
    }

    /**
     * este metodo se utiliza para registrar productos perecederos
     * @param codigo codigo del producto
     * @param nombre nombre del producto
     * @param descripcion descripcion del producto
     * @param valorUnitario valor unitario del producto
     * @param cantidadExistencias cantidad de existencias del producto
     * @param fechaVencimiento decha de vencimiento del producto
     */
    public void registrarProductoPerecedero(String codigo, String nombre, String descripcion, Double valorUnitario, Integer cantidadExistencias, Date fechaVencimiento, String codigoAprobacion) {
        LocalDate fechaVencimientoLocalDate = fechaVencimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Producto producto = new ProductoPerecedero(codigo, nombre, descripcion, valorUnitario, cantidadExistencias, "Perecedero", fechaVencimientoLocalDate);
        listaProductos.add(producto);
    }





    /**
     * este metodo se utiliza para registrar productos refrigerados
     * @param codigo codigo del producto
     * @param nombre nombre del producto
     * @param descripcion descripcion del producto
     * @param valorUnitario valor unitario del producto
     * @param cantidadExistencias cantidad de existencias del producto
     * @param codigoAprobacion codigo de aprobacion del producto
     * @param tempRefri temperatura de refrigeracion del producto
     */
    public void registrarProductoRefrigerado(String codigo, String nombre, String descripcion, Double valorUnitario, Integer cantidadExistencias, String tipo, LocalDate fechaVencimiento, String codigoAprobacion, LocalDate fechaEnvasado, Double tempRefri, Double pesoEnvase, String paisOrigen) {
        Producto producto = new ProductoRefrigerado(codigo, nombre, descripcion, valorUnitario, cantidadExistencias, tipo, fechaVencimiento, codigoAprobacion, fechaEnvasado, tempRefri, pesoEnvase, paisOrigen);
        listaProductos.add(producto);
    }


    /**
     * este metodo se utiliza para registrar productos envasados
     * @param codigo codigo del producto
     * @param nombre nombre del producto
     * @param descripcion descripcion del producto
     * @param valorUnitario valor unitario del producto
     * @param cantidadExistencias cantidad de existencias del producto
     * @param fechaEnvasado fecha de envasado del producto
     * @param pesoEnvase peso del envase del producto
     * @param paisOrigen pais de origen del producto
     */
    public void registrarProductoEnvasado(String codigo, String nombre, String descripcion, Double valorUnitario, Integer cantidadExistencias, Date fechaEnvasado, Double pesoEnvase, PaisOrigen paisOrigen){
        LocalDate fechaEnvasadoLocalDate = fechaEnvasado.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Producto producto = new ProductoEnvasado(codigo, nombre, descripcion, valorUnitario, cantidadExistencias, fechaEnvasadoLocalDate, pesoEnvase, paisOrigen);
        listaProductos.add(producto);
    }

    /**
     * este metodo se utiliza para registrar las ventas
     * @param codigo codigo de la venta
     * @param fecha fecha en que se realizo la venta
     * @param total precio total de la venta (subtotal + iva)
     * @param iva iva de la venta
     * @param cliente cliente de la venta
     * @param cantidad cantidad de productos vendidos
     * @param subtotal subtotal de la venta
     * @param producto producto vendido
     */
    public void registrarVenta(String codigo, Date fecha, Double total, Double iva, Cliente cliente, Integer cantidad, Double subtotal, Producto producto){
        Venta venta = new DetalleVenta(codigo, fecha, total, iva, cliente, cantidad, subtotal, producto);
        listaVentas.add(venta);
    }
}
