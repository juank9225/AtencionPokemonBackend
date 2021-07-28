package co.com.sofka.api.apirest.consultaapirest.mascotaapirest;

import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.usecase.consulta.mascota.ListarMascotaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarMascotaApiRest {
    private final ListarMascotaUseCase listarMascotaUseCase;

    @GetMapping(path = "/listar/pokemones")
    public List<MascotaPokemon> listarPokemones(){
        return listarMascotaUseCase.listarPokemones();
    }
}
