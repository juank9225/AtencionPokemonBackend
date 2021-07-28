package co.com.sofka.api.mapper;

import co.com.sofka.api.dtos.ConsultaDTO;
import co.com.sofka.model.consulta.Consulta;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ConsultaMapper {

    public Consulta fromDTO(ConsultaDTO consultaDTO){
        Consulta consulta = new Consulta();
        consulta.setId(consultaDTO.getId());
        consulta.setFechaConsulta(consultaDTO.getFechaConsulta());
        consulta.setCausaEnfermedad(consultaDTO.getCausaEnfermedad());
        consulta.setSintomas(consultaDTO.getSintomas());
        consulta.setEstadoRevision(consultaDTO.getEstadoRevision());
        consulta.setIdUsuario(consultaDTO.getIdUsuario());
        consulta.setIdMascotaPokemon(consultaDTO.getIdMascotaPokemon());

        return consulta;
    }

    public ConsultaDTO fromModel(Consulta consulta){
        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setId(consulta.getId());
        consultaDTO.setFechaConsulta(consulta.getFechaConsulta());
        consultaDTO.setCausaEnfermedad(consulta.getCausaEnfermedad());
        consultaDTO.setSintomas(consulta.getSintomas());
        consultaDTO.setEstadoRevision(consulta.getEstadoRevision());
        consultaDTO.setIdUsuario(consulta.getIdUsuario());
        consultaDTO.setIdMascotaPokemon(consulta.getIdMascotaPokemon());

        return consultaDTO;
    }

    public List<ConsultaDTO> fromCollectionList(List<Consulta> collection) {
        if (collection == null) {
            return null;

        }
        List<ConsultaDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Consulta consulta = (Consulta) listTracks.next();
            list.add(fromModel(consulta));
        }

        return list;
    }
}
