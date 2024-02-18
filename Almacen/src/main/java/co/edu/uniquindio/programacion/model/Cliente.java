package co.edu.uniquindio.programacion.model;

import java.util.Objects;

public class Cliente {
    private String email;
    private String personaNatural;
    private String personaJuridica;
    private String nombre;
    private String apellido; // Cambiado de "apellidos" a "apellido"
    private String identificacion;
    private String direccion;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String identificacion, String direccion, String telefono, String email, String personaNatural, String personaJuridica) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.personaNatural = personaNatural;
        this.personaJuridica = personaJuridica;
    }


    // ... Otros métodos getter y setter

    public static void main(String[] args) {
        // Crear un objeto Cliente utilizando el constructor con 8 argumentos
        Cliente cliente = new Cliente("Nombre", "Apellidos", "Identificación", "Dirección", "Teléfono", "Email", "Persona Natural", "Persona Jurídica");

        // Imprimir los detalles del cliente
        System.out.println(cliente);
    }


    // Métodos getter y setter para las variables

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(identificacion, cliente.identificacion) && Objects.equals(direccion, cliente.direccion) && Objects.equals(telefono, cliente.telefono) && Objects.equals(personaNatural, cliente.personaNatural) && Objects.equals(personaJuridica, cliente.personaJuridica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, identificacion, direccion, telefono, personaNatural, personaJuridica);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", personaNatural='" + personaNatural + '\'' +
                ", personaJuridica='" + personaJuridica + '\'' +
                '}';
    }

    // Metodos Getter
    public String getEmail() {
        return email;
    }

    public String getPersonaNatural() {
        return personaNatural;
    }

    public String getPersonaJuridica() {
        return personaJuridica;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    // Métodos setter
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPersonaNatural(String personaNatural) {
        this.personaNatural = personaNatural;
    }

    public void setPersonaJuridica(String personaJuridica) {
        this.personaJuridica = personaJuridica;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}


/*-----------------------------------------------------------------------------------------------------------------------------------------------*/
/*package main.java.co.edu.uniquindio.programacion.model;

import java.util.Objects;

public class Cliente {
    private final String email;
    private final String personaNatural;

    private final String personaJuridica;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String identificacion, String direccion, String telefono, String email, String personaNatural, String personaJuridica) {
        this.nombre = nombre;
        this.apellido = apellidos;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.personaNatural = personaNatural;
        this.personaJuridica = personaJuridica;
        this.email = email;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(identificacion, cliente.identificacion) && Objects.equals(direccion, cliente.direccion) && Objects.equals(telefono, cliente.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, identificacion, direccion, telefono);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
} */
