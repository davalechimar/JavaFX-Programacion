package co.edu.uniquindio.programacion.model;

import java.util.Objects;

public class PersonaJuridica extends Cliente{
    private String nit;

    public PersonaJuridica() {
    }

    public PersonaJuridica(String nombre, String apellidos, String identificacion, String direccion, String telefono, String email, String personaNatural, String personaJuridica) {
        super(nombre, apellidos, identificacion, direccion, telefono, email, personaNatural, personaJuridica);
        this.nit = nit;
    }

    public PersonaJuridica(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonaJuridica that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(nit, that.nit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nit);
    }

    @Override
    public String toString() {
        return "PersonaJuridica{" +
                "nit='" + nit + '\'' +
                '}';
    }
}
