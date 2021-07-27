package co.com.sofka.model.mascotapokemon.gateways;

import co.com.sofka.model.mascotapokemon.MascotaPokemon;

import java.util.List;

public interface MascotaPokemonRepository {
    MascotaPokemon crearMascota(MascotaPokemon mascotaPokemon);
    List<MascotaPokemon> listarPokemones();
}
