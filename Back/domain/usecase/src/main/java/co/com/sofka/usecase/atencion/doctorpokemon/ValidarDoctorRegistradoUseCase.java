package co.com.sofka.usecase.atencion.doctorpokemon;

import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidarDoctorRegistradoUseCase {
    private final DoctorpokemonRepository doctorpokemonRepository;

    public Doctorpokemon validarDoctor(String correo){
        return doctorpokemonRepository.validarDoctor(correo);
    }
}
