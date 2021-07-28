package co.com.sofka.api.mapper;

import co.com.sofka.api.dtos.DoctorDTO;
import co.com.sofka.api.dtos.UsuarioDTO;
import co.com.sofka.model.consulta.entity.usuario.Usuario;
import co.com.sofka.model.doctorpokemon.Doctorpokemon;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class DoctorMapper {
    public Doctorpokemon fromDTO(DoctorDTO doctorDTO){
        Doctorpokemon doctorpokemon = new Doctorpokemon();
        doctorpokemon.setId(doctorDTO.getId());
        doctorpokemon.setIdentificacion(doctorDTO.getIdentificacion());
        doctorpokemon.setNombre(doctorDTO.getNombre());
        doctorpokemon.setApellido(doctorDTO.getApellido());
        doctorpokemon.setTelefono(doctorDTO.getTelefono());
        doctorpokemon.setCorreo(doctorDTO.getCorreo());
        doctorpokemon.setEspecialidad(doctorDTO.getEspecialidad());

        return doctorpokemon;
    }

    public DoctorDTO fromModel(Doctorpokemon doctorpokemon){
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctorpokemon.getId());
        doctorDTO.setIdentificacion(doctorpokemon.getIdentificacion());
        doctorDTO.setNombre(doctorpokemon.getNombre());
        doctorDTO.setApellido(doctorpokemon.getApellido());
        doctorDTO.setTelefono(doctorpokemon.getTelefono());
        doctorDTO.setCorreo(doctorpokemon.getCorreo());
        doctorDTO.setEspecialidad(doctorpokemon.getEspecialidad());
        return doctorDTO;
    }

    public List<DoctorDTO> fromCollectionList(List<Doctorpokemon> collection) {
        if (collection == null) {
            return null;

        }
        List<DoctorDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Doctorpokemon doctorpokemon = (Doctorpokemon) listTracks.next();
            list.add(fromModel(doctorpokemon));
        }

        return list;
    }


}
