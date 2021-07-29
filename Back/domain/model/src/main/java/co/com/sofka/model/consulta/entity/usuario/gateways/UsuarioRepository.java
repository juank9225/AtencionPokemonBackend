package co.com.sofka.model.consulta.entity.usuario.gateways;

import co.com.sofka.model.consulta.entity.usuario.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario crearUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Usuario obtenerUsuario(String id);
    Usuario actualizarUsuario(Usuario usuario);
}
