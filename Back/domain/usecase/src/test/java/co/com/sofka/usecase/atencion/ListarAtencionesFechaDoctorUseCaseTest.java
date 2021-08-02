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

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = ListarAtencionesFechaDoctorUseCase.class)
class ListarAtencionesFechaDoctorUseCaseTest {

    @MockBean
    private AtencionRepository atencionRepository;

    @SpyBean
    private ListarAtencionesFechaDoctorUseCase listarAtencionesFechaDoctorUseCase;

    @Test
    @DisplayName("Happy test listar atenciones por fecha y id doctor")
    public void setListarAtencionesFechaDoctorHappyTest(){

        Atencion atencion = new Atencion("xxxxx",
                "3434545",
                "xxxx",
                new Diagnostico("El pokemón debe llevarse al hospital"),
                new FechaDeAtencion("30-01-2021")
        );

        List<Atencion> atencions = new ArrayList<>();
        atencions.add(atencion);

        Mockito.when(atencionRepository.listarAtencionesFechaDoctor("xxxx")).thenReturn(atencions);

        List<Atencion> resp = listarAtencionesFechaDoctorUseCase.listarAtencionesFechaDoctor("30-01-2021","xxxx");

        Assertions.assertEquals(resp.get(0).getId(),"xxxxx");
        Assertions.assertEquals(resp.get(0).getFechaAtencion().getValor(),"30-01-2021");
        Assertions.assertEquals(resp.get(0).getDiagnostico().getValor(),"El pokemón debe llevarse al hospital");
    }

    @Test
    @DisplayName("Sab test listar atenciones por fecha y id doctor")
    public void setListarAtencionesFechaDoctorSabTest(){

        Atencion atencion = new Atencion("xxxxx",
                "3434545",
                "xxxx",
                new Diagnostico("El pokemón debe llevarse al hospital"),
                new FechaDeAtencion("30-01-2021")
        );

        List<Atencion> atencions = new ArrayList<>();
        atencions.add(atencion);

        Mockito.when(atencionRepository.listarAtencionesFechaDoctor("yyyy")).thenReturn(atencions);

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            listarAtencionesFechaDoctorUseCase.listarAtencionesFechaDoctor("yyyy","30-01-2021");
        });
    }
}