package co.com.sofka.config;

import co.com.sofka.model.atencion.gateways.AtencionRepository;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import co.com.sofka.model.consulta.entity.mascotapokemon.gateways.MascotaPokemonRepository;
import co.com.sofka.model.consulta.entity.usuario.gateways.UsuarioRepository;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import co.com.sofka.usecase.atencion.CreateAtencionUseCase;
import co.com.sofka.usecase.atencion.doctorpokemon.CreateDoctorPokemonUseCase;
import co.com.sofka.usecase.atencion.doctorpokemon.ListarDoctorPokemonUseCase;
import co.com.sofka.usecase.consulta.*;
import co.com.sofka.usecase.consulta.mascota.ActualizarMascotaUseCase;
import co.com.sofka.usecase.consulta.mascota.CreateMascotaUseCase;
import co.com.sofka.usecase.consulta.mascota.ListarMascotaUseCase;
import co.com.sofka.usecase.consulta.usuario.ActualizarUsuarioUseCase;
import co.com.sofka.usecase.consulta.usuario.CreateUsuarioUseCase;
import co.com.sofka.usecase.consulta.usuario.ListarUsuarioIdUseCase;
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

        public CreateConsultaUseCase crearConsulta(ConsultaRepository consultaRepository,UsuarioRepository usuarioRepository,MascotaPokemonRepository mascotaPokemonRepository){
                return new CreateConsultaUseCase(consultaRepository,usuarioRepository,mascotaPokemonRepository);
        }

        public ListarConsultaUseCase listarConsultas(ConsultaRepository consultaRepository){
                return new ListarConsultaUseCase(consultaRepository);
        }

        public CreateDoctorPokemonUseCase crearDoctor(DoctorpokemonRepository doctorpokemonRepository){
                return new CreateDoctorPokemonUseCase(doctorpokemonRepository);
        }

        public CreateAtencionUseCase crearAtencion(AtencionRepository atencionRepository){
                return new CreateAtencionUseCase(atencionRepository);
        }

        public ListarDoctorPokemonUseCase listarDoctores(DoctorpokemonRepository doctorpokemonRepository){
                return new ListarDoctorPokemonUseCase(doctorpokemonRepository);
        }

        public ListarConsultasActivasUseCase listarConsultasActivas(ConsultaRepository consultaRepository){
                return new ListarConsultasActivasUseCase(consultaRepository);
        }

        public ListarConsultasInactivasUseCase listarConsultasInactivasUseCase(ConsultaRepository consultaRepository){
                return new ListarConsultasInactivasUseCase(consultaRepository);
        }

        public ListarUsuarioIdUseCase listarUsuarioId(UsuarioRepository usuarioRepository){
                        return new ListarUsuarioIdUseCase(usuarioRepository);
        }

        public ActualizarUsuarioUseCase actualizarUsuario(UsuarioRepository usuarioRepository){
                return new ActualizarUsuarioUseCase(usuarioRepository);
        }

        public ActualizarConsultaUseCase actualizarConsulta(ConsultaRepository consultaRepository){
                return new ActualizarConsultaUseCase(consultaRepository);
        }

        public ActualizarMascotaUseCase actualizarMascota(MascotaPokemonRepository mascotaPokemonRepository){
                return new ActualizarMascotaUseCase(mascotaPokemonRepository);
        }
}