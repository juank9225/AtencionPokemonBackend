package co.com.sofka.mongo;

import co.com.sofka.model.usuario.Usuario;
import co.com.sofka.model.usuario.gateways.UsuarioRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioMongoRepositoryAdapter extends AdapterOperations<Usuario, Usuario, String, UsuarioMongoDBRepository>
implements UsuarioRepository
{

    public UsuarioMongoRepositoryAdapter(UsuarioMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Usuario.class));
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return this.repository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return this.repository.findAll();
    }
}
