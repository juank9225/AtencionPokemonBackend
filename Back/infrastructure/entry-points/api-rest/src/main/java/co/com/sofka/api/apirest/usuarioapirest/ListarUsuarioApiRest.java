package co.com.sofka.api.apirest.usuarioapirest;

import co.com.sofka.api.dtos.UsuarioDTO;
import co.com.sofka.api.mapper.UsuarioMapper;
import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.usecase.usuario.ListarUsuarioUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarUsuarioApiRest {
    private final ListarUsuarioUseCase listarUsuarioUseCase;
    private UsuarioMapper usuarioMapper;

    @GetMapping(path = "/listar/usuarios")
    public List<UsuarioDTO> listarPersona(){
        return usuarioMapper.fromCollectionList(listarUsuarioUseCase.listarUsuarios());
    }
}
