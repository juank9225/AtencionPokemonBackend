package co.com.sofka.usecase.atencion;

import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.atencion.gateways.AtencionRepository;
import co.com.sofka.model.atencion.values.valueobjectatencion.Diagnostico;
import co.com.sofka.model.atencion.values.valueobjectatencion.FechaDeAtencion;
import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import co.com.sofka.model.consulta.values.valueobjectconsulta.CausaEnfermedad;
import co.com.sofka.model.consulta.values.valueobjectconsulta.EstadoRevision;
import co.com.sofka.model.consulta.values.valueobjectconsulta.FechaConsulta;
import co.com.sofka.model.consulta.values.valueobjectconsulta.Sintomas;
import co.com.sofka.usecase.consulta.ActualizarConsultaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest(classes = ActualizarAtencionesUseCase.class)
class ActualizarAtencionesUseCaseTest {
    @MockBean
    private AtencionRepository atencionRepository;
    @MockBean
    private ConsultaRepository consultaRepository;

    @SpyBean
    private ActualizarAtencionesUseCase actualizarAtencionesUseCase;

    @Test
    @DisplayName("Test actualizar atencion happy test")
    public void crearAtencionHappyTest() {
        Atencion atencion = new Atencion("xxxxx",
                "3434545",
                "xxxx",
                new Diagnostico("El pokemón debe llevarse al hospital"),
                new FechaDeAtencion("30-01-2021")
        );
        Consulta consulta = new Consulta("3434545",
                new FechaConsulta("30-07-201"),
                new CausaEnfermedad("pelea con otro pokemon"),
                new Sintomas("dolor en el cuerpo"),
                new EstadoRevision(false),
                "1111",
                "2222"
        );

        Mockito.when(atencionRepository.obtenerAtencion(atencion.getId())).thenReturn(atencion);
        Mockito.when(consultaRepository.obtenerConsulta(atencion.getIdConsulta())).thenReturn(consulta);
        Mockito.when(consultaRepository.actualizarConsulta(consulta)).thenReturn(consulta);
        Mockito.when(atencionRepository.actualizarAtencion(atencion)).thenReturn(atencion);

        Atencion resp = actualizarAtencionesUseCase.actualizarAtencion(atencion);

        Assertions.assertEquals(resp.getId(),"xxxxx");
        Assertions.assertEquals(resp.getDiagnostico().getValor(),"El pokemón debe llevarse al hospital");
    }
}



