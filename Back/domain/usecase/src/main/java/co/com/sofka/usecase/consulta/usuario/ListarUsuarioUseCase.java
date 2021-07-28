package co.com.sofka.usecase.consulta.usuario;

import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.model.consulta.entity.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.listarUsuarios();
    }

}
