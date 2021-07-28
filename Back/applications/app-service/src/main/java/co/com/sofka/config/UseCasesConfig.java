package co.com.sofka.config;

import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import co.com.sofka.model.consulta.entity.mascotapokemon.gateways.MascotaPokemonRepository;
import co.com.sofka.model.consulta.entity.usuario.gateways.UsuarioRepository;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import co.com.sofka.usecase.atencion.doctorpokemon.CreateDoctorPokemonUseCase;
import co.com.sofka.usecase.consulta.CreateConsultaUseCase;
import co.com.sofka.usecase.consulta.ListarConsultaUseCase;
import co.com.sofka.usecase.consulta.mascota.CreateMascotaUseCase;
import co.com.sofka.usecase.consulta.mascota.ListarMascotaUseCase;
import co.com.sofka.usecase.consulta.usuario.CreateUsuarioUseCase;
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

        public ListarMascotaUseCase listarMascota(MascotaPokemonRepository mascotaPokemonRepository){
                return new ListarMascotaUseCase(mascotaPokemonRepository);
        }

        public CreateConsultaUseCase crearConsulta(ConsultaRepository consultaRepository){
                return new CreateConsultaUseCase(consultaRepository);
        }

        public ListarConsultaUseCase listar(ConsultaRepository consultaRepository){
                return new ListarConsultaUseCase(consultaRepository);
        }

        public CreateDoctorPokemonUseCase creardoctor(DoctorpokemonRepository doctorpokemonRepository){
                return new CreateDoctorPokemonUseCase(doctorpokemonRepository);
        }
}
