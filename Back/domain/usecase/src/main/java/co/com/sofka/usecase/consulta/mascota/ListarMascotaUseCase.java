package co.com.sofka.usecase.consulta.mascota;

import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.model.consulta.entity.mascotapokemon.gateways.MascotaPokemonRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListarMascotaUseCase {
    private final MascotaPokemonRepository mascotaPokemonRepository;

    public List<MascotaPokemon> listarPokemones(){
        return mascotaPokemonRepository.listarPokemones();
    }
}
