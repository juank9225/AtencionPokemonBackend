package co.com.sofka.model.consulta.gateways;

import co.com.sofka.model.consulta.Consulta;

import java.util.List;

public interface ConsultaRepository {
    Consulta crearConsulta(Consulta consulta);
    List<Consulta> listarConsultas();
    List<Consulta> listarConsultasActivas(String fecha);
    List<Consulta> listarConsultasInactivas(String fecha);
    Consulta actualizarConsulta(Consulta consulta);
    Consulta obtenerConsulta(String id);
}
