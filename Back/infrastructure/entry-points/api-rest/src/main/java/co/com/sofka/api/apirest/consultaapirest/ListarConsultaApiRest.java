package co.com.sofka.api.apirest.consultaapirest;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.usecase.consulta.ListarConsultaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarConsultaApiRest {
    private final ListarConsultaUseCase listarConsultaUseCase;

    @GetMapping(path = "/listar/consultas")
    public List<Consulta> listarConsultas(){
        return listarConsultaUseCase.listarConsultas();
    }
}
