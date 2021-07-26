package co.com.sofka.model.usuario.valueobjectuser;

import java.util.Objects;

public class Profesion {
    private String valor;

    public Profesion(String valor) {
        this.valor = Objects.requireNonNull(valor,"la profesion es requerido");
        if (this.valor.isEmpty()){
            throw new IllegalArgumentException("la profesion no puede ser vacio");
        }
        if (this.valor.length() < 3 || this.valor.length() >= 50){
            throw new IllegalArgumentException("la profesion debe terner mas de 2 caracteres y menos de 50 caracteres");
        }
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesion profesion1 = (Profesion) o;
        return Objects.equals(valor, profesion1.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
