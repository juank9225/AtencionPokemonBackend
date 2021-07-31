package co.com.sofka.api.apirest.consultaapirest;

import co.com.sofka.api.dtos.ConsultaDTO;
import co.com.sofka.api.mapper.ConsultaMapper;
import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.usecase.consulta.CreateConsultaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AgregarConsultaApiRest {
    private final CreateConsultaUseCase createConsultaUseCase;
    private ConsultaMapper consultaMapper;

    @PostMapping(path = "/crear/consulta")
    public ConsultaDTO crearConsulta(@RequestBody ConsultaDTO consultaDTO) {
        Consulta consulta = consultaMapper.fromDTO(consultaDTO);
        return consultaMapper.fromModel(createConsultaUseCase.crearConsulta(consulta));
    }

}
