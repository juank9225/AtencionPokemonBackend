package co.com.sofka.usecase.consulta.mascota;

import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.model.consulta.entity.mascotapokemon.gateways.MascotaPokemonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ActualizarMascotaUseCase {
    private final MascotaPokemonRepository mascotaPokemonRepository;

    public MascotaPokemon actualizarMascota(MascotaPokemon mascotaPokemon){
        MascotaPokemon resultado = mascotaPokemonRepository.obtenerMascota(mascotaPokemon.getId());
        if (!resultado.getId().isEmpty()){
            return mascotaPokemonRepository.actualizarMascota(mascotaPokemon);
        }
        throw new  IllegalArgumentException("La mascota no se encuentra creada.");
    }
}
