package co.com.sofka.model.consulta.valueobjectconsulta;

import java.util.Objects;

public class EstadoRevision {
    private final Boolean valor;

    public EstadoRevision(Boolean valor) {
        this.valor = Objects.requireNonNull(valor,"el sintoma es requerido");
    }

    public Boolean getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoRevision that = (EstadoRevision) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
