package co.com.sofka.usecase.createconsulta;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CreateConsultaUseCase {
    private final ConsultaRepository consultaRepository;

    public Consulta crearConsulta(Consulta consulta){
        return consultaRepository.crearConsulta(consulta);
    }

    public List<Consulta> listarConsultas(){
        return consultaRepository.listarConsultas();
    }
}
