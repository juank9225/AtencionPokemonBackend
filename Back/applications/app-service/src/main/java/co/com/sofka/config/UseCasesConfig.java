package co.com.sofka.config;

import co.com.sofka.model.atencion.gateways.AtencionRepository;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import co.com.sofka.model.consulta.entity.mascotapokemon.gateways.MascotaPokemonRepository;
import co.com.sofka.model.consulta.entity.usuario.gateways.UsuarioRepository;
import co.com.sofka.model.atencion.entity.doctorpokemon.gateways.DoctorpokemonRepository;
import co.com.sofka.usecase.atencion.*;
import co.com.sofka.usecase.atencion.doctorpokemon.*;
import co.com.sofka.usecase.consulta.*;
import co.com.sofka.usecase.consulta.mascota.ActualizarMascotaUseCase;
import co.com.sofka.usecase.consulta.mascota.CreateMascotaUseCase;
import co.com.sofka.usecase.consulta.mascota.ListarMascotaIdUseCase;
import co.com.sofka.usecase.consulta.mascota.ListarMascotaUseCase;
import co.com.sofka.usecase.consulta.usuario.ActualizarUsuarioUseCase;
import co.com.sofka.usecase.consulta.usuario.CreateUsuarioUseCase;
import co.com.sofka.usecase.consulta.usuario.ListarUsuarioIdUseCase;
import co.com.sofka.usecase.consulta.usuario.ValidarUsuarioRegistradoUseCase;
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

        public CreateAtencionUseCase crearAtencion(AtencionRepository atencionRepository, DoctorpokemonRepository doctorpokemonRepository){
                return new CreateAtencionUseCase(atencionRepository,doctorpokemonRepository);
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

        public ListarConsultaIdUseCase listarConsultaId(ConsultaRepository consultaRepository){
                return new ListarConsultaIdUseCase(consultaRepository);
        }

        public ListarMascotaIdUseCase listarMascotaId(MascotaPokemonRepository mascotaPokemonRepository){
                return new ListarMascotaIdUseCase(mascotaPokemonRepository);
        }

        public ListarDoctorPokemonIdUseCase listarDoctorId(DoctorpokemonRepository doctorpokemonRepository){
                return new ListarDoctorPokemonIdUseCase(doctorpokemonRepository);
        }

        public ListarAtencionesUseCase listaAtenciones(AtencionRepository atencionRepository){
                return new ListarAtencionesUseCase(atencionRepository);
        }

        public ListarAtencionIdUseCase listarAtencionId(AtencionRepository atencionRepository){
                return new ListarAtencionIdUseCase(atencionRepository);
        }

        public ListarAtencionesFechaDoctorUseCase listarAtencionesFechaDoctor(AtencionRepository atencionRepository){
                return new ListarAtencionesFechaDoctorUseCase(atencionRepository);
        }

        public ObtenerAtencionIdDoctorUseCase obtenerAtencionIdDoctor(AtencionRepository atencionRepository){
                return new ObtenerAtencionIdDoctorUseCase(atencionRepository);
        }

        public ObtenerAtencionesXConsultasUseCase obtenerAtencionesXConsultas(AtencionRepository atencionRepository){
                return new ObtenerAtencionesXConsultasUseCase(atencionRepository);
        }

        public  ActualizarAtencionesUseCase actualizarAtenciones(AtencionRepository atencionRepository, ConsultaRepository consultaRepository){
                return new ActualizarAtencionesUseCase(atencionRepository,consultaRepository);
        }

        public ActualizarDoctorUseCase actualizarDoctor(DoctorpokemonRepository doctorpokemonRepository){
                return new ActualizarDoctorUseCase(doctorpokemonRepository);
        }

        public ValidarUsuarioRegistradoUseCase validarUsuarioRegistrado(UsuarioRepository usuarioRepository){
                return new ValidarUsuarioRegistradoUseCase(usuarioRepository);
        }

        public ValidarDoctorRegistradoUseCase validarDoctorRegistradoUseCase(DoctorpokemonRepository doctorpokemonRepository){
                return new ValidarDoctorRegistradoUseCase(doctorpokemonRepository);
        }
}