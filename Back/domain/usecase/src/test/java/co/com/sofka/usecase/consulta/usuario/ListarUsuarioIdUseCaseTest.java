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

@SpringBootTest(classes = ListarUsuarioIdUseCase.class)
class ListarUsuarioIdUseCaseTest {
    @MockBean
    private UsuarioRepository usuarioRepository;

    @SpyBean
    private ListarUsuarioIdUseCase listarUsuarioIdUseCase;

    @Test
    @DisplayName("Test listar Usuario Id")
    public void ListarUsuarioId(){
        Usuario usuario = new Usuario("xxxxx",
                new Identificacion(344445L),
                new Nombre("Andres"),
                new Apellido("Carvajal"),
                new Telefono("35667879"),
                new Profesion("Maestro pokemon"),
                new Correo("andrescarvajal@gmail.com")
        );

        Mockito.when(usuarioRepository.obtenerUsuario(usuario.getId())).thenReturn(usuario);
        Usuario resp = listarUsuarioIdUseCase.obtenerUsuario("xxxxx");
        Assertions.assertEquals(resp.getId(),"xxxxx");
    }
}