package co.com.sofka.model.consulta.values.valueobjectmascota;

import java.util.Objects;

public class IdentificacionMascota {
    private final Long valor;

    public IdentificacionMascota(Long valor) {
        this.valor = valor;
    }

    public Long getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificacionMascota that = (IdentificacionMascota) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
