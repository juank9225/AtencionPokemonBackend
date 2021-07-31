package co.com.sofka.usecase.consulta;


import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.model.consulta.entity.mascotapokemon.gateways.MascotaPokemonRepository;
import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.model.consulta.entity.usuario.gateways.UsuarioRepository;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import co.com.sofka.model.consulta.values.valueobjectconsulta.CausaEnfermedad;
import co.com.sofka.model.consulta.values.valueobjectconsulta.EstadoRevision;
import co.com.sofka.model.consulta.values.valueobjectconsulta.FechaConsulta;
import co.com.sofka.model.consulta.values.valueobjectconsulta.Sintomas;
import co.com.sofka.model.consulta.values.valueobjectmascota.Habilidad;
import co.com.sofka.model.consulta.values.valueobjectmascota.Raza;
import co.com.sofka.model.consulta.values.valueobjectmascota.Tipo;
import co.com.sofka.model.consulta.values.valueobjectuser.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = CreateConsultaUseCase.class)
class CreateConsultaUseCaseTest {
    @MockBean
    private ConsultaRepository consultaRepository;
    @MockBean
    private UsuarioRepository usuarioRepository;
    @MockBean
    private MascotaPokemonRepository mascotaPokemonRepository;

    @SpyBean
    private CreateConsultaUseCase createConsultaUseCase;

    @Test
    @DisplayName("Test crear consulta happy test")
    public void crearConsultaHappyTest() {
        Usuario usuario = new Usuario("1111",
                new Identificacion(178823411L),
                new Nombre("juan"),
                new Apellido("salcedo"),
                new Telefono("3180987876"),
                new Profesion("Entrenado pokemon"),
                new Correo("juank9223@gamil.com")
        );
        MascotaPokemon mascota = new MascotaPokemon("2222",
                new co.com.sofka.model.consulta.values.valueobjectmascota.Identificacion(178823411L),
                new co.com.sofka.model.consulta.values.valueobjectmascota.Nombre("changuas"),
                new Raza("pikachu"),
                new Tipo("electrico"),
                new Habilidad("lanza rayos"));

    Consulta consulta = new Consulta("3333",
            new FechaConsulta("30-07-201"),
            new CausaEnfermedad("pelea con otro pokemon"),
            new Sintomas("dolor en el cuerpo"),
            new EstadoRevision(false),
            "1111",
            "2222"
    );

        Mockito.when(usuarioRepository.obtenerUsuario(consulta.getIdUsuario())).thenReturn(usuario);
        Mockito.when(mascotaPokemonRepository.obtenerMascota(consulta.getIdMascotaPokemon())).thenReturn(mascota);
        Mockito.when(consultaRepository.crearConsulta(consulta)).thenReturn(consulta);

        Consulta resul = createConsultaUseCase.crearConsulta(consulta);

        assertEquals(resul.getCausaEnfermedad().getValor(),"pelea con otro pokemon");
        assertEquals(resul.getSintomas().getValor(),"dolor en el cuerpo");
    }

    @Test
    @DisplayName("Test crear consulta sab test")
    public void crearConsultaSabTest() {
        Usuario usuario = new Usuario("1111",
                new Identificacion(178823411L),
                new Nombre("juan"),
                new Apellido("salcedo"),
                new Telefono("3180987876"),
                new Profesion("Entrenado pokemon"),
                new Correo("juank9223@gamil.com")
        );
        Consulta consulta = new Consulta("3333",
                new FechaConsulta("30-07-201"),
                new CausaEnfermedad("pelea con otro pokemon"),
                new Sintomas("dolor en el cuerpo"),
                new EstadoRevision(false),
                "1111",
                "2222"
        );

        Mockito.when(usuarioRepository.obtenerUsuario(consulta.getIdUsuario())).thenReturn(usuario);
        Mockito.when(mascotaPokemonRepository.obtenerMascota("2222")).thenReturn(null);
        Mockito.when(consultaRepository.crearConsulta(consulta)).thenReturn(consulta);


        Assertions.assertThrows(NullPointerException.class,()->{
            createConsultaUseCase.crearConsulta(consulta);
        });
    }
}