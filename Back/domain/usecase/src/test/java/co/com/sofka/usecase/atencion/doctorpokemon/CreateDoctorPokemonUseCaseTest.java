package co.com.sofka.usecase.atencion.doctorpokemon;

import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import co.com.sofka.model.atencion.values.valueobjectdoctor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest(classes = CreateDoctorPokemonUseCase.class)
class CreateDoctorPokemonUseCaseTest {
    @MockBean
    private DoctorpokemonRepository doctorpokemonRepository;

    @SpyBean
    private CreateDoctorPokemonUseCase doctorPokemonUseCase;

    @Test
    public void testCrearDoctor() {
        Doctorpokemon doctorpokemon = new Doctorpokemon("xxxx",
                new Identificacion(134354343L),
                new Nombre("Carlos"),
                new Apellido("Sanchez"),
                new Telefono("34556778"),
                new Correo("carlossanchez0714"),
                new Especialidad("pokemon tipo agua")
        );

        Mockito.when(doctorpokemonRepository.crearDoctor(doctorpokemon)).thenReturn(doctorpokemon);
        Doctorpokemon resp = doctorPokemonUseCase.creardoctor(doctorpokemon);

        Assertions.assertEquals(resp.getId(), "xxxx");
        Assertions.assertEquals(resp.getIdentificacion().getValor(), (Long) 134354343L);
        Assertions.assertEquals(resp.getNombre().getValor(), "Carlos");
        Assertions.assertEquals(resp.getApellido().getValor(), "Sanchez");
        Assertions.assertEquals(resp.getTelefono().getValor(), "34556778");
        Assertions.assertEquals(resp.getCorreo().getValor(), "carlossanchez0714");
        Assertions.assertEquals(resp.getEspecialidad().getValor(), "pokemon tipo agua");
    }
}