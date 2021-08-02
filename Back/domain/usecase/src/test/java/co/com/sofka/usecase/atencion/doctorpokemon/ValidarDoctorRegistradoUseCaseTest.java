package co.com.sofka.usecase.atencion.doctorpokemon;

import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import co.com.sofka.model.atencion.values.valueobjectdoctor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest(classes = ValidarDoctorRegistradoUseCase.class)
class ValidarDoctorRegistradoUseCaseTest {

    @MockBean
    private DoctorpokemonRepository doctorpokemonRepository;

    @SpyBean
    private ValidarDoctorRegistradoUseCase validarDoctorRegistradoUseCase;

    @Test
    @DisplayName("Happy test validar usuario registrado")
    public void validarDoctorHappyTest(){
        Doctorpokemon doctorpokemon = new Doctorpokemon("xxxx",
                new Identificacion(436557678L),
                new Nombre("Carlos"),
                new Apellido("Fernandez"),
                new Telefono("34567898"),
                new Correo("carlosfernandez@gmail.com"),
                new Especialidad("Pokemones tipo fuego")
        );

        Mockito.when(doctorpokemonRepository.validarDoctor(doctorpokemon.getCorreo().getValor())).thenReturn(doctorpokemon);
        Doctorpokemon resp = validarDoctorRegistradoUseCase.validarDoctor("carlosfernandez@gmail.com");

        Assertions.assertEquals(resp.getId(),"xxxx");
        Assertions.assertEquals(resp.getCorreo().getValor(),"carlosfernandez@gmail.com");
        Assertions.assertEquals(resp.getNombre().getValor(),"Carlos");

    }

    @Test
    @DisplayName("Sad test validar usuario registrado")
    public void validarDoctorSadTest(){
        Doctorpokemon doctorpokemon = new Doctorpokemon("xxxx",
                new Identificacion(436557678L),
                new Nombre("Carlos"),
                new Apellido("Fernandez"),
                new Telefono("34567898"),
                new Correo("carlosfernandez@gmail.com"),
                new Especialidad("Pokemones tipo fuego")
        );

        Mockito.when(doctorpokemonRepository.crearDoctor(doctorpokemon)).thenReturn(doctorpokemon);
        Mockito.when(doctorpokemonRepository.validarDoctor("carlosfernandez@gmail.com")).thenThrow(NullPointerException.class);

        Assertions.assertThrows(NullPointerException.class,()->{
            validarDoctorRegistradoUseCase.validarDoctor("carlosfernandez@gmail.com");
        });
    }
}