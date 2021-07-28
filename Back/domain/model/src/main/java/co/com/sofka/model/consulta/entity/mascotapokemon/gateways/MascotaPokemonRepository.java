package co.com.sofka.model.consulta.entity.mascotapokemon.gateways;

import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;

import java.util.List;

public interface MascotaPokemonRepository {
    MascotaPokemon crearMascota(MascotaPokemon mascotaPokemon);
    List<MascotaPokemon> listarPokemones();
    MascotaPokemon obtenerMascota(String id);
}
