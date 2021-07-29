package co.com.sofka.usecase.atencion;

import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import co.com.sofka.model.atencion.gateways.AtencionRepository;
import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import co.com.sofka.model.consulta.values.valueobjectconsulta.EstadoRevision;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAtencionUseCase {
    private final AtencionRepository atencionRepository;
    private final DoctorpokemonRepository doctorpokemonRepository;
    private final ConsultaRepository consultaRepository;

    public Atencion crearatencion(Atencion atencion){
        Doctorpokemon doctor = doctorpokemonRepository.obtenerDoctor(atencion.getIdDoctor());
        Consulta consulta = consultaRepository.obtenerConsulta(atencion.getIdConsulta());
        if (!doctor.getId().isEmpty() && !consulta.getEstadoRevision().getValor()){
            Atencion atencionCreada = atencionRepository.crearAtencion(atencion);
            consulta.setEstadoRevision(new EstadoRevision(true));
            consultaRepository.actualizarConsulta(consulta);
            return atencionCreada;
        }
        throw new  IllegalArgumentException("la atencion no se pudo crear correctamente.");
    }
}
