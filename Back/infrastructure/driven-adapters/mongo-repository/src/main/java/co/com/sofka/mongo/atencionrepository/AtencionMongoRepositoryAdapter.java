package co.com.sofka.mongo.atencionrepository;

import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.atencion.gateways.AtencionRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AtencionMongoRepositoryAdapter extends AdapterOperations<Atencion, Atencion, String, AtencionMongoDBRepository>
 implements AtencionRepository
{

    public AtencionMongoRepositoryAdapter(AtencionMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Atencion.class));
    }

    @Override
    public Atencion crearAtencion(Atencion atencion) {
        return this.repository.save(atencion);
    }

    @Override
    public List<Atencion> listarAtenciones() {
        return this.repository.findAll();
    }

    @Override
    public Atencion obtenerAtencion(String id) {
        return this.repository.findById(id).orElseThrow(()-> new IllegalArgumentException("La atencion no fue encontrada"));
    }

    @Override
    public List<Atencion> listarAtencionesFechaDoctor(String idDoctor) {
        return this.repository.findByFechaAtencionValor(idDoctor);
    }
}
