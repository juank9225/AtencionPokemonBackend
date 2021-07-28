package co.com.sofka.model.consulta.values.valueobjectmascota;

import java.util.Objects;

public class Raza {
    private final String valor;

    public Raza(String valor) {
        this.valor = Objects.requireNonNull(valor,"la raza es requerida");
        if (this.valor.isEmpty()){
            throw new IllegalArgumentException("El campo raza no puede ser vacio");
        }
        if (this.valor.length() < 3 || this.valor.length() >= 50){
            throw new IllegalArgumentException("La raza debe terner mas de 2 caracteres y menos de 50 caracteres");
        }
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Raza raza = (Raza) o;
        return Objects.equals(valor, raza.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
