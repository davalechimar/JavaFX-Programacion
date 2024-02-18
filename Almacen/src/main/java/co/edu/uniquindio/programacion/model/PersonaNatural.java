package co.edu.uniquindio.programacion.model;

import java.util.Date;
import java.util.Objects;

public class PersonaNatural extends Cliente{
    private String email;
    private Date fechaNacimiento;

    public PersonaNatural() {
    }

    public PersonaNatural(String nombre, String apellidos, String identificacion, String direccion, String telefono, String email, String personaNatural, String personaJuridica) {
        super(nombre, apellidos, identificacion, direccion, telefono, email, personaNatural, personaJuridica);
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public PersonaNatural(String email, Date fechaNacimiento) {
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonaNatural that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(email, that.email) && Objects.equals(fechaNacimiento, that.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "PersonaNatural{" +
                "email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
