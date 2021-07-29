package co.com.sofka.model.consulta.entity.mascotapokemon;
import co.com.sofka.model.consulta.values.valueobjectmascota.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class MascotaPokemon {
    private String id;
    private Identificacion identificacion;
    private Nombre nombre;
    private Raza raza;
    private Tipo tipo;
    private Habilidad habilidad;

    public MascotaPokemon() {
    }

    public MascotaPokemon(String id, Identificacion identificacion, Nombre nombre, Raza raza, Tipo tipo, Habilidad habilidad) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.habilidad = habilidad;
    }

    public MascotaPokemon(Nombre nombre, Raza raza, Tipo tipo, Habilidad habilidad) {
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }
}
