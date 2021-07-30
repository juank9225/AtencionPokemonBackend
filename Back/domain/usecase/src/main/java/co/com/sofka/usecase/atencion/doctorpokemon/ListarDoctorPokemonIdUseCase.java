package co.com.sofka.usecase.atencion.doctorpokemon;

import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListarDoctorPokemonIdUseCase {
    private final DoctorpokemonRepository doctorpokemonRepository;

    public Doctorpokemon obtenerDoctor(String id){
        return doctorpokemonRepository.obtenerDoctor(id);
    }
}
