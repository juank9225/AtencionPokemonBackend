package co.com.sofka.api.dtos;

import co.com.sofka.model.doctorpokemon.values.*;

public class DoctorDTO {
    private String id;
    private Identificacion identificacion;
    private Nombre nombre;
    private Apellido apellido;
    private Telefono telefono;
    private Correo correo;
    private Especialidad especialidad;

    public DoctorDTO() {
    }

    public DoctorDTO(String id, Identificacion identificacion, Nombre nombre, Apellido apellido, Telefono telefono, Correo correo, Especialidad especialidad) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.especialidad = especialidad;
    }

    public DoctorDTO(Nombre nombre, Apellido apellido, Telefono telefono, Correo correo, Especialidad especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.especialidad = especialidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Apellido getApellido() {
        return apellido;
    }

    public void setApellido(Apellido apellido) {
        this.apellido = apellido;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}