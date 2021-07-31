package co.com.sofka.api.apirest.consultaapirest.usuarioapirest;

import co.com.sofka.api.dtos.UsuarioDTO;
import co.com.sofka.api.mapper.UsuarioMapper;
import co.com.sofka.usecase.consulta.usuario.ListarUsuarioIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarUsuarioIdApiRest {
    private final ListarUsuarioIdUseCase listarUsuarioIdUseCase;
    private UsuarioMapper usuarioMapper;

    @GetMapping(path = "/listar/usuario/{id}")
    public ResponseEntity<UsuarioDTO> listarUsuarioId(@PathVariable("id") String id){
        return new ResponseEntity(usuarioMapper.fromModel(listarUsuarioIdUseCase.obtenerUsuario(id)), HttpStatus.OK);
    }

}
