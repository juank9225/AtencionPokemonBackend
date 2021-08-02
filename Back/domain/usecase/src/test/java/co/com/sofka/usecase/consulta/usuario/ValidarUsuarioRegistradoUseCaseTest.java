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

@SpringBootTest(classes = ValidarUsuarioRegistradoUseCase.class)
class ValidarUsuarioRegistradoUseCaseTest {

    @MockBean
    private UsuarioRepository usuarioRepository;

    @SpyBean
    private ValidarUsuarioRegistradoUseCase validarUsuarioRegistradoUseCase;

    @Test
    @DisplayName("Happy test validar creacion de usuario")
    public void validarUsuarioHappyTest(){

        Usuario usuario = new Usuario("xxxx",
                new Identificacion(178823411L),
                new Nombre("juan"),
                new Apellido("salcedo"),
                new Telefono("3119087766"),
                new Profesion("entrenador pokemon"),
                new Correo("juank000@Gmail.com")
        );

        Mockito.when(usuarioRepository.validarUsuario(usuario.getCorreo().getValor())).thenReturn(usuario);

        Usuario resp = validarUsuarioRegistradoUseCase.validarUsuario("juank000@Gmail.com");

        Assertions.assertEquals(resp.getId(),"xxxx");
        Assertions.assertEquals(resp.getCorreo().getValor(),"juank000@Gmail.com");
        Assertions.assertEquals(resp.getNombre().getValor(),"juan");
    }

    @Test
    @DisplayName("Sab test validar creacion de usuario")
    public void validarUsuarioSabTest(){

        Usuario usuario = new Usuario("xxxx",
                new Identificacion(178823411L),
                new Nombre("juan"),
                new Apellido("salcedo"),
                new Telefono("3119087766"),
                new Profesion("entrenador pokemon"),
                new Correo("juank000@Gmail.com")
        );

        Mockito.when(usuarioRepository.crearUsuario(usuario)).thenReturn(usuario);
        Mockito.when(usuarioRepository.validarUsuario("salced@gmail.com")).thenThrow(NullPointerException.class);

        Assertions.assertThrows(NullPointerException.class,()->{
            validarUsuarioRegistradoUseCase.validarUsuario("salced@gmail.com");
        });

    }

}