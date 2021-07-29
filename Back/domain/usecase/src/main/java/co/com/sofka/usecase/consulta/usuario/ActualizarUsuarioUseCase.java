package co.com.sofka.usecase.consulta.usuario;

import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.model.consulta.entity.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ActualizarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public Usuario actualizarUsuario(Usuario usuario){
        Usuario resultado = usuarioRepository.obtenerUsuario(usuario.getId().toString());
        if (!resultado.getId().isEmpty()){
            return usuarioRepository.actualizarUsuario(usuario);
        }
        throw new  IllegalArgumentException("el usuario no existen en la base de datos.");
    }
}
