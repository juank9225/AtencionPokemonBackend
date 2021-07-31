package co.com.sofka.api.apirest.consultaapirest.usuarioapirest;

import co.com.sofka.api.dtos.UsuarioDTO;
import co.com.sofka.api.mapper.UsuarioMapper;
import co.com.sofka.usecase.consulta.usuario.ListarUsuarioUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
