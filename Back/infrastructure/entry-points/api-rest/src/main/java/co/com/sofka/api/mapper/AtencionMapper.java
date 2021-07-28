package co.com.sofka.api.mapper;

import co.com.sofka.api.dtos.AtencionDTO;
import co.com.sofka.model.atencion.Atencion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class AtencionMapper {
    public Atencion fromDTO(AtencionDTO atencionDTO){
        Atencion atencion = new Atencion();

        atencion.setId(atencionDTO.getId());
        atencion.setIdConsulta(atencionDTO.getIdConsulta());
        atencion.setIdDoctor(atencionDTO.getIdDoctor());
        atencion.setDiagnostico(atencionDTO.getDiagnostico());
        atencion.setFechaAtencion(atencionDTO.getFechaAtencion());

        return atencion;
    }

    public AtencionDTO fromModel(Atencion atencion){
        AtencionDTO atencionDTO = new AtencionDTO();

        atencionDTO.setId(atencion.getId());
        atencionDTO.setIdConsulta(atencion.getIdConsulta());
        atencionDTO.setIdDoctor(atencion.getIdDoctor());
        atencionDTO.setDiagnostico(atencion.getDiagnostico());
        atencionDTO.setFechaAtencion(atencion.getFechaAtencion());

        return atencionDTO;
    }

    public List<AtencionDTO> fromCollectionList(List<Atencion> collection) {
        if (collection == null) {
            return null;

        }
        List<AtencionDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Atencion atencion = (Atencion) listTracks.next();
            list.add(fromModel(atencion));
        }

        return list;
    }

}
