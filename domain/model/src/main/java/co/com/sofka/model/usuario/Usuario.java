package co.com.sofka.model.usuario;
import co.com.sofka.model.usuario.valueobjectuser.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Usuario {
    private Identificacion identificacion;
    private Nombre nombre;
    private Apellido apellido;
    private Telefono telefono;
    private Profesion profesion;
    private Correo correo;

    public Usuario() {
    }

    public Usuario(Identificacion identificacion,Nombre nombre, Apellido apellido, Telefono telefono, Profesion profesion, Correo correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.profesion = profesion;
        this.correo = correo;
    }

    public Usuario(Nombre nombre, Apellido apellido, Telefono telefono, Profesion profesion, Correo correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.profesion = profesion;
        this.correo = correo;
    }
}
