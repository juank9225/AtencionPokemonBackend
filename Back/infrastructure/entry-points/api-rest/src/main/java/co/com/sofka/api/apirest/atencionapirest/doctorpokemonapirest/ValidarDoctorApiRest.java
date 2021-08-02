package co.com.sofka.api.apirest.atencionapirest.doctorpokemonapirest;

import co.com.sofka.api.dtos.RespuestaDTO;
import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.usecase.atencion.doctorpokemon.ValidarDoctorRegistradoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ValidarDoctorApiRest {
    private final ValidarDoctorRegistradoUseCase validarDoctorRegistradoUseCase;

    @GetMapping(path = "/validar/doctor/{correo}")
    public RespuestaDTO validarDoctor(@PathVariable("correo")String correo){
        RespuestaDTO validar = new RespuestaDTO();
        try{
            Doctorpokemon resp = validarDoctorRegistradoUseCase.validarDoctor(correo);
            System.out.println(resp);
            if (resp==null){
                validar.setResgistrado(false);
                return validar;
            }
            validar.setResgistrado(true);
            return validar;
        }catch (NullPointerException e){
            validar.setResgistrado(false);
            return validar;
        }
    }
}


