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

@SpringBootTest(classes = ListarAtencionesUseCase.class)
class ListarAtencionesUseCaseTest {
    @MockBean
    private AtencionRepository atencionRepository;

    @SpyBean
    private ListarAtencionesUseCase listarAtencionesUseCase;

    @Test
    @DisplayName("Test listar atenciones")
    public void ListarAtenciones() {
        Atencion atencion1 = new Atencion("xxxx",
                "3434545",
                "xxxx",
                new Diagnostico("El pokemón debe llevarse al hospital"),
                new FechaDeAtencion("30-01-2021")
        );

        Atencion atencion2 = new Atencion("yyyy",
                "3445677",
                "zjire",
                new Diagnostico("El pokemón debe tener descanso"),
                new FechaDeAtencion("20-01-2021")
        );

        List<Atencion> atenciones = new ArrayList<>();
        atenciones.add(atencion1);
        atenciones.add(atencion2);

        Mockito.when(atencionRepository.listarAtenciones()).thenReturn(atenciones);
        List<Atencion> resp = listarAtencionesUseCase.listarAtenciones();

        Assertions.assertEquals(resp.size(),2);
        Assertions.assertEquals(resp.get(0).getId(),"xxxx");
        Assertions.assertEquals(resp.get(1).getId(),"yyyy");
    }
}