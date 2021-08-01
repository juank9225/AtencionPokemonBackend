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
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ListarMascotaUseCase.class)
class ListarMascotaUseCaseTest {
    @MockBean
    private MascotaPokemonRepository mascotaPokemonRepository;

    @SpyBean
    private ListarMascotaUseCase listarMascotaUseCase;

    @Test
    @DisplayName("Test Listar Pokemones")
    public void ListarPokemon(){

        MascotaPokemon pokemon1 = new MascotaPokemon("xxxx",
                new IdentificacionMascota(1786411L),
                new NombrePokemon("Kali"),
                new Raza("Sandshrew"),
                new Tipo("Tierra"),
                new Habilidad("Velo Arena"));

        MascotaPokemon pokemon2 = new MascotaPokemon("yyyy",
                new IdentificacionMascota(1786411L),
                new NombrePokemon("changuas"),
                new Raza("pikachu"),
                new Tipo("electrico"),
                new Habilidad("lanza rayos"));

        List<MascotaPokemon> pokemones = new ArrayList<>();
        pokemones.add(pokemon1);
        pokemones.add(pokemon2);

        Mockito.when(mascotaPokemonRepository.listarPokemones()).thenReturn(pokemones);

        List<MascotaPokemon> resp = listarMascotaUseCase.listarPokemones();

        Assertions.assertEquals(resp.size(),2);
        Assertions.assertEquals(resp.get(0).getId(),"xxxx");
        Assertions.assertEquals(resp.get(1).getId(),"yyyy");
        Assertions.assertEquals(resp.get(1).getNombrePokemon().getValor(),"changuas");
        Assertions.assertEquals(resp.get(0).getNombrePokemon().getValor(),"Kali");

    }

}