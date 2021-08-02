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

@SpringBootTest(classes = ActualizarDoctorUseCase.class)
class ActualizarDoctorUseCaseTest {
    @MockBean
    private DoctorpokemonRepository doctorpokemonRepository;

    @SpyBean
    private ActualizarDoctorUseCase actualizarDoctorUseCase;

    @Test
    @DisplayName("Happy test actualizar doctor")
    public void actualizarDoctorHappyTest() {
        Doctorpokemon doctorpokemon = new Doctorpokemon("xxxxxx",
                new Identificacion(56778898L),
                new Nombre("Carlos"),
                new Apellido("Yepes"),
                new Telefono("356676"),
                new Correo("carlosyepes@gmail.com"),
                new Especialidad("pokemon electricos")
        );

        Mockito.when(doctorpokemonRepository.obtenerDoctor("xxxxxx")).thenReturn(doctorpokemon);
        Mockito.when(doctorpokemonRepository.actualizarDoctor(doctorpokemon)).thenReturn(doctorpokemon);

        Doctorpokemon resp = actualizarDoctorUseCase.actualizarDoctor(doctorpokemon);

        Assertions.assertEquals(resp.getId(), "xxxxxx");
        Assertions.assertEquals(resp.getNombre().getValor(), "Carlos");
    }

    @Test
    @DisplayName("Sad test actualizar doctor")
    public void actualizarDoctorSadTest() {
        Doctorpokemon doctorpokemon = new Doctorpokemon("xxxxxx",
                new Identificacion(56778898L),
                new Nombre("Carlos"),
                new Apellido("Yepes"),
                new Telefono("356676"),
                new Correo("carlosyepes@gmail.com"),
                new Especialidad("pokemon electricos")
        );

        Mockito.when(doctorpokemonRepository.obtenerDoctor("nsdsagf")).thenReturn(doctorpokemon);
        Mockito.when(doctorpokemonRepository.actualizarDoctor(doctorpokemon)).thenReturn(doctorpokemon);

        Assertions.assertThrows(NullPointerException.class, () -> {
            actualizarDoctorUseCase.actualizarDoctor(doctorpokemon);
        });
    }
}