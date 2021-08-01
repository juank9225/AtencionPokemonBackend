package co.com.sofka.usecase.atencion;

import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.atencion.gateways.AtencionRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ObtenerAtencionesXConsultasUseCase {
    private final AtencionRepository atencionRepository;

    public List<Atencion> obtenerAtencionesXConsulta(String id){
        return atencionRepository.obtenerAtencionesXConsulta(id);
    }
}
