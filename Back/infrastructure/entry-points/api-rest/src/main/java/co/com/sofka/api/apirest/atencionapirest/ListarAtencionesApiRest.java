package co.com.sofka.api.apirest.atencionapirest;

import co.com.sofka.api.dtos.AtencionDTO;
import co.com.sofka.api.mapper.AtencionMapper;
import co.com.sofka.usecase.atencion.ListarAtencionesUseCase;
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
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarAtencionesApiRest {
    private final ListarAtencionesUseCase listarAtencionesUseCase;
    private AtencionMapper atencionMapper;

    @GetMapping(path = "/listar/atenciones")
    public ResponseEntity<List<AtencionDTO>> listarAtenciones(){
        return new ResponseEntity(atencionMapper.fromCollectionList(listarAtencionesUseCase.listarAtenciones()), HttpStatus.OK);
    }
}
