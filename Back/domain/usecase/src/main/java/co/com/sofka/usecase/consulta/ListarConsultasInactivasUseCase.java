package co.com.sofka.usecase.consulta;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ListarConsultasInactivasUseCase {
    private final ConsultaRepository consultaRepository;

    public List<Consulta> listarConsultasInactivas(String fecha){
        List<Consulta> consulta = consultaRepository.listarConsultasInactivas(fecha);
        List<Consulta> resultado = consulta.stream().filter(a->a.getEstadoRevision().getValor()==false).collect(Collectors.toList());
        return resultado;
    }
}
