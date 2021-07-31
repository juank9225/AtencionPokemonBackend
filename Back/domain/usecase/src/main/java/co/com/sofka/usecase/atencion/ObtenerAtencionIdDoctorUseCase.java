package co.com.sofka.usecase.atencion;

import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.atencion.gateways.AtencionRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ObtenerAtencionIdDoctorUseCase {
    private final AtencionRepository atencionRepository;

    public List<Atencion> obtenerAtencionIdDoctor(String idDoctor){
        return atencionRepository.obtenerAtencionIdDoctor(idDoctor);
    }
}
