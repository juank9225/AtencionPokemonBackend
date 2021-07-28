package co.com.sofka.api.apirest.usuarioapirest;

import co.com.sofka.api.dtos.UsuarioDTO;
import co.com.sofka.api.mapper.UsuarioMapper;
import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.usecase.usuario.CreateUsuarioUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AgregarUsuariosApiRest {
    private final CreateUsuarioUseCase createUsuarioUseCase;
    private UsuarioMapper usuarioMapper;

    @PostMapping(path = "/crear/usuario")
    public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.fromDTO(usuarioDTO);
        return usuarioMapper.fromModel(createUsuarioUseCase.crearUsuario(usuario));
    }

}
