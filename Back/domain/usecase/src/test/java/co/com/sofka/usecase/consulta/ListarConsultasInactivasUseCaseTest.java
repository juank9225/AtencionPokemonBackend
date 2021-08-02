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
@SpringBootTest(classes = ListarConsultasInactivasUseCase.class)
class ListarConsultasInactivasUseCaseTest {
    @MockBean
    private ConsultaRepository consultaRepository;

    @SpyBean
    private ListarConsultasInactivasUseCase listarConsultasInactivasUseCase;

    @Test
    @DisplayName("Happy Test listar consalta Inactivas")
    public void consultasInactivasHappyTest(){

        Consulta consulta1 = new Consulta("3333",
                new FechaConsulta("30-07-201"),
                new CausaEnfermedad("pelea con otro pokemon"),
                new Sintomas("dolor en el cuerpo"),
                new EstadoRevision(false),
                "1111",
                "2222"
        );
        Consulta consulta2 = new Consulta("4444",
                new FechaConsulta("30-07-201"),
                new CausaEnfermedad("pelea con otro pokemon fuego"),
                new Sintomas("dolor en el cuerpo"),
                new EstadoRevision(false),
                "1111",
                "2222"
        );

        List<Consulta> consultas = new ArrayList<>();
        consultas.add(consulta1);
        consultas.add(consulta2);

        Mockito.when(consultaRepository.listarConsultasInactivas("30-07-201")).thenReturn(consultas);

        List<Consulta> resp =  listarConsultasInactivasUseCase.listarConsultasInactivas("30-07-201");

        Assertions.assertEquals(resp.size(),2);
        Assertions.assertEquals(resp.get(1).getCausaEnfermedad().getValor(),"pelea con otro pokemon fuego");
        Assertions.assertEquals(resp.get(0).getCausaEnfermedad().getValor(),"pelea con otro pokemon");

    }

    @Test
    @DisplayName("Sab Test listar consalta Inactivas")
    public void consultasInactivasSabTest(){

        Consulta consulta1 = new Consulta("3333",
                new FechaConsulta("30-07-201"),
                new CausaEnfermedad("pelea con otro pokemon"),
                new Sintomas("dolor en el cuerpo"),
                new EstadoRevision(true),
                "1111",
                "2222"
        );
        Consulta consulta2 = new Consulta("4444",
                new FechaConsulta("30-07-201"),
                new CausaEnfermedad("pelea con otro pokemon fuego"),
                new Sintomas("dolor en el cuerpo"),
                new EstadoRevision(true),
                "1111",
                "2222"
        );

        List<Consulta> consultas = new ArrayList<>();
        consultas.add(consulta1);
        consultas.add(consulta2);

        Mockito.when(consultaRepository.listarConsultasInactivas("30-07-201")).thenReturn(consultas);

        List<Consulta> resp =  listarConsultasInactivasUseCase.listarConsultasInactivas("30-07-201");

        Assertions.assertEquals(resp.size(),0);
    }
}