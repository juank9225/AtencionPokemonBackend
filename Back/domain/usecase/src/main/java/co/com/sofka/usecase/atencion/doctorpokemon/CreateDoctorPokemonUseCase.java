package co.com.sofka.usecase.atencion.doctorpokemon;

import co.com.sofka.model.doctorpokemon.Doctorpokemon;
import co.com.sofka.model.doctorpokemon.gateways.DoctorpokemonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateDoctorPokemonUseCase {
    private final DoctorpokemonRepository doctorpokemonRepository;

    public Doctorpokemon creardoctor(Doctorpokemon doctorpokemon){
        return doctorpokemonRepository.creardoctor(doctorpokemon);
    }
}
