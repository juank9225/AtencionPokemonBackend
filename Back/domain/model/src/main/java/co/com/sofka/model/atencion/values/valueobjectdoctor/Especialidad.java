package co.com.sofka.model.atencion.values.valueobjectdoctor;

import java.util.Objects;

public class Especialidad {
    private final String valor;

    public Especialidad(String valor) {
        this.valor = Objects.requireNonNull(valor,"la especialidad es requerido");
        if (this.valor.isEmpty()){
            throw new IllegalArgumentException("la especialidad no puede ser vacio");
        }
        if (this.valor.length() < 3 || this.valor.length() >= 50){
            throw new IllegalArgumentException("la especialidad debe tener mas de 2 caracteres y menos de 50 caracteres");
        }
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especialidad that = (Especialidad) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
