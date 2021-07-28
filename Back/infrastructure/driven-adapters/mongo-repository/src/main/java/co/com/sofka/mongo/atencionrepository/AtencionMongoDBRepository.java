package co.com.sofka.mongo.atencionrepository;

import co.com.sofka.model.atencion.Atencion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface AtencionMongoDBRepository extends MongoRepository<Atencion, String> , QueryByExampleExecutor<Atencion> {

}
