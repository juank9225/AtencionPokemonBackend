package co.com.sofka.usecase.consulta;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListarConsultaIdUseCase {
    private final ConsultaRepository consultaRepository;

    public Consulta obtenerConsulta(String id){
        return consultaRepository.obtenerConsulta(id);
    }
}
