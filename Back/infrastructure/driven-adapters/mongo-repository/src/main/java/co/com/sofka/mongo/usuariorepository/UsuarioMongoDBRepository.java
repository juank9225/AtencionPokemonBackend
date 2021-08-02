package co.com.sofka.mongo.usuariorepository;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.entity.usuario.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsuarioMongoDBRepository extends MongoRepository<Usuario, String> , QueryByExampleExecutor<Usuario> {
    @Transactional(readOnly = true)
    Usuario findByCorreoValor(String correo);
}
