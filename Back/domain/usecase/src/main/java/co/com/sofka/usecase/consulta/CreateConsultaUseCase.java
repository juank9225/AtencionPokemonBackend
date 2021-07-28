package co.com.sofka.usecase.consulta;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateConsultaUseCase {
    private final ConsultaRepository consultaRepository;

    public Consulta crearConsulta(Consulta consulta){
        return consultaRepository.crearConsulta(consulta);
    }

}
