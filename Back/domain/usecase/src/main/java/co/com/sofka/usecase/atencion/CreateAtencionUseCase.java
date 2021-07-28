package co.com.sofka.usecase.atencion;

import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.atencion.gateways.AtencionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAtencionUseCase {
    private final AtencionRepository atencionRepository;

    public Atencion crearatencion(Atencion atencion){
        return atencionRepository.crearAtencion(atencion);
    }
}
