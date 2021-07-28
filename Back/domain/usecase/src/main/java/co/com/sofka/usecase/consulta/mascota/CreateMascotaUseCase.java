package co.com.sofka.usecase.consulta.mascota;

import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.model.consulta.entity.mascotapokemon.gateways.MascotaPokemonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateMascotaUseCase {
    private final MascotaPokemonRepository mascotaPokemonRepository;

    public MascotaPokemon crearMascota(MascotaPokemon mascotaPokemon){
        return mascotaPokemonRepository.crearMascota(mascotaPokemon);
    }

}
