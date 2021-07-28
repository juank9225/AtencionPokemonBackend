package co.com.sofka.usecase.consulta;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListarConsultaUseCase {
    private final ConsultaRepository consultaRepository;

    public List<Consulta> listarConsultas(){
        return consultaRepository.listarConsultas();
    }
}
