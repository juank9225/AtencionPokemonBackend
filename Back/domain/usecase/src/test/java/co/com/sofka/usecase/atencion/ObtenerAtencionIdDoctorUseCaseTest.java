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

@SpringBootTest(classes = ObtenerAtencionIdDoctorUseCaseTest.class)
class ObtenerAtencionIdDoctorUseCaseTest {
    @MockBean
    private AtencionRepository atencionRepository;

    @SpyBean
    private ObtenerAtencionIdDoctorUseCase obtenerAtencionIdDoctorUseCase;

    @Test
    @DisplayName("Obtener atencion por Id del doctor")
    public void ListarAtenciones() {
        Atencion atencion1 = new Atencion("abcde",
                "3434545",
                "xxxx",
                new Diagnostico("El pokemón debe llevarse al hospital"),
                new FechaDeAtencion("30-01-2021")
        );

        Atencion atencion2 = new Atencion("zzzz",
                "3256465",
                "wxwx",
                new Diagnostico("El pokemón debe hidratarse"),
                new FechaDeAtencion("30-01-2021")
        );

        List<Atencion> atenciones = new ArrayList<>();
        atenciones.add(atencion1);
        atenciones.add(atencion2);

        Mockito.when(atencionRepository.obtenerAtencionIdDoctor(atencion1.getIdDoctor())).thenReturn(atenciones);

        List<Atencion> resp = obtenerAtencionIdDoctorUseCase.obtenerAtencionIdDoctor(atencion1.getIdDoctor());
        Assertions.assertEquals(resp.size(), 2);
        Assertions.assertEquals(resp.get(0).getIdDoctor(), "xxxx");
    }
}
