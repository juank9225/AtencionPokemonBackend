package co.com.sofka.model.atencion.values.valueobjectdoctor;

import java.util.Objects;

public class Apellido {
    private final String valor;

    public Apellido(String valor) {
        this.valor = Objects.requireNonNull(valor,"el apellido es requerido");
        if (this.valor.isEmpty()){
            throw new IllegalArgumentException("el apellido no puede ser vacio");
        }
        if (this.valor.length() < 3 || this.valor.length() >= 100){
            throw new IllegalArgumentException("el apellido debe terner mas de 2 caracteres y menos de 100 caracteres");
        }
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apellido apellido = (Apellido) o;
        return Objects.equals(valor, apellido.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
