package co.com.sofka.usecase.consulta.mascota;

import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.model.consulta.entity.mascotapokemon.gateways.MascotaPokemonRepository;
import co.com.sofka.model.consulta.values.valueobjectmascota.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest(classes = CreateMascotaUseCase.class)
class CreateMascotaUseCaseTest {
    @MockBean
    private MascotaPokemonRepository mascotaPokemonRepository;

    @SpyBean
    private CreateMascotaUseCase createMascotaUseCase;

    @Test
    public void testsCrearMascota() {
        MascotaPokemon mascotaPokemon = new MascotaPokemon("xxxx",
                new IdentificacionMascota(1786411L),
                new NombrePokemon("Kali"),
                new Raza("Sandshrew"),
                new Tipo("Tierra"),
                new Habilidad("Velo Arena")
        );
        Mockito.when(mascotaPokemonRepository.crearMascota(mascotaPokemon)).thenReturn(mascotaPokemon);
        MascotaPokemon resp = createMascotaUseCase.crearMascota(mascotaPokemon);

        Assertions.assertEquals(resp.getId(), "xxxx");
        Assertions.assertEquals(resp.getIdentificacionMascota().getValor(),(Long) 1786411L);
        Assertions.assertEquals(resp.getNombrePokemon().getValor(), "Kali");
        Assertions.assertEquals(resp.getRaza().getValor(), "Sandshrew");
        Assertions.assertEquals(resp.getTipo().getValor(), "Tierra");
        Assertions.assertEquals(resp.getHabilidad().getValor(), "Velo Arena");
    }
}
