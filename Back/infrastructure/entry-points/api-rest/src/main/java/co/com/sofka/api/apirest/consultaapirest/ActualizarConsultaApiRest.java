package co.com.sofka.api.apirest.consultaapirest;

import co.com.sofka.api.dtos.ConsultaDTO;
import co.com.sofka.api.mapper.ConsultaMapper;
import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.usecase.consulta.ActualizarConsultaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ActualizarConsultaApiRest {
    private final ActualizarConsultaUseCase actualizarConsultaUseCase;
    private ConsultaMapper consultaMapper;

    @PutMapping(path = "/actualizar/consulta")
    public ResponseEntity<ConsultaDTO> actualizarConsulta(@RequestBody ConsultaDTO consultaDTO) {
        if (consultaDTO.getId() != null) {
            Consulta consulta = consultaMapper.fromDTO(consultaDTO);
            return new ResponseEntity(consultaMapper.fromModel(actualizarConsultaUseCase.actualizarConsulta(consulta)), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }
}
