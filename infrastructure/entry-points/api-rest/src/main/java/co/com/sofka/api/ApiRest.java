package co.com.sofka.api;
import co.com.sofka.model.mascotapokemon.MascotaPokemon;
import co.com.sofka.model.usuario.Usuario;
import co.com.sofka.usecase.createmascota.CreateMascotaUseCase;
import co.com.sofka.usecase.createusuario.CreateUsuarioUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final CreateUsuarioUseCase createUsuarioUseCase;
    private final CreateMascotaUseCase createMascotaUseCase;

    @PostMapping(path = "/crear/usuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return createUsuarioUseCase.crearUsuario(usuario);
    }

    @GetMapping(path = "/listar/usuarios")
    public List<Usuario> listarPersona(){
        return createUsuarioUseCase.listarUsuarios();
    }

    @PostMapping(path = "/crear/mascota")
    public MascotaPokemon crearMascota(@RequestBody MascotaPokemon mascotaPokemon) {
        return createMascotaUseCase.crearMascota(mascotaPokemon);
    }

}
