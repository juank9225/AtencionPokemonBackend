package co.com.sofka.model.consulta.values.valueobjectconsulta;

import java.util.Objects;

public class CausaEnfermedad {
    private final String valor;

    public CausaEnfermedad(String valor) {
        this.valor = Objects.requireNonNull(valor,"la causa de la enfermedad es requerida");
        if (this.valor.isEmpty()){
            throw new IllegalArgumentException("el campo de la causa de la enfermedad no puede ser vacia");
        }
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CausaEnfermedad that = (CausaEnfermedad) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
