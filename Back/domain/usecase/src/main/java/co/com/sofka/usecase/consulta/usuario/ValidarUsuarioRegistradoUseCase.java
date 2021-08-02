package co.com.sofka.usecase.consulta.usuario;

import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.model.consulta.entity.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidarUsuarioRegistradoUseCase {
    private final UsuarioRepository usuarioRepository;

    public Usuario validarUsuario(String correo){
            return usuarioRepository.validarUsuario(correo);
    }
}
