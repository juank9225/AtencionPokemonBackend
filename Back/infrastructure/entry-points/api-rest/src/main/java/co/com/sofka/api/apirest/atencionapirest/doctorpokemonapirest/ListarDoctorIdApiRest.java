package co.com.sofka.api.apirest.atencionapirest.doctorpokemonapirest;

import co.com.sofka.api.dtos.DoctorDTO;
import co.com.sofka.api.mapper.DoctorMapper;
import co.com.sofka.usecase.atencion.doctorpokemon.ListarDoctorPokemonIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ListarDoctorIdApiRest {
    private final ListarDoctorPokemonIdUseCase listarDoctorPokemonIdUseCase;
    private DoctorMapper doctorMapper;

    @GetMapping(path = "/listar/doctor/{id}")
    public ResponseEntity<DoctorDTO> listarDoctorId(@PathVariable("id") String id){
        return new ResponseEntity(doctorMapper.fromModel(listarDoctorPokemonIdUseCase.obtenerDoctor(id)), HttpStatus.OK);
    }
}
