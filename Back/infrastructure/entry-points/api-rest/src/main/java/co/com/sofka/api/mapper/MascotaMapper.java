package co.com.sofka.api.mapper;

import co.com.sofka.api.dtos.MascotaDTO;
import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MascotaMapper {

    public MascotaPokemon fromDTO(MascotaDTO mascotaDTO){
        MascotaPokemon mascotaPokemon = new MascotaPokemon();
        mascotaPokemon.setId(mascotaDTO.getId());
        mascotaPokemon.setIdentificacion(mascotaDTO.getIdentificacion());
        mascotaPokemon.setNombre(mascotaDTO.getNombre());
        mascotaPokemon.setRaza(mascotaDTO.getRaza());
        mascotaPokemon.setTipo(mascotaDTO.getTipo());
        mascotaPokemon.setHabilidad(mascotaDTO.getHabilidad());

        return mascotaPokemon;
    }

    public MascotaDTO fromModel(MascotaPokemon mascotaPokemon){
        MascotaDTO mascotaDTO = new MascotaDTO();
        mascotaDTO.setId(mascotaPokemon.getId());
        mascotaDTO.setIdentificacion(mascotaPokemon.getIdentificacion());
        mascotaDTO.setNombre(mascotaPokemon.getNombre());
        mascotaDTO.setRaza(mascotaPokemon.getRaza());
        mascotaDTO.setTipo(mascotaPokemon.getTipo());
        mascotaDTO.setHabilidad(mascotaPokemon.getHabilidad());

        return mascotaDTO;
    }

    public List<MascotaDTO> fromCollectionList(List<MascotaPokemon> collection) {
        if (collection == null) {
            return null;

        }
        List<MascotaDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            MascotaPokemon mascotaPokemon = (MascotaPokemon) listTracks.next();
            list.add(fromModel(mascotaPokemon));
        }

        return list;
    }

}
