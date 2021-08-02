package co.com.sofka.api.apirest.consultaapirest.usuarioapirest;

import co.com.sofka.api.dtos.RespuestaDTO;
import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.usecase.consulta.usuario.ValidarUsuarioRegistradoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ValidarUsuarioApiRest {
    private final ValidarUsuarioRegistradoUseCase validarUsuarioRegistradoUseCase;

    @GetMapping(path = "/validar/usuario/{correo}")
    public RespuestaDTO valirdarUsuario(@PathVariable("correo") String correo){
        RespuestaDTO validar = new RespuestaDTO();
        try{
            Usuario resp = validarUsuarioRegistradoUseCase.validarUsuario(correo);
            System.out.println(resp);
            if (resp==null){
                validar.setResgistrado(false);
                return validar;
            }
            validar.setResgistrado(true);
            return validar;
        }catch (NullPointerException e){
            validar.setResgistrado(false);
            return validar;
        }

    }
}
