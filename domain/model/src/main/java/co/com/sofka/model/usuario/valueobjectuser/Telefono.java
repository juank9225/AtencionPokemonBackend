package co.com.sofka.model.usuario.valueobjectuser;

import java.util.Objects;

public class Telefono {
    private String valor;

    public Telefono(String valor) {
        this.valor = Objects.requireNonNull(valor,"el telefono es obligatorio");
        if (this.valor.isEmpty()){
            throw new IllegalArgumentException("el telefono no puede ser vacia");
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
        Telefono telefono1 = (Telefono) o;
        return Objects.equals(valor, telefono1.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
