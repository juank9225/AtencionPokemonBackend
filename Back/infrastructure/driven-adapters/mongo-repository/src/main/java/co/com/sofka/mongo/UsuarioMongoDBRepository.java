package co.com.sofka.mongo;

import co.com.sofka.model.usuario.Usuario;
import co.com.sofka.model.usuario.valueobjectuser.Identificacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UsuarioMongoDBRepository extends MongoRepository<Usuario, String> , QueryByExampleExecutor<Usuario> {
}
