package co.com.sofka.api.apirest.consultaapirest;

import co.com.sofka.api.dtos.ConsultaDTO;
import co.com.sofka.api.mapper.ConsultaMapper;
import co.com.sofka.usecase.consulta.ListarConsultaIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarConsultaIdApiRest {
    private final ListarConsultaIdUseCase listarConsultaIdUseCase;
    private ConsultaMapper consultaMapper;

    @GetMapping(path = "/listar/consulta/{id}")
    public ResponseEntity<ConsultaDTO> listarConsultaId(@PathVariable("id") String id){
        return new ResponseEntity(consultaMapper.fromModel(listarConsultaIdUseCase.obtenerConsulta(id)), HttpStatus.OK);
    }
}
