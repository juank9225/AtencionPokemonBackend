package co.com.sofka.model.consulta.values.valueobjectmascota;

import java.util.Objects;

public class Habilidad {
    private final String valor;

    public Habilidad(String valor) {
        this.valor = Objects.requireNonNull(valor,"la habilidad es requerido");
        if (this.valor.isEmpty()){
            throw new IllegalArgumentException("la habilidad no puede ser vacio");
        }
        if (this.valor.length() < 3 || this.valor.length() >= 50){
            throw new IllegalArgumentException("la habilidad debe terner mas de 2 caracteres y menos de 50 caracteres");
        }
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habilidad habilidad = (Habilidad) o;
        return Objects.equals(valor, habilidad.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
