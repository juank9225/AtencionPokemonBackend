package co.com.sofka.api.apirest.consultaapirest;

import co.com.sofka.api.dtos.ConsultaDTO;
import co.com.sofka.api.mapper.ConsultaMapper;
import co.com.sofka.usecase.consulta.ObtenerConsultaIdUsuarioUseCase;
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
public class ObtenerConsultaIdUsuarioApiRest {
    private final ObtenerConsultaIdUsuarioUseCase obtenerConsultaIdUsuarioUseCase;
    private ConsultaMapper consultaMapper;

    @GetMapping(path = "/listar/consulta/usuario/{idUsuario}")
    public ResponseEntity<List<ConsultaDTO>>obtenerConsultaIdUsuario(@PathVariable("idUsuario") String idUsuario){
        return new ResponseEntity(consultaMapper.fromCollectionList(obtenerConsultaIdUsuarioUseCase.obtenerConsultaIdUsuario(idUsuario)), HttpStatus.OK);
    }
}
