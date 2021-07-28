package co.com.sofka.mongo.mascotarepository;

import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface MascotaMongoDBRepository extends MongoRepository<MascotaPokemon, String> , QueryByExampleExecutor<MascotaPokemon> {
}
