package co.com.sofka.model.consulta;
import co.com.sofka.model.consulta.values.valueobjectconsulta.CausaEnfermedad;
import co.com.sofka.model.consulta.values.valueobjectconsulta.EstadoRevision;
import co.com.sofka.model.consulta.values.valueobjectconsulta.FechaConsulta;
import co.com.sofka.model.consulta.values.valueobjectconsulta.Sintomas;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Consulta {
    private String id;
    private FechaConsulta fechaConsulta;
    private CausaEnfermedad causaEnfermedad;
    private Sintomas sintomas;
    private EstadoRevision estadoRevision;
    private String idUsuario;
    private String idMascotaPokemon;

    public Consulta() {
    }

    public Consulta(String id, FechaConsulta fechaConsulta, CausaEnfermedad causaEnfermedad, Sintomas sintomas, EstadoRevision estadoRevision, String idUsuario, String idMascotaPokemon) {
        this.id = id;
        this.fechaConsulta = fechaConsulta;
        this.causaEnfermedad = causaEnfermedad;
        this.sintomas = sintomas;
        this.estadoRevision = estadoRevision;
        this.idUsuario = idUsuario;
        this.idMascotaPokemon = idMascotaPokemon;
    }

    public Consulta(FechaConsulta fechaConsulta, CausaEnfermedad causaEnfermedad, Sintomas sintomas, EstadoRevision estadoRevision, String idUsuario, String idMascotaPokemon) {
        this.fechaConsulta = fechaConsulta;
        this.causaEnfermedad = causaEnfermedad;
        this.sintomas = sintomas;
        this.estadoRevision = estadoRevision;
        this.idUsuario = idUsuario;
        this.idMascotaPokemon = idMascotaPokemon;
    }
}
