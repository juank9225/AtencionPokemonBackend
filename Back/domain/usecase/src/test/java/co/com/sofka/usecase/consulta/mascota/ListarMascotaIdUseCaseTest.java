package co.com.sofka.usecase.consulta.mascota;

import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.model.consulta.entity.mascotapokemon.gateways.MascotaPokemonRepository;
import co.com.sofka.model.consulta.values.valueobjectmascota.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ListarMascotaIdUseCase.class)
class ListarMascotaIdUseCaseTest {
    @MockBean
    private MascotaPokemonRepository mascotaPokemonRepository;

    @SpyBean
    private ListarMascotaIdUseCase listarMascotaIdUseCase;

    @Test
    @DisplayName("Test obtener Pokemon por Id")
    public void obtenerPokemonPorIdTest(){
        MascotaPokemon pokemon = new MascotaPokemon("xxxx",
                new IdentificacionMascota(1786411L),
                new NombrePokemon("Kali"),
                new Raza("Sandshrew"),
                new Tipo("Tierra"),
                new Habilidad("Velo Arena"));

    Mockito.when(mascotaPokemonRepository.obtenerMascota(pokemon.getId())).thenReturn(pokemon);

    MascotaPokemon resp = listarMascotaIdUseCase.obtenerMascota("xxxx");

    Assertions.assertEquals(resp.getNombrePokemon().getValor(),"Kali");
    Assertions.assertEquals(resp.getRaza().getValor(),"Sandshrew");
    Assertions.assertEquals(resp.getTipo().getValor(),"Tierra");
    }
}