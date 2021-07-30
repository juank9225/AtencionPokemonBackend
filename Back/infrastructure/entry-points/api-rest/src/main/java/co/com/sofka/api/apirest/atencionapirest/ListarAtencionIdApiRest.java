package co.com.sofka.api.apirest.atencionapirest;

import co.com.sofka.api.dtos.AtencionDTO;
import co.com.sofka.api.mapper.AtencionMapper;
import co.com.sofka.usecase.atencion.ListarAtencionIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarAtencionIdApiRest {
    private final ListarAtencionIdUseCase listarAtencionIdUseCase;
    private AtencionMapper atencionMapper;

    @GetMapping(path = "/listar/atencion/{id}")
    public ResponseEntity<AtencionDTO> listarConsultaId(@PathVariable("id") String id){
        return new ResponseEntity(atencionMapper.fromModel(listarAtencionIdUseCase.obtenerAtencion(id)), HttpStatus.OK);
    }
}
