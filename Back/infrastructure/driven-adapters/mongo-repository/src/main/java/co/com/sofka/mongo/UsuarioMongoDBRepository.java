package co.com.sofka.mongo;

import co.com.sofka.model.consulta.entity.usuario.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UsuarioMongoDBRepository extends MongoRepository<Usuario, String> , QueryByExampleExecutor<Usuario> {
}
