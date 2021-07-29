package co.com.sofka.usecase.consulta;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ActualizarConsultaUseCase {
    private final ConsultaRepository consultaRepository;

    public Consulta actualizarConsulta(Consulta consulta){
        Consulta resultado = consultaRepository.obtenerConsulta(consulta.getId());
        if (!resultado.getId().isEmpty()){
            return consultaRepository.actualizarConsulta(consulta);
        }
        throw new  IllegalArgumentException("La consulta no se encuentra creada.");
    }
}
