package co.com.sofka.model.usuario.gateways;

import co.com.sofka.model.usuario.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario crearUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
}
