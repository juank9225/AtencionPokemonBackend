package co.com.sofka.mongo.doctorrepository;

import co.com.sofka.model.atencion.entity.doctorpokemon.Doctorpokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

public interface DoctorMongoDBRepository extends MongoRepository<Doctorpokemon, String> , QueryByExampleExecutor<Doctorpokemon> {
    @Transactional(readOnly = true)
    Doctorpokemon findByCorreoValor(String correo);
}
