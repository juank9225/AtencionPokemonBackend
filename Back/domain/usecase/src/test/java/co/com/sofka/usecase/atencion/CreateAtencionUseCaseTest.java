package co.com.sofka.usecase.atencion;

import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import co.com.sofka.model.atencion.gateways.AtencionRepository;
import co.com.sofka.model.atencion.values.valueobjectatencion.Diagnostico;
import co.com.sofka.model.atencion.values.valueobjectatencion.FechaDeAtencion;
import co.com.sofka.model.atencion.values.valueobjectdoctor.*;
import co.com.sofka.model.consulta.Consulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = CreateAtencionUseCase.class)
class CreateAtencionUseCaseTest {
    @MockBean
    private AtencionRepository atencionRepository;
    @MockBean
    private DoctorpokemonRepository doctorpokemonRepository;

    @SpyBean
    private CreateAtencionUseCase createAtencionUseCase;

    @Test
    @DisplayName("Test crear atencion happy test")
    public void crearAtencionHappyTest() {
        Doctorpokemon doctorpokemon = new Doctorpokemon("xxxx",
                new Identificacion(134354343L),
                new Nombre("Carlos"),
                new Apellido("Sanchez"),
                new Telefono("34556778"),
                new Correo("carlossanchez0714"),
                new Especialidad("pokemon tipo agua")
        );

        Atencion atencion = new Atencion("xxxx",
                "3434545",
                "xxxx",
                new Diagnostico("El pokemón debe llevarse al hospital"),
                new FechaDeAtencion("30-01-2021")
        );

        Mockito.when(doctorpokemonRepository.obtenerDoctor(atencion.getIdDoctor())).thenReturn(doctorpokemon);
        Mockito.when(atencionRepository.crearAtencion(atencion)).thenReturn(atencion);

        Atencion resul = createAtencionUseCase.crearatencion(atencion);

        assertEquals(resul.getFechaAtencion().getValor(), "30-01-2021");
        assertEquals(resul.getDiagnostico().getValor(), "El pokemón debe llevarse al hospital");
    }

    @Test
    @DisplayName("Test crear atencion sad test")
    public void crearAtencionSadTest() {
        Doctorpokemon doctorpokemon = new Doctorpokemon("xxxx",
                new Identificacion(134354343L),
                new Nombre("Carlos"),
                new Apellido("Sanchez"),
                new Telefono("34556778"),
                new Correo("carlossanchez0714"),
                new Especialidad("pokemon tipo agua")
        );

        Atencion atencion = new Atencion("3434545",
                "xxxx",
                new Diagnostico("El pokemón debe llevarse al hospital"),
                new FechaDeAtencion("30-01-2021")
        );

        Mockito.when(doctorpokemonRepository.obtenerDoctor("4567879")).thenReturn(null);
        Mockito.when(atencionRepository.crearAtencion(atencion)).thenReturn(atencion);

        Assertions.assertThrows(NullPointerException.class, () -> {
            createAtencionUseCase.crearatencion(atencion);
        });
    }
}