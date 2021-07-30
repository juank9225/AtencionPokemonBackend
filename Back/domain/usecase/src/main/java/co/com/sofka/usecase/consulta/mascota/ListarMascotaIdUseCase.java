package co.com.sofka.usecase.consulta.mascota;

import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.model.consulta.entity.mascotapokemon.gateways.MascotaPokemonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListarMascotaIdUseCase {
    private final MascotaPokemonRepository mascotaPokemonRepository;

    public MascotaPokemon obtenerMascota(String id) {
        return mascotaPokemonRepository.obtenerMascota(id);
    }
}
