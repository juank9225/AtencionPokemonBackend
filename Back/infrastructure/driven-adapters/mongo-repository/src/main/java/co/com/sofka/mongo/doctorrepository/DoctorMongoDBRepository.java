package co.com.sofka.mongo.doctorrepository;

import co.com.sofka.model.doctorpokemon.Doctorpokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface DoctorMongoDBRepository extends MongoRepository<Doctorpokemon, String> , QueryByExampleExecutor<Doctorpokemon> {
}
