package co.com.sofka.usecase.atencion;

import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.atencion.gateways.AtencionRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ListarAtencionesFechaDoctorUseCase {
    private final AtencionRepository atencionRepository;

    public List<Atencion> listarAtencionesFechaDoctor(String fecha, String idDoctor) {
        List<Atencion> atenciones = atencionRepository.listarAtencionesFechaDoctor(idDoctor);
        atenciones.stream().filter(a -> a.getFechaAtencion().getValor().equals(fecha)).collect(Collectors.toList());
        if (!atenciones.isEmpty()) {
            return atenciones;
        }
        throw new  IllegalArgumentException("el doctor no tiene atenciones en esta fecha.");
    }
}
