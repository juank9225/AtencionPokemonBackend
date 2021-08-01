package co.com.sofka.api.apirest.atencionapirest.doctorpokemonapirest;

import co.com.sofka.api.dtos.DoctorDTO;
import co.com.sofka.api.mapper.DoctorMapper;
import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.usecase.atencion.doctorpokemon.ActualizarDoctorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ActualizarDoctorApiRest {
    private final ActualizarDoctorUseCase actualizarDoctorUseCase;
    private DoctorMapper doctorMapper;

    @PutMapping(path = "/actualizar/doctor")
    public ResponseEntity<DoctorDTO> actualizarDoctor(@RequestBody DoctorDTO doctorDTO) {
        if (doctorDTO.getId() != null) {
            Doctorpokemon doctor = doctorMapper.fromDTO(doctorDTO);
            return new ResponseEntity(actualizarDoctorUseCase.actualizarDoctor(doctor), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
