package co.com.sofka.model.consulta.entity.mascotapokemon;
import co.com.sofka.model.consulta.values.valueobjectmascota.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MascotaPokemon {
    private String id;
    private IdentificacionMascota identificacionMascota;
    private NombrePokemon nombrePokemon;
    private Raza raza;
    private Tipo tipo;
    private Habilidad habilidad;

    public MascotaPokemon() {
    }

    public MascotaPokemon(String id, IdentificacionMascota identificacionMascota, NombrePokemon nombrePokemon, Raza raza, Tipo tipo, Habilidad habilidad) {
        this.id = id;
        this.identificacionMascota = identificacionMascota;
        this.nombrePokemon = nombrePokemon;
        this.raza = raza;
        this.tipo = tipo;
        this.habilidad = habilidad;
    }

    public MascotaPokemon(NombrePokemon nombrePokemon, Raza raza, Tipo tipo, Habilidad habilidad) {
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

    public IdentificacionMascota getIdentificacionMascota() {
        return identificacionMascota;
    }

    public void setIdentificacionMascota(IdentificacionMascota identificacionMascota) {
        this.identificacionMascota = identificacionMascota;
    }

    public NombrePokemon getNombrePokemon() {
        return nombrePokemon;
    }

    public void setNombrePokemon(NombrePokemon nombrePokemon) {
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
