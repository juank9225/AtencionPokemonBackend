package co.com.sofka.api.dtos;

import co.com.sofka.model.consulta.values.valueobjectconsulta.CausaEnfermedad;
import co.com.sofka.model.consulta.values.valueobjectconsulta.EstadoRevision;
import co.com.sofka.model.consulta.values.valueobjectconsulta.FechaConsulta;
import co.com.sofka.model.consulta.values.valueobjectconsulta.Sintomas;

public class ConsultaDTO {
    private String id;
    private FechaConsulta fechaConsulta;
    private CausaEnfermedad causaEnfermedad;
    private Sintomas sintomas;
    private EstadoRevision estadoRevision;
    private String idUsuario;
    private String idMascotaPokemon;

    public ConsultaDTO() {
    }

    public ConsultaDTO(String id, FechaConsulta fechaConsulta, CausaEnfermedad causaEnfermedad, Sintomas sintomas, EstadoRevision estadoRevision, String idUsuario, String idMascotaPokemon) {
        this.id = id;
        this.fechaConsulta = fechaConsulta;
        this.causaEnfermedad = causaEnfermedad;
        this.sintomas = sintomas;
        this.estadoRevision = estadoRevision;
        this.idUsuario = idUsuario;
        this.idMascotaPokemon = idMascotaPokemon;
    }

    public ConsultaDTO(FechaConsulta fechaConsulta, CausaEnfermedad causaEnfermedad, Sintomas sintomas, EstadoRevision estadoRevision, String idUsuario, String idMascotaPokemon) {
        this.fechaConsulta = fechaConsulta;
        this.causaEnfermedad = causaEnfermedad;
        this.sintomas = sintomas;
        this.estadoRevision = estadoRevision;
        this.idUsuario = idUsuario;
        this.idMascotaPokemon = idMascotaPokemon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FechaConsulta getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(FechaConsulta fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public CausaEnfermedad getCausaEnfermedad() {
        return causaEnfermedad;
    }

    public void setCausaEnfermedad(CausaEnfermedad causaEnfermedad) {
        this.causaEnfermedad = causaEnfermedad;
    }

    public Sintomas getSintomas() {
        return sintomas;
    }

    public void setSintomas(Sintomas sintomas) {
        this.sintomas = sintomas;
    }

    public EstadoRevision getEstadoRevision() {
        return estadoRevision;
    }

    public void setEstadoRevision(EstadoRevision estadoRevision) {
        this.estadoRevision = estadoRevision;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdMascotaPokemon() {
        return idMascotaPokemon;
    }

    public void setIdMascotaPokemon(String idMascotaPokemon) {
        this.idMascotaPokemon = idMascotaPokemon;
    }
}
