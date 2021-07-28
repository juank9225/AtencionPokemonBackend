package co.com.sofka.usecase.consulta;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.model.consulta.entity.mascotapokemon.gateways.MascotaPokemonRepository;
import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.model.consulta.entity.usuario.gateways.UsuarioRepository;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateConsultaUseCase {
    private final ConsultaRepository consultaRepository;
    private final UsuarioRepository usuarioRepository;
    private final MascotaPokemonRepository mascotaPokemonRepository;

    public Consulta crearConsulta(Consulta consulta){
        Usuario usuario = usuarioRepository.obtenerUsuario(consulta.getIdUsuario());
        MascotaPokemon mascotaPokemon = mascotaPokemonRepository.obtenerMascota(consulta.getIdMascotaPokemon());
        if (!usuario.getId().isEmpty() && !mascotaPokemon.getId().isEmpty()){
            return consultaRepository.crearConsulta(consulta);
        }
        throw new  IllegalArgumentException("el usuario o la mascota pokemon no existen.");
    }

}
