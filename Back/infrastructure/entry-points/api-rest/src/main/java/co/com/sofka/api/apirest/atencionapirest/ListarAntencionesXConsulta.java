package co.com.sofka.api.apirest.atencionapirest;

import co.com.sofka.api.dtos.AtencionDTO;
import co.com.sofka.api.mapper.AtencionMapper;
import co.com.sofka.usecase.atencion.ObtenerAtencionesXConsultasUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarAntencionesXConsulta {
    private final ObtenerAtencionesXConsultasUseCase obtenerAtencionesXConsultasUseCase;
    private AtencionMapper atencionMapper;

    @GetMapping(path = "/listar/atencion/consulta/{id}")
    public ResponseEntity<List<AtencionDTO>> obtenerAtencionesConsulta(@PathVariable("id") String id){
        return new ResponseEntity(atencionMapper.fromCollectionList(obtenerAtencionesXConsultasUseCase.obtenerAtencionesXConsulta(id)), HttpStatus.OK);
    }
}
