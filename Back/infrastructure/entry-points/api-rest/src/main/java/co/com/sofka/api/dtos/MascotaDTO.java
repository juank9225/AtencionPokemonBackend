package co.com.sofka.api.dtos;

import co.com.sofka.model.consulta.values.valueobjectmascota.*;

public class MascotaDTO {
    private String id;
    private IdentificacionMascota identificacionMascota;
    private NombrePokemon nombrePokemon;
    private Raza raza;
    private Tipo tipo;
    private Habilidad habilidad;

    public MascotaDTO() {
    }

    public MascotaDTO(String id, IdentificacionMascota identificacionMascota, NombrePokemon nombrePokemon, Raza raza, Tipo tipo, Habilidad habilidad) {
        this.id = id;
        this.identificacionMascota = identificacionMascota;
        this.nombrePokemon = nombrePokemon;
        this.raza = raza;
        this.tipo = tipo;
        this.habilidad = habilidad;
    }

    public MascotaDTO(IdentificacionMascota identificacionMascota, NombrePokemon nombrePokemon, Raza raza, Tipo tipo, Habilidad habilidad) {
        this.identificacionMascota = identificacionMascota;
        this.nombrePokemon = nombrePokemon;
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

    public IdentificacionMascota getIdentificacion() {
        return identificacionMascota;
    }

    public void setIdentificacion(IdentificacionMascota identificacionMascota) {
        this.identificacionMascota = identificacionMascota;
    }

    public NombrePokemon getNombre() {
        return nombrePokemon;
    }

    public void setNombre(NombrePokemon nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
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
