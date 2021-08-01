package co.com.sofka.model.atencion.gateways;

import co.com.sofka.model.atencion.Atencion;

import java.util.List;

public interface AtencionRepository {
    Atencion crearAtencion(Atencion atencion);
    List<Atencion> listarAtenciones();
    Atencion obtenerAtencion(String id);
    List<Atencion> listarAtencionesFechaDoctor(String fecha);
    List<Atencion> obtenerAtencionIdDoctor(String idDoctor);
    List<Atencion> obtenerAtencionesXConsulta(String id);
}
