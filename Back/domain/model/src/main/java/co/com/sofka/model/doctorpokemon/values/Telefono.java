package co.com.sofka.model.doctorpokemon.values;

import java.util.Objects;

public class Telefono {
    private final String  valor;

    public Telefono(String valor) {
        this.valor = Objects.requireNonNull(valor,"el telefono es obligatorio");
        if (this.valor.isEmpty()){
            throw new IllegalArgumentException("el telefono no puede ser vacia");
        }
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return Objects.equals(valor, telefono.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
