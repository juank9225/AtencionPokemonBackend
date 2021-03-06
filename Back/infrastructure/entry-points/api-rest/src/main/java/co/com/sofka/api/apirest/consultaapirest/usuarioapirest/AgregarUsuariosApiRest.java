package co.com.sofka.api.apirest.consultaapirest.usuarioapirest;

import co.com.sofka.api.dtos.UsuarioDTO;
import co.com.sofka.api.mapper.UsuarioMapper;
import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.usecase.consulta.usuario.CreateUsuarioUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AgregarUsuariosApiRest {
    private final CreateUsuarioUseCase createUsuarioUseCase;
    private UsuarioMapper usuarioMapper;

    @PostMapping(path = "/crear/usuario")
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.fromDTO(usuarioDTO);
        return new  ResponseEntity(usuarioMapper.fromModel(createUsuarioUseCase.crearUsuario(usuario)), HttpStatus.OK);
    }

}
