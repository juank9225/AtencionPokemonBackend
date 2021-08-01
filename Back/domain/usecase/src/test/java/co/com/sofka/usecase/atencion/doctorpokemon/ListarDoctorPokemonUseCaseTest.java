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

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ListarDoctorPokemonUseCase.class)
class ListarDoctorPokemonUseCaseTest {

    @MockBean
    private DoctorpokemonRepository doctorpokemonRepository;

    @SpyBean
    private ListarDoctorPokemonUseCase listarDoctorPokemonUseCase;

    @Test
    @DisplayName("Test Listar Doctores")
    public void ListarDoctores() {

        Doctorpokemon doctor1 = new Doctorpokemon("xxxx",
                new Identificacion(5467678766L),
                new Nombre("Juan"),
                new Apellido("Salcedo"),
                new Telefono("4567651"),
                new Correo("juansalcedo@gamil.com"),
                new Especialidad("pokemones de agua")
        );

        Doctorpokemon doctor2 = new Doctorpokemon("xyzwq",
                new Identificacion(657879890L),
                new Nombre("Andres"),
                new Apellido("Ramirez"),
                new Telefono("45656577"),
                new Correo("andresramirez@gamil.com"),
                new Especialidad("pokemones de fuego")
        );

        List<Doctorpokemon> doctores = new ArrayList<>();
        doctores.add(doctor1);
        doctores.add(doctor2);

        Mockito.when(doctorpokemonRepository.listarDoctores()).thenReturn(doctores);

        List<Doctorpokemon> resp = listarDoctorPokemonUseCase.listarDoctores();
        Assertions.assertEquals(resp.size(), 2);
        Assertions.assertEquals(resp.get(0).getId(), "xxxx");
        Assertions.assertEquals(resp.get(1).getId(), "xyzwq");
    }
}



