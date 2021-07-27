package co.com.sofka.mongo;

import co.com.sofka.model.consulta.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ConsultaMongoDBRepository extends MongoRepository<Consulta, String> , QueryByExampleExecutor<Consulta> {
}
