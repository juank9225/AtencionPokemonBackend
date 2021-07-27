package co.com.sofka.usecase.createmascota;

import co.com.sofka.model.mascotapokemon.MascotaPokemon;
import co.com.sofka.model.mascotapokemon.gateways.MascotaPokemonRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CreateMascotaUseCase {
    private final MascotaPokemonRepository mascotaPokemonRepository;

    public MascotaPokemon crearMascota(MascotaPokemon mascotaPokemon){
        return mascotaPokemonRepository.crearMascota(mascotaPokemon);
    }
    public List<MascotaPokemon> listarPokemones(){
        return mascotaPokemonRepository.listarPokemones();
    }
}
