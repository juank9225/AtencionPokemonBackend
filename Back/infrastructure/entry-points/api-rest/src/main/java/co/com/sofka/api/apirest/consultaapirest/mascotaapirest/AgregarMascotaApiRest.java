package co.com.sofka.api.apirest.consultaapirest.mascotaapirest;

import co.com.sofka.api.dtos.MascotaDTO;
import co.com.sofka.api.mapper.MascotaMapper;
import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.usecase.consulta.mascota.CreateMascotaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AgregarMascotaApiRest {
    private final CreateMascotaUseCase createMascotaUseCase;
    private MascotaMapper mascotaMapper;

    @PostMapping(path = "/crear/mascota")
    public MascotaDTO crearMascota(@RequestBody MascotaDTO mascotaDTO) {
        MascotaPokemon mascotaPokemon = mascotaMapper.fromDTO(mascotaDTO);
        return mascotaMapper.fromModel(createMascotaUseCase.crearMascota(mascotaPokemon));
    }
}
