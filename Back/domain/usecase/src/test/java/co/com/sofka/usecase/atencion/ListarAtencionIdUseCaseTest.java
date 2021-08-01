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

@SpringBootTest(classes = ListarAtencionIdUseCase.class)
class ListarAtencionIdUseCaseTest {
    @MockBean
    private AtencionRepository atencionRepository;

    @SpyBean
    private ListarAtencionIdUseCase listarAtencionIdUseCase;

    @Test
    @DisplayName("Test listar atenciones")
    public void ListarAtenciones() {
        Atencion atencion = new Atencion("xxxx",
                "3434545",
                "xxxx",
                new Diagnostico("El pokemón debe llevarse al hospital"),
                new FechaDeAtencion("30-01-2021")
        );

        Mockito.when(atencionRepository.obtenerAtencion(atencion.getId())).thenReturn(atencion);
        Atencion resp = listarAtencionIdUseCase.obtenerAtencion("xxxx");

        Assertions.assertEquals(resp.getId(), "xxxx");
        Assertions.assertEquals(resp.getDiagnostico().getValor(), "El pokemón debe llevarse al hospital");
    }
}