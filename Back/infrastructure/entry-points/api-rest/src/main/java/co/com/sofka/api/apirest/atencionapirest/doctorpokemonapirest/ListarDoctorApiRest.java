package co.com.sofka.api.apirest.atencionapirest.doctorpokemonapirest;

import co.com.sofka.api.dtos.DoctorDTO;
import co.com.sofka.api.mapper.DoctorMapper;
import co.com.sofka.usecase.atencion.doctorpokemon.ListarDoctorPokemonUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarDoctorApiRest {
    private final ListarDoctorPokemonUseCase listarDoctorPokemonUseCase;
    private DoctorMapper doctorMapper;

    @GetMapping(path = "/listar/doctores")
    public List<DoctorDTO> listarDoctores(){
        return doctorMapper.fromCollectionList(listarDoctorPokemonUseCase.listarDoctores());

    }
}
