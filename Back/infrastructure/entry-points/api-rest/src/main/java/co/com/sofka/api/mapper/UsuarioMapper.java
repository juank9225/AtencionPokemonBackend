package co.com.sofka.api.mapper;

import co.com.sofka.api.dtos.UsuarioDTO;
import co.com.sofka.model.consulta.entity.usuario.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UsuarioMapper {

    public Usuario fromDTO(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setIdentificacion(usuarioDTO.getIdentificacion());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setProfesion(usuarioDTO.getProfesion());
        usuario.setCorreo(usuarioDTO.getCorreo());

        return usuario;
    }

    public UsuarioDTO fromModel(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setIdentificacion(usuario.getIdentificacion());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setApellido(usuario.getApellido());
        usuarioDTO.setTelefono(usuario.getTelefono());
        usuarioDTO.setProfesion(usuario.getProfesion());
        usuarioDTO.setCorreo(usuario.getCorreo());

        return usuarioDTO;
    }

    public List<UsuarioDTO> fromCollectionList(List<Usuario> collection) {
        if (collection == null) {
            return null;

        }
        List<UsuarioDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Usuario usuario = (Usuario) listTracks.next();
            list.add(fromModel(usuario));
        }

        return list;
    }
}
