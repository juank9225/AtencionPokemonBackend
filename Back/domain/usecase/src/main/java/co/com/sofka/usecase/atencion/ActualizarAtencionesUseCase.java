package co.com.sofka.usecase.atencion;

import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.atencion.gateways.AtencionRepository;
import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import co.com.sofka.model.consulta.values.valueobjectconsulta.EstadoRevision;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ActualizarAtencionesUseCase {
    private final AtencionRepository atencionRepository;
    private final ConsultaRepository consultaRepository;

    public Atencion actualizarAtencion(Atencion atencion){
        Atencion resultado = atencionRepository.obtenerAtencion(atencion.getId());
        if (!resultado.getId().isEmpty()){
            Consulta consulta = consultaRepository.obtenerConsulta(atencion.getIdConsulta());
            consulta.setEstadoRevision(new EstadoRevision(true));
            consultaRepository.actualizarConsulta(consulta);
            return atencionRepository.actualizarAtencion(atencion);
        }
        throw new  IllegalArgumentException("La atencion no se puede modificar.");
    }
}
