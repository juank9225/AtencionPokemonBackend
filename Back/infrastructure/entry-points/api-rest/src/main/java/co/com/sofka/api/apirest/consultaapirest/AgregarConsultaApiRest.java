package co.com.sofka.api.apirest.consultaapirest;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.usecase.consulta.CreateConsultaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AgregarConsultaApiRest {
    private final CreateConsultaUseCase createConsultaUseCase;

    @PostMapping(path = "/crear/consulta")
    public Consulta crearConsulta(@RequestBody Consulta consulta) {
        return createConsultaUseCase.crearConsulta(consulta);
    }

}
