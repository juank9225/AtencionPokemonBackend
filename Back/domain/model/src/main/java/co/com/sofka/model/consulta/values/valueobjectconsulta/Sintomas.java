package co.com.sofka.model.consulta.values.valueobjectconsulta;

import java.util.Objects;

public class Sintomas {
    private final String valor;

    public Sintomas(String valor) {
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
        Sintomas sintomas = (Sintomas) o;
        return Objects.equals(valor, sintomas.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
