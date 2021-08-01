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

@SpringBootTest(classes = ActualizarMascotaUseCase.class)
class ActualizarMascotaUseCaseTest {
    @MockBean
    private MascotaPokemonRepository mascotaPokemonRepository;

    @SpyBean
    private ActualizarMascotaUseCase actualizarMascotaUseCase;

    @Test
    @DisplayName("Happy test actualizar mascota")
    public void actualizarMascotaHappyTest(){
        MascotaPokemon mascotaPokemon = new MascotaPokemon("sdadbad",
                new IdentificacionMascota(234566L),
                new NombrePokemon("Lexion"),
                new Raza("Charmander"),
                new Tipo("Tipo fuego"),
                new Habilidad("Bolas de fuego")
        );

        Mockito.when(mascotaPokemonRepository.obtenerMascota("sdadbad")).thenReturn(mascotaPokemon);
        Mockito.when(mascotaPokemonRepository.actualizarMascota(mascotaPokemon)).thenReturn(mascotaPokemon);

        MascotaPokemon resp = actualizarMascotaUseCase.actualizarMascota(mascotaPokemon);

        Assertions.assertEquals(resp.getId(),"sdadbad");
        Assertions.assertEquals(resp.getNombrePokemon().getValor(),"Lexion");
    }

    @Test
    @DisplayName("Sad test actualizar mascota")
    public void actualizarMascotaSadTest(){
        MascotaPokemon mascotaPokemon = new MascotaPokemon("sdadbad",
                new IdentificacionMascota(234566L),
                new NombrePokemon("Lexion"),
                new Raza("Charmander"),
                new Tipo("Tipo fuego"),
                new Habilidad("Bolas de fuego")
        );

        Mockito.when(mascotaPokemonRepository.obtenerMascota("sweryu1232")).thenReturn(mascotaPokemon);
        Mockito.when(mascotaPokemonRepository.actualizarMascota(mascotaPokemon)).thenReturn(mascotaPokemon);

        Assertions.assertThrows(NullPointerException.class,()->{
           actualizarMascotaUseCase.actualizarMascota(mascotaPokemon);
        });
    }
}