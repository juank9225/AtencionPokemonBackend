package co.com.sofka.usecase.createusuario;

import co.com.sofka.model.usuario.Usuario;
import co.com.sofka.model.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class CreateUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.crearUsuario(usuario);
    }
}
