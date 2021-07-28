package co.com.sofka.usecase.atencion.doctorpokemon;

import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListarDoctorPokemonUseCase {
    private final DoctorpokemonRepository doctorpokemonRepository;

    public List<Doctorpokemon> listarDoctores(){
      return doctorpokemonRepository.listarDoctores();
    }
}
