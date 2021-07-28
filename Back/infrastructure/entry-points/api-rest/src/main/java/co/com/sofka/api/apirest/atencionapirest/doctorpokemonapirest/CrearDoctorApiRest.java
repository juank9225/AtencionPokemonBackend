package co.com.sofka.api.apirest.atencionapirest.doctorpokemonapirest;

import co.com.sofka.api.dtos.DoctorDTO;
import co.com.sofka.api.mapper.DoctorMapper;
import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.usecase.atencion.doctorpokemon.CreateDoctorPokemonUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CrearDoctorApiRest {
    private final CreateDoctorPokemonUseCase createDoctorPokemonUseCase;
    private DoctorMapper doctorMapper;

    @PostMapping(path = "/crear/doctor")
    public DoctorDTO crearDoctor(@RequestBody DoctorDTO doctorDTO){
        Doctorpokemon doctorpokemon = doctorMapper.fromDTO(doctorDTO);
        return doctorMapper.fromModel(createDoctorPokemonUseCase.creardoctor(doctorpokemon));
    }
}
