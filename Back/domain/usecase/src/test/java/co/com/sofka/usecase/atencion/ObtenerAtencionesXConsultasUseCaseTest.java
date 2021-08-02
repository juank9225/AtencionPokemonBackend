package co.com.sofka.usecase.atencion;

import co.com.sofka.model.atencion.Atencion;
import co.com.sofka.model.atencion.gateways.AtencionRepository;
import co.com.sofka.model.atencion.values.valueobjectatencion.Diagnostico;
import co.com.sofka.model.atencion.values.valueobjectatencion.FechaDeAtencion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ObtenerAtencionesXConsultasUseCase.class)
class ObtenerAtencionesXConsultasUseCaseTest {
    @MockBean
    private AtencionRepository atencionRepository;

    @SpyBean
    private ObtenerAtencionesXConsultasUseCase obtenerAtencionesXConsultasUseCase;

    @Test
    @DisplayName("Obtener atención por id de la consulta")
    public void obtenerAtencionIdConsulta() {
        Atencion atencion1 = new Atencion("xxxxx",
                "3434545",
                "xxxx",
                new Diagnostico("El pokemón debe llevarse al hospital"),
                new FechaDeAtencion("30-01-2021")
        );

        Atencion atencion2 = new Atencion("osksd",
                "56789",
                "weweewe",
                new Diagnostico("Descanso por una semana"),
                new FechaDeAtencion("30-01-2021")
        );

        List<Atencion> atencion = new ArrayList<>();
        atencion.add(atencion1);
        atencion.add(atencion2);

        Mockito.when(atencionRepository.obtenerAtencionesXConsulta(atencion1.getIdConsulta())).thenReturn(atencion);

        List<Atencion> resp = obtenerAtencionesXConsultasUseCase.obtenerAtencionesXConsulta(atencion1.getIdConsulta());
        Assertions.assertEquals(resp.size(), 2);
        Assertions.assertEquals(resp.get(0).getIdConsulta(), "3434545");
        Assertions.assertEquals(resp.get(0).getIdDoctor(),"xxxx");
    }
}