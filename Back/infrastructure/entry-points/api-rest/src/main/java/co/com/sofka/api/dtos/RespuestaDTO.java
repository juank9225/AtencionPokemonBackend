package co.com.sofka.api.dtos;

import org.springframework.http.ResponseEntity;

public class RespuestaDTO {
    private Boolean resgistrado;

    public RespuestaDTO() {
    }

    public RespuestaDTO(Boolean resgistrado) {
        this.resgistrado = resgistrado;
    }

    public Boolean getResgistrado() {
        return resgistrado;
    }

    public void setResgistrado(Boolean resgistrado) {
        this.resgistrado = resgistrado;
    }
}
