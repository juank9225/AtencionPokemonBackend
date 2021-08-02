package co.com.sofka.model.atencion.entity.doctorpokemon.gateways;

import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;

import java.util.List;

public interface DoctorpokemonRepository {
    Doctorpokemon crearDoctor(Doctorpokemon doctorpokemon);
    List<Doctorpokemon> listarDoctores();
    Doctorpokemon obtenerDoctor(String id);
    Doctorpokemon actualizarDoctor(Doctorpokemon doctorpokemon);
    Doctorpokemon validarDoctor(String correo);
}
