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

@SpringBootTest(classes = CreateUsuarioUseCase.class)
class CreateUsuarioUseCaseTest {
    @MockBean
    private UsuarioRepository usuarioRepository;

    @SpyBean
    private CreateUsuarioUseCase createUsuarioUseCase;

    @Test
    @DisplayName("Test crear usuario")
    public void testsCrearUsuario(){

        Usuario usuario = new Usuario("xxxx",
                new Identificacion(178823411L),
                new Nombre("juan"),
                new Apellido("salcedo"),
                new Telefono("3119087766"),
                new Profesion("entrenador pokemon"),
                new Correo("juank000@Gmail.com")
        );

        Mockito.when(usuarioRepository.crearUsuario(usuario)).thenReturn(usuario);
        Usuario resp = createUsuarioUseCase.crearUsuario(usuario);

        Assertions.assertEquals(resp.getId(),"xxxx");
        Assertions.assertEquals(resp.getNombre().getValor(),"juan");
        Assertions.assertEquals(resp.getApellido().getValor(),"salcedo");
        Assertions.assertEquals(resp.getTelefono().getValor(),"3119087766");
        Assertions.assertEquals(resp.getProfesion().getValor(),"entrenador pokemon");
        Assertions.assertEquals(resp.getCorreo().getValor(),"juank000@Gmail.com");
    }
}