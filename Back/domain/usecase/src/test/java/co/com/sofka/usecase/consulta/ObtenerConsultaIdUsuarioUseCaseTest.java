package co.com.sofka.usecase.consulta;

import co.com.sofka.model.consulta.Consulta;
import co.com.sofka.model.consulta.gateways.ConsultaRepository;
import co.com.sofka.model.consulta.values.valueobjectconsulta.CausaEnfermedad;
import co.com.sofka.model.consulta.values.valueobjectconsulta.EstadoRevision;
import co.com.sofka.model.consulta.values.valueobjectconsulta.FechaConsulta;
import co.com.sofka.model.consulta.values.valueobjectconsulta.Sintomas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = ObtenerConsultaIdUsuarioUseCase.class)
class ObtenerConsultaIdUsuarioUseCaseTest {

    @MockBean
    private ConsultaRepository consultaRepository;

    @SpyBean
    private ObtenerConsultaIdUsuarioUseCase obtenerConsultaIdUsuarioUseCase;


    @Test
    @DisplayName("Test obtener consulta por id de usuario")
    public void obtenerConsultaPorIdUsuarioTest(){

        Consulta consulta = new Consulta("3333",
                new FechaConsulta("30-07-201"),
                new CausaEnfermedad("pelea con otro pokemon"),
                new Sintomas("dolor en el cuerpo"),
                new EstadoRevision(false),
                "1111",
                "2222"
        );

        List<Consulta> consultas = new ArrayList<>();
        consultas.add(consulta);
        Mockito.when(consultaRepository.obtenerConsultaIdUsuario("1111")).thenReturn(consultas);

        List<Consulta> resp = obtenerConsultaIdUsuarioUseCase.obtenerConsultaIdUsuario("1111");

        Assertions.assertEquals(resp.size(),1);
        Assertions.assertEquals(resp.get(0).getId(),"3333");
        Assertions.assertEquals(resp.get(0).getEstadoRevision().getValor(),false);
    }

}