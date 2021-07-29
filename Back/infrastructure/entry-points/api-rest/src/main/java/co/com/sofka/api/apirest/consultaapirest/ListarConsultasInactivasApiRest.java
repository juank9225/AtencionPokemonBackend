package co.com.sofka.api.apirest.consultaapirest;

import co.com.sofka.api.dtos.ConsultaDTO;
import co.com.sofka.api.mapper.ConsultaMapper;
import co.com.sofka.usecase.consulta.ListarConsultasInactivasUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarConsultasInactivasApiRest {
    private final ListarConsultasInactivasUseCase listarConsultasInactivasUseCase;
    private ConsultaMapper consultaMapper;

    @GetMapping(path = "/listar/consultas/inactivas/{fecha}")
    public ResponseEntity<List<ConsultaDTO>> listarConsultasInactivas(@PathVariable("fecha") String fecha) {
        return new ResponseEntity(consultaMapper.fromCollectionList(listarConsultasInactivasUseCase.listarConsultasInactivas(fecha)), HttpStatus.OK);
    }
}
