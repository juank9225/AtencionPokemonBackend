package co.com.sofka.usecase.atencion.doctorpokemon;

import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ActualizarDoctorUseCase {
    private final DoctorpokemonRepository doctorpokemonRepository;

    public Doctorpokemon actualizarDoctor(Doctorpokemon doctorpokemon){
        Doctorpokemon resp = doctorpokemonRepository.obtenerDoctor(doctorpokemon.getId());
        if (!resp.getId().isEmpty()){
            return doctorpokemonRepository.actualizarDoctor(doctorpokemon);
        }
        throw new  IllegalArgumentException("El doctor no pudo ser actualizado.");
    }
}
