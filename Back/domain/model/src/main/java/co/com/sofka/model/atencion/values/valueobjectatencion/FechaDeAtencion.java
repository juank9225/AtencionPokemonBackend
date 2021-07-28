package co.com.sofka.model.atencion.values.valueobjectatencion;

import java.util.Objects;

public class FechaDeAtencion {
    private final String valor;

    public FechaDeAtencion(String valor) {
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
        FechaDeAtencion that = (FechaDeAtencion) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
