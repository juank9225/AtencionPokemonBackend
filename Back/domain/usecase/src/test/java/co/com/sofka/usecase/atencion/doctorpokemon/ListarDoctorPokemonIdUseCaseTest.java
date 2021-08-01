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

@SpringBootTest(classes = ListarDoctorPokemonIdUseCase.class)
class ListarDoctorPokemonIdUseCaseTest {
    @MockBean
    private DoctorpokemonRepository doctorpokemonRepository;

    @SpyBean
    private ListarDoctorPokemonIdUseCase listarDoctorPokemonIdUseCase;

    @Test
    @DisplayName("Test Listar Doctor Id")
    public void ListarDoctoresId(){

        Doctorpokemon doctor1 = new Doctorpokemon("xxxx",
                new Identificacion(5467678766L),
                new Nombre("Juan"),
                new Apellido("Salcedo"),
                new Telefono("4567651"),
                new Correo("juansalcedo@gamil.com"),
                new Especialidad("pokemones de agua")
        );

        Mockito.when(doctorpokemonRepository.obtenerDoctor(doctor1.getId())).thenReturn(doctor1);
        Doctorpokemon resp =  listarDoctorPokemonIdUseCase.obtenerDoctor("xxxx");
        Assertions.assertEquals(resp.getId(),"xxxx");
    }
}