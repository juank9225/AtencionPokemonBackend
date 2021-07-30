package co.com.sofka.usecase.atencion;

import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.atencion.gateways.AtencionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListarAtencionIdUseCase {
    private final AtencionRepository atencionRepository;

    public Atencion obtenerAtencion(String id){
        return atencionRepository.obtenerAtencion(id);
    }
}
