package co.com.sofka.api.apirest.consultaapirest.mascotaapirest;

import co.com.sofka.api.dtos.MascotaDTO;
import co.com.sofka.api.mapper.MascotaMapper;
import co.com.sofka.usecase.consulta.mascota.ListarMascotaIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarMascotaIdApiRest {
    private final ListarMascotaIdUseCase listarMascotaIdUseCase;
    private MascotaMapper mascotaMapper;

    @GetMapping(path = "/listar/mascota/{id}")
    public ResponseEntity<MascotaDTO> listarMascotaId(@PathVariable("id") String id){
        return new ResponseEntity(mascotaMapper.fromModel(listarMascotaIdUseCase.obtenerMascota(id)), HttpStatus.OK);
    }
}
