package co.com.sofka.mongo.doctorrepository;

import co.com.sofka.model.doctorpokemon.Doctorpokemon;
import co.com.sofka.model.doctorpokemon.gateways.DoctorpokemonRepository;
import co.com.sofka.mongo.doctorrepository.DoctorMongoDBRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

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
    public Doctorpokemon creardoctor(Doctorpokemon doctorpokemon) {
        return this.repository.save(doctorpokemon);
    }
}