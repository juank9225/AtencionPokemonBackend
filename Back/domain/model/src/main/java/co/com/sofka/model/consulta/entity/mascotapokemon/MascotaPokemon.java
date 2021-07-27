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
    private List<Tipo> tipo;
    private Habilidad habilidad;

    public MascotaPokemon() {
    }

    public MascotaPokemon(String id, Identificacion identificacion, Nombre nombre, Raza raza, List<Tipo> tipo, Habilidad habilidad) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.habilidad = habilidad;
    }

    public MascotaPokemon(Nombre nombre, Raza raza, List<Tipo> tipo, Habilidad habilidad) {
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.habilidad = habilidad;
    }
}
