package co.com.sofka.usecase.atencion;

import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import co.com.sofka.model.atencion.gateways.AtencionRepository;
import co.com.sofka.model.atencion.values.valueobjectatencion.Diagnostico;
import co.com.sofka.model.atencion.values.valueobjectatencion.FechaDeAtencion;
import co.com.sofka.model.atencion.values.valueobjectdoctor.*;
import co.com.sofka.usecase.atencion.doctorpokemon.ActualizarDoctorUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest(classes = ActualizarAtencionesUseCase.class)
class ActualizarAtencionesUseCaseTest {
    @MockBean
    private AtencionRepository atencionRepository;
    @MockBean
    private DoctorpokemonRepository doctorpokemonRepository;
    @SpyBean
    private ActualizarAtencionesUseCase actualizarAtencionesUseCase;
    @SpyBean
    private ActualizarDoctorUseCase actualizarDoctorUseCase;

    @Test
    @DisplayName("Test actualizar atencion happy test")
    public void crearAtencionHappyTest() {
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

        Mockito.when(doctorpokemonRepository.obtenerDoctor("xxxx")).thenReturn(doctorpokemon);
        Mockito.when(doctorpokemonRepository.actualizarDoctor(doctorpokemon)).thenReturn(doctorpokemon);
        Doctorpokemon res = actualizarDoctorUseCase.actualizarDoctor(doctorpokemon);
        Assertions.assertEquals(res.getId(),"xxxx");
        Assertions.assertEquals(res.getNombre().getValor(),"Carlos");

    }













}



