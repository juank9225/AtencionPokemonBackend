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

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = ListarConsultaIdUseCase.class)
class ListarConsultaIdUseCaseTest {
    @MockBean
    private ConsultaRepository consultaRepository;

    @SpyBean
    private ListarConsultaIdUseCase listarConsultaIdUseCase;

    @Test
    @DisplayName("Happy Test listar consalta por Id")
    public void listarConsultaIdHappyTest(){

        Consulta consulta = new Consulta("3333",
                new FechaConsulta("30-07-201"),
                new CausaEnfermedad("pelea con otro pokemon"),
                new Sintomas("dolor en el cuerpo"),
                new EstadoRevision(false),
                "1111",
                "2222"
        );

        Mockito.when(consultaRepository.obtenerConsulta(consulta.getId())).thenReturn(consulta);

        Consulta resp = listarConsultaIdUseCase.obtenerConsulta(consulta.getId());

        Assertions.assertEquals(resp.getId(),"3333");
        Assertions.assertEquals(resp.getSintomas().getValor(),"dolor en el cuerpo");
        Assertions.assertEquals(resp.getCausaEnfermedad().getValor(),"pelea con otro pokemon");
    }

    @Test
    @DisplayName("Sab Test listar consalta por Id")
    public void listarConsultaIdSabTest(){

        Consulta consulta = new Consulta("3333",
                new FechaConsulta("30-07-201"),
                new CausaEnfermedad("pelea con otro pokemon"),
                new Sintomas("dolor en el cuerpo"),
                new EstadoRevision(false),
                "1111",
                "2222"
        );

        Mockito.when(consultaRepository.obtenerConsulta(consulta.getId())).thenThrow(IllegalArgumentException.class);

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            listarConsultaIdUseCase.obtenerConsulta(consulta.getId());
        });
    }

}