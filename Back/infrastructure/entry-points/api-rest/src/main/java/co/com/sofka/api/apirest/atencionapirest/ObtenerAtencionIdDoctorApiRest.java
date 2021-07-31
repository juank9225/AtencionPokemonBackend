package co.com.sofka.api.apirest.atencionapirest;

import co.com.sofka.api.dtos.AtencionDTO;
import co.com.sofka.api.mapper.AtencionMapper;
import co.com.sofka.usecase.atencion.ObtenerAtencionIdDoctorUseCase;
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

public class ObtenerAtencionIdDoctorApiRest {
    private final ObtenerAtencionIdDoctorUseCase obtenerAtencionIdDoctorUseCase;
    private AtencionMapper atencionMapper;

    @GetMapping(path = "/listar/atencion/doctor/{idDoctor}")
    public ResponseEntity<List<AtencionDTO>>obtenerAtencionIdDoctor(@PathVariable("idDoctor") String idDoctor){
        return new ResponseEntity(atencionMapper.fromCollectionList(obtenerAtencionIdDoctorUseCase.obtenerAtencionIdDoctor(idDoctor)), HttpStatus.OK);
    }
}
