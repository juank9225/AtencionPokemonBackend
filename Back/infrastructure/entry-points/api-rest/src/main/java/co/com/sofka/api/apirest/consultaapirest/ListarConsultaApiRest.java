package co.com.sofka.api.apirest.consultaapirest;


import co.com.sofka.api.dtos.ConsultaDTO;
import co.com.sofka.api.mapper.ConsultaMapper;
import co.com.sofka.usecase.consulta.ListarConsultaUseCase;
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
public class ListarConsultaApiRest {
    private final ListarConsultaUseCase listarConsultaUseCase;
    private ConsultaMapper consultaMapper;

    @GetMapping(path = "/listar/consultas")
    public ResponseEntity<List<ConsultaDTO>> listarConsultas(){
        return new ResponseEntity(consultaMapper.fromCollectionList(listarConsultaUseCase.listarConsultas()), HttpStatus.OK);
    }
}
