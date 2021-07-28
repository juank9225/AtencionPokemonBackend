package co.com.sofka.api.dtos;

import co.com.sofka.model.atencion.values.valueobjectatencion.Diagnostico;
import co.com.sofka.model.atencion.values.valueobjectatencion.FechaDeAtencion;

public class AtencionDTO {
    private String id;
    private String idConsulta;
    private String idDoctor;
    private Diagnostico diagnostico;
    private FechaDeAtencion fechaAtencion;

    public AtencionDTO(String id, String idConsulta, String idDoctor, Diagnostico diagnostico, FechaDeAtencion fechaAtencion) {
        this.id = id;
        this.idConsulta = idConsulta;
        this.idDoctor = idDoctor;
        this.diagnostico = diagnostico;
        this.fechaAtencion = fechaAtencion;
    }

    public AtencionDTO(String idConsulta, String idDoctor, Diagnostico diagnostico, FechaDeAtencion fechaAtencion) {
        this.idConsulta = idConsulta;
        this.idDoctor = idDoctor;
        this.diagnostico = diagnostico;
        this.fechaAtencion = fechaAtencion;
    }

    public AtencionDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public FechaDeAtencion getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(FechaDeAtencion fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
}
