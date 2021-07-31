package co.com.sofka.usecase.consulta;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ObtenerConsultaIdUsuarioUseCase {
    private final ConsultaRepository consultaRepository;

    public List<Consulta> obtenerConsultaIdUsuario(String idUsuario){
        return consultaRepository.obtenerConsultaIdUsuario(idUsuario);
    }
}
