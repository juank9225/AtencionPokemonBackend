package co.com.sofka.model.atencion.values.valueobjectatencion;

import java.util.Objects;

public class Diagnostico {
    private final String valor;

    public Diagnostico(String valor) {
        this.valor = Objects.requireNonNull(valor,"el sintoma es requerido");
        if (this.valor.isEmpty()){
            throw new IllegalArgumentException("el campo sintoma no puede ser vacio");
        }
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnostico that = (Diagnostico) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
