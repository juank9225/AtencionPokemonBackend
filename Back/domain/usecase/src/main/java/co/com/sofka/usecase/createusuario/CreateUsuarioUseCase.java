package co.com.sofka.usecase.createusuario;

import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.model.consulta.entity.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CreateUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.crearUsuario(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.listarUsuarios();
    }
}
