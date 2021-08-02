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

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ListarUsuarioUseCaseTest.class)
class ListarUsuarioUseCaseTest {
    @MockBean
    private UsuarioRepository usuarioRepository;

    @SpyBean
    private ListarUsuarioUseCase listarUsuarioUseCase;

    @Test
    @DisplayName("Test Listar Usuarios")
    public void ListarUsuarios() {

        Usuario usuario1 = new Usuario("123456",
                new Identificacion(3435667L),
                new Nombre("Alejandro"),
                new Apellido("Gutierrez"),
                new Telefono("565890"),
                new Profesion("Maestro junior pokemon"),
                new Correo("alejandrogutierrez@gmail.com")
        );

        Usuario usuario2 = new Usuario("123445623456",
                new Identificacion(35677867L),
                new Nombre("Camilo"),
                new Apellido("Perez"),
                new Telefono("566560"),
                new Profesion("Maester pokemon"),
                new Correo("camiloperez@gmail.com")
        );

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        Mockito.when(usuarioRepository.listarUsuarios()).thenReturn(usuarios);

        List<Usuario> resp = listarUsuarioUseCase.listarUsuarios();

        Assertions.assertEquals(resp.size(), 2);
        Assertions.assertEquals(resp.get(0).getId(), "123456");
        Assertions.assertEquals(resp.get(1).getId(), "123445623456");
        Assertions.assertEquals(resp.get(1).getNombre().getValor(), "Camilo");
        Assertions.assertEquals(resp.get(0).getNombre().getValor(), "Alejandro");

    }
}