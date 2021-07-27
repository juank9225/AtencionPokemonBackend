package co.com.sofka.model.consulta.values.valueobjectconsulta;

import java.util.Objects;

public class FechaConsulta {
    private final String valor;

    public FechaConsulta(String valor) {
        this.valor = Objects.requireNonNull(valor,"la fecha es requerido");
        if (this.valor.isEmpty()){
            throw new IllegalArgumentException("el campo fecha no puede ser vacio");
        }
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaConsulta that = (FechaConsulta) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
