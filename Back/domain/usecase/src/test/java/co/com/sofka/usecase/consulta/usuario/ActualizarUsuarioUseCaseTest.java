package co.com.sofka.usecase.consulta.usuario;

import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.model.consulta.entity.usuario.gateways.UsuarioRepository;
import co.com.sofka.model.consulta.values.valueobjectuser.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest(classes = ActualizarUsuarioUseCase.class)
class ActualizarUsuarioUseCaseTest {
    @MockBean
    private UsuarioRepository usuarioRepository;

    @SpyBean
    private ActualizarUsuarioUseCase actualizarUsuarioUseCase;

    @Test
    @DisplayName("Happy test actualizar usuario")
    public void actualizarUsuarioHappy(){
        Usuario usuario = new Usuario("xxxx",
                new Identificacion(178823411L),
                new Nombre("juan"),
                new Apellido("salcedo"),
                new Telefono("3119087766"),
                new Profesion("entrenador pokemon"),
                new Correo("juank000@Gmail.com")
        );

        Mockito.when(usuarioRepository.obtenerUsuario("xxxx")).thenReturn(usuario);
        Mockito.when(usuarioRepository.actualizarUsuario(usuario)).thenReturn(usuario);

        Usuario resp = actualizarUsuarioUseCase.actualizarUsuario(usuario);

        Assertions.assertEquals(resp.getId(),"xxxx");
        Assertions.assertEquals(resp.getNombre().getValor(),"juan");

    }

    @Test
    @DisplayName("Sad test actualizar usuario")
    public void actualizarUsuarioSadTest(){
        Usuario usuario = new Usuario("xxxx",
                new Identificacion(178823411L),
                new Nombre("juan"),
                new Apellido("salcedo"),
                new Telefono("3119087766"),
                new Profesion("entrenador pokemon"),
                new Correo("juank000@Gmail.com")
        );

        Mockito.when(usuarioRepository.obtenerUsuario("yyyy")).thenReturn(usuario);
        Mockito.when(usuarioRepository.actualizarUsuario(usuario)).thenReturn(usuario);

        Assertions.assertThrows(NullPointerException.class,()->{
            actualizarUsuarioUseCase.actualizarUsuario(usuario);
        });

    }

}