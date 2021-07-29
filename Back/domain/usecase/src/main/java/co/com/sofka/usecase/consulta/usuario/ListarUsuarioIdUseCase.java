package co.com.sofka.usecase.consulta.usuario;

import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.model.consulta.entity.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListarUsuarioIdUseCase {
    private final UsuarioRepository usuarioRepository;

    public Usuario obtenerUsuario(String id){
        return usuarioRepository.obtenerUsuario(id);
    }
}
