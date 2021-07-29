package co.com.sofka.api.apirest.consultaapirest;

import co.com.sofka.api.dtos.ConsultaDTO;
import co.com.sofka.api.mapper.ConsultaMapper;
import co.com.sofka.usecase.consulta.ListarConsultasActivasUseCase;
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
public class ListarConsultasActivasApiRest {
    private final ListarConsultasActivasUseCase listarConsultasActivasUseCase;
    private ConsultaMapper consultaMapper;

    @GetMapping(path = "/listar/consultas/activas/{fecha}")
    public ResponseEntity<List<ConsultaDTO>> listarConsultasActivas(@PathVariable("fecha") String fecha){
        return new ResponseEntity(consultaMapper.fromCollectionList(listarConsultasActivasUseCase.listarConsultasActivas(fecha)), HttpStatus.OK);
    }

}
