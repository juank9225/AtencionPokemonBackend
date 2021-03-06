package co.com.sofka.mongo.consultarepository;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsultaMongoRepositoryAdapter extends AdapterOperations<Consulta,Consulta, String, ConsultaMongoDBRepository>
 implements ConsultaRepository
{

    public ConsultaMongoRepositoryAdapter(ConsultaMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Consulta.class));
    }

    @Override
    public Consulta crearConsulta(Consulta consulta) {
        return this.repository.save(consulta);
    }

    @Override
    public List<Consulta> listarConsultas() {
        return this.repository.findAll();
    }

    @Override
    public List<Consulta> listarConsultasActivas(String fecha) {
        return this.repository.findByFechaConsultaValor(fecha);
    }

    @Override
    public List<Consulta> listarConsultasInactivas(String fecha){
        return this.repository.findByFechaConsultaValor(fecha);
    }

    @Override
    public Consulta actualizarConsulta(Consulta consulta) {
        return this.repository.save(consulta);
    }

    @Override
    public Consulta obtenerConsulta(String id) {
        return this.repository.findById(id).orElseThrow(()->new IllegalArgumentException("no se encontro la consulta."));
    }

    @Override
    public List<Consulta> obtenerConsultaIdUsuario(String idUsuario){
        return this.repository.findByIdUsuario(idUsuario);
    }
}
