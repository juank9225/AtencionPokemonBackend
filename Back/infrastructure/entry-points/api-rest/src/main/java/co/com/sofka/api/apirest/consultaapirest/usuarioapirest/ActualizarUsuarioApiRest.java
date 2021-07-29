package co.com.sofka.api.apirest.consultaapirest.usuarioapirest;

import co.com.sofka.api.dtos.UsuarioDTO;
import co.com.sofka.api.mapper.UsuarioMapper;
import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.usecase.consulta.usuario.ActualizarUsuarioUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ActualizarUsuarioApiRest {
    private final ActualizarUsuarioUseCase actualizarUsuarioUseCase;
    private UsuarioMapper usuarioMapper;

    @PutMapping(path = "/actualizar/usuario")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getId() != null) {
            Usuario usuario = usuarioMapper.fromDTO(usuarioDTO);
            return new ResponseEntity(usuarioMapper.fromModel(actualizarUsuarioUseCase.actualizarUsuario(usuario)), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }
}
