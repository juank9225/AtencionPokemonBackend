package co.com.sofka.mongo.doctorrepository;

import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorMongoRepositoryAdapter extends AdapterOperations<Doctorpokemon,Doctorpokemon, String, DoctorMongoDBRepository>
implements DoctorpokemonRepository
{

    public DoctorMongoRepositoryAdapter(DoctorMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d,Doctorpokemon.class));
    }

    @Override
    public Doctorpokemon crearDoctor(Doctorpokemon doctorpokemon) {
        return this.repository.save(doctorpokemon);
    }

    @Override
    public List<Doctorpokemon> listarDoctores() {
        return this.repository.findAll();
    }

    @Override
    public Doctorpokemon obtenerDoctor(String id) {
        return this.repository.findById(id).orElseThrow(()->new IllegalArgumentException("no se encontro el doctor."));
    }

    @Override
    public Doctorpokemon actualizarDoctor(Doctorpokemon doctorpokemon) {
        return this.repository.save(doctorpokemon);
    }

    @Override
    public Doctorpokemon validarDoctor(String correo) {
        return this.repository.findByCorreoValor(correo);
    }
}
