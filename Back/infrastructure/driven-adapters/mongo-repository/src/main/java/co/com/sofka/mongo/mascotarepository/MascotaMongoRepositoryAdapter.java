package co.com.sofka.mongo.mascotarepository;

import co.com.sofka.model.consulta.entity.mascotapokemon.MascotaPokemon;
import co.com.sofka.model.consulta.entity.mascotapokemon.gateways.MascotaPokemonRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MascotaMongoRepositoryAdapter extends AdapterOperations<MascotaPokemon, MascotaPokemon, String, MascotaMongoDBRepository>
implements MascotaPokemonRepository
{

    public MascotaMongoRepositoryAdapter(MascotaMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, MascotaPokemon.class));
    }

    @Override
    public MascotaPokemon crearMascota(MascotaPokemon mascotaPokemon) {
        return this.repository.save(mascotaPokemon);
    }

    @Override
    public List<MascotaPokemon> listarPokemones() {
        return this.repository.findAll();
    }

    @Override
    public MascotaPokemon obtenerMascota(String id) {
        return this.repository.findById(id).orElseThrow(()->{throw new IllegalArgumentException("no se encontro la mascota."); });
    }
}
