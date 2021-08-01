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
import co.com.sofka.model.consulta.values.valueobjectmascota.*;
import co.com.sofka.model.consulta.values.valueobjectuser.*;
import co.com.sofka.usecase.consulta.mascota.ActualizarMascotaUseCase;
import co.com.sofka.usecase.consulta.usuario.ActualizarUsuarioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest(classes = ActualizarConsultaUseCase.class)
class ActualizarConsultaUseCaseTest {
    @MockBean
    private ConsultaRepository consultaRepository;
    @MockBean
    private UsuarioRepository usuarioRepository;
    @MockBean
    private MascotaPokemonRepository mascotaPokemonRepository;
    @SpyBean
    private ActualizarConsultaUseCase actualizarConsultaUseCase;
    @SpyBean
    private ActualizarMascotaUseCase actualizarMascotaUseCase;
    @SpyBean
    private ActualizarUsuarioUseCase actualizarUsuarioUseCase;

    @Test
    @DisplayName("Test actualizar consulta happy test")
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
                new IdentificacionMascota(178823411L),
                new NombrePokemon("changuas"),
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
        Mockito.when(usuarioRepository.obtenerUsuario("1111")).thenReturn(usuario);
        Mockito.when(usuarioRepository.actualizarUsuario(usuario)).thenReturn(usuario);
        Usuario res = actualizarUsuarioUseCase.actualizarUsuario(usuario);
        Assertions.assertEquals(res.getId(),"1111");
        Assertions.assertEquals(res.getNombre().getValor(),"juan");

        Mockito.when(mascotaPokemonRepository.obtenerMascota("2222")).thenReturn(mascota);
        Mockito.when(mascotaPokemonRepository.actualizarMascota(mascota)).thenReturn(mascota);
        MascotaPokemon resp = actualizarMascotaUseCase.actualizarMascota(mascota);
        Assertions.assertEquals(resp.getId(),"2222");
        Assertions.assertEquals(resp.getNombrePokemon().getValor(),"changuas");

        Mockito.when(consultaRepository.obtenerConsulta("3333")).thenReturn(consulta);
        Mockito.when(consultaRepository.actualizarConsulta(consulta)).thenReturn(consulta);
        Consulta resp1 = actualizarConsultaUseCase.actualizarConsulta(consulta);
        Assertions.assertEquals(resp1.getId(),"3333");
        Assertions.assertEquals(resp1.getCausaEnfermedad().getValor(),"pelea con otro pokemon");

    }

    @Test
    @DisplayName("Test actualizar consulta sad test")
    public void crearConsultaSadTest() {
        Usuario usuario = new Usuario("1111",
                new Identificacion(178823411L),
                new Nombre("juan"),
                new Apellido("salcedo"),
                new Telefono("3180987876"),
                new Profesion("Entrenado pokemon"),
                new Correo("juank9223@gamil.com")
        );
        MascotaPokemon mascota = new MascotaPokemon("2222",
                new IdentificacionMascota(178823411L),
                new NombrePokemon("changuas"),
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
        Mockito.when(usuarioRepository.obtenerUsuario("11111")).thenReturn(usuario);
        Mockito.when(usuarioRepository.actualizarUsuario(usuario)).thenReturn(usuario);

        Assertions.assertThrows(NullPointerException.class,()->{
            actualizarUsuarioUseCase.actualizarUsuario(usuario);
        });

        Mockito.when(mascotaPokemonRepository.obtenerMascota("22222")).thenReturn(mascota);
        Mockito.when(mascotaPokemonRepository.actualizarMascota(mascota)).thenReturn(mascota);

        Assertions.assertThrows(NullPointerException.class,()->{
            actualizarMascotaUseCase.actualizarMascota(mascota);
        });

        Mockito.when(consultaRepository.obtenerConsulta("33333")).thenReturn(consulta);
        Mockito.when(consultaRepository.actualizarConsulta(consulta)).thenReturn(consulta);

        Assertions.assertThrows(NullPointerException.class,()->{
            actualizarConsultaUseCase.actualizarConsulta(consulta);
        });
    }
}