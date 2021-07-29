package co.com.sofka.api.apirest.consultaapirest.mascotaapirest;

import co.com.sofka.api.dtos.MascotaDTO;
import co.com.sofka.api.mapper.MascotaMapper;
import co.com.sofka.usecase.consulta.mascota.ListarMascotaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarMascotaApiRest {
    private final ListarMascotaUseCase listarMascotaUseCase;
    private MascotaMapper mascotaMapper;

    @GetMapping(path = "/listar/pokemones")
    public ResponseEntity<List<MascotaDTO>> listarPokemones(){
        return new ResponseEntity(mascotaMapper.fromCollectionList(listarMascotaUseCase.listarPokemones()), HttpStatus.OK);
    }
}
