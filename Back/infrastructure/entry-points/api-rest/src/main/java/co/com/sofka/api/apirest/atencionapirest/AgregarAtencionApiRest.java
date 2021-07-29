package co.com.sofka.api.apirest.atencionapirest;

import co.com.sofka.api.dtos.AtencionDTO;
import co.com.sofka.api.mapper.AtencionMapper;
import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.usecase.atencion.CreateAtencionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AgregarAtencionApiRest {
    private final CreateAtencionUseCase createAtencionUseCase;
    private AtencionMapper atencionMapper;

    @PostMapping(path = "/crear/atencion")
    public ResponseEntity<AtencionDTO> crearAtencion(@RequestBody AtencionDTO atencionDTO){
        Atencion atencion = atencionMapper.fromDTO(atencionDTO);
        return new ResponseEntity(atencionMapper.fromModel(createAtencionUseCase.crearatencion(atencion)), HttpStatus.OK);
    }
}
