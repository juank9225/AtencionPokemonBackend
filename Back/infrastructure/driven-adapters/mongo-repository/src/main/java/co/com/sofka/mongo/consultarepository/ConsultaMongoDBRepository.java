package co.com.sofka.mongo.consultarepository;

import co.com.sofka.model.consulta.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ConsultaMongoDBRepository extends MongoRepository<Consulta, String> , QueryByExampleExecutor<Consulta> {
    @Transactional(readOnly = true)
    List<Consulta> findByFechaConsultaValor(String fecha);
}
