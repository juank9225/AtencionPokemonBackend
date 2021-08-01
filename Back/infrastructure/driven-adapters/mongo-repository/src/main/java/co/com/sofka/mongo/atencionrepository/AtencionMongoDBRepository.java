package co.com.sofka.mongo.atencionrepository;

import co.com.sofka.model.atencion.Atencion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AtencionMongoDBRepository extends MongoRepository<Atencion, String> , QueryByExampleExecutor<Atencion> {
    @Transactional(readOnly = true)
    List<Atencion> findByFechaAtencionValor(String idDoctor);
    List<Atencion> findByIdDoctor(String idDoctor);
    List<Atencion> findByidConsulta(String id);
}
