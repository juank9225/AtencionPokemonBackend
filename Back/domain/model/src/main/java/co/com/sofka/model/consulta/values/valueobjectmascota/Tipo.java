package co.com.sofka.model.consulta.values.valueobjectmascota;

import java.util.Objects;

public class Tipo {
    private final String valor;

    public Tipo(String valor) {
        this.valor = Objects.requireNonNull(valor,"el tipo de pokemon es requerido");
        if (this.valor.isEmpty()){
            throw new IllegalArgumentException("el tipo de pokemon no puede ser vacio");
        }
        if (this.valor.length() < 3 || this.valor.length() >= 50){
            throw new IllegalArgumentException("el tipo de pokemon debe terner mas de 2 caracteres y menos de 50 caracteres");
        }
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipo tipo = (Tipo) o;
        return Objects.equals(valor, tipo.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
