package co.com.sofka.api.apirest.consultaapirest.mascotaapirest;

import co.com.sofka.api.dtos.MascotaDTO;
import co.com.sofka.api.mapper.MascotaMapper;
import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.usecase.consulta.mascota.ActualizarMascotaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ActualizarMascotaApiRest {
    private final ActualizarMascotaUseCase actualizarMascotaUseCase;
    private MascotaMapper mascotaMapper;

    @PutMapping(path = "/actualizar/mascota")
    public ResponseEntity<MascotaDTO> actualizarMascota(@RequestBody MascotaDTO mascotaDTO) {
        if (mascotaDTO.getId() != null) {
            MascotaPokemon mascotaPokemon = mascotaMapper.fromDTO(mascotaDTO);
            return new ResponseEntity(mascotaMapper.fromModel(actualizarMascotaUseCase.actualizarMascota(mascotaPokemon)), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }
}
