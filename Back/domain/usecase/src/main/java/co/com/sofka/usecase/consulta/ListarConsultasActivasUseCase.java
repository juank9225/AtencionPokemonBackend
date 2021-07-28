package co.com.sofka.usecase.consulta;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ListarConsultasActivasUseCase {
    private final ConsultaRepository consultaRepository;

    public List<Consulta> listarConsultasActivas(String fecha){
       List<Consulta> consuta = consultaRepository.listarConsultasActivas(fecha);
       List<Consulta> resultado =  consuta.stream().filter(c->c.getEstadoRevision().getValor()==true).collect(Collectors.toList());
       return resultado;
    }
}
