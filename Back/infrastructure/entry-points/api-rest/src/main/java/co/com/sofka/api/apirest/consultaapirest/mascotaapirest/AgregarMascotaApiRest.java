package co.com.sofka.api.apirest.consultaapirest.mascotaapirest;

import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.usecase.consulta.mascota.CreateMascotaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AgregarMascotaApiRest {
    private final CreateMascotaUseCase createMascotaUseCase;

    @PostMapping(path = "/crear/mascota")
    public MascotaPokemon crearMascota(@RequestBody MascotaPokemon mascotaPokemon) {
        return createMascotaUseCase.crearMascota(mascotaPokemon);
    }
}
