package co.com.sofka.api.dtos;

import co.com.sofka.model.consulta.values.valueobjectmascota.*;

import java.util.List;

public class MascotaDTO {
    private String id;
    private Identificacion identificacion;
    private Nombre nombre;
    private Raza raza;
    private List<Tipo> tipo;
    private Habilidad habilidad;

    public MascotaDTO() {
    }

    public MascotaDTO(String id, Identificacion identificacion, Nombre nombre, Raza raza, List<Tipo> tipo, Habilidad habilidad) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.habilidad = habilidad;
    }

    public MascotaDTO(Identificacion identificacion, Nombre nombre, Raza raza, List<Tipo> tipo, Habilidad habilidad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.habilidad = habilidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public List<Tipo> getTipo() {
        return tipo;
    }

    public void setTipo(List<Tipo> tipo) {
        this.tipo = tipo;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }
}
