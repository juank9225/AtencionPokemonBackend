package co.com.sofka.api.apirest.atencionapirest;

import co.com.sofka.api.dtos.AtencionDTO;
import co.com.sofka.api.dtos.ConsultaDTO;
import co.com.sofka.api.mapper.AtencionMapper;
import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.usecase.atencion.ActualizarAtencionesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ActualizarAtencionApiRest {
    private final ActualizarAtencionesUseCase actualizarAtencionesUseCase;
    private AtencionMapper atencionMapper;

    @PutMapping(path = "/actualizar/atencion")
    public ResponseEntity<ConsultaDTO> actualizarAtencion(@RequestBody AtencionDTO atencionDTO) {
        if (atencionDTO.getId() != null) {
            Atencion atencion = atencionMapper.fromDTO(atencionDTO);
            return new ResponseEntity(atencionMapper.fromModel(actualizarAtencionesUseCase.actualizarAtencion(atencion)), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }
}
