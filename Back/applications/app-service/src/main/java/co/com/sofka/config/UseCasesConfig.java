package co.com.sofka.config;

import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import co.com.sofka.model.mascotapokemon.gateways.MascotaPokemonRepository;
import co.com.sofka.model.usuario.gateways.UsuarioRepository;
import co.com.sofka.usecase.createconsulta.CreateConsultaUseCase;
import co.com.sofka.usecase.createmascota.CreateMascotaUseCase;
import co.com.sofka.usecase.createusuario.CreateUsuarioUseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.sofka.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {
        public CreateUsuarioUseCase crear(UsuarioRepository usuarioRepository){
                return new CreateUsuarioUseCase(usuarioRepository);
        }

        public CreateMascotaUseCase crearMascota(MascotaPokemonRepository mascotaPokemonRepository){
                return new CreateMascotaUseCase(mascotaPokemonRepository);
        }

        public CreateConsultaUseCase crearConsulta(ConsultaRepository consultaRepository){
                return new CreateConsultaUseCase(consultaRepository);
        }
}
