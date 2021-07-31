package co.com.sofka.api.apirest.atencionapirest;

import co.com.sofka.api.dtos.AtencionDTO;
import co.com.sofka.api.mapper.AtencionMapper;
import co.com.sofka.usecase.atencion.ListarAtencionesFechaDoctorUseCase;
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
public class ListarAtencionesDoctorFechaApiRest {
    private final ListarAtencionesFechaDoctorUseCase listarAtencionesFechaDoctorUseCase;
    private AtencionMapper atencionMapper;

    @GetMapping(path = "/listar/atencion/{id}/{fecha}")
    public ResponseEntity<List<AtencionDTO>> listarConsultaId(@PathVariable("id") String id, @PathVariable("fecha") String fecha){
        return new ResponseEntity(atencionMapper.fromCollectionList(listarAtencionesFechaDoctorUseCase.listarAtencionesFechaDoctor(id, fecha)), HttpStatus.OK);
    }
}
