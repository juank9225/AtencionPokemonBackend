package co.com.sofka.model.usuario.valueobjectuser;

import java.util.Objects;

public class Correo {
    private final String valor;

    public Correo(String valor) {
        this.valor = Objects.requireNonNull(valor,"el correo es requerido");
        if (this.valor.isEmpty()){
            throw new IllegalArgumentException("el correo no puede ser vacio");
        }
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correo correo1 = (Correo) o;
        return Objects.equals(valor, correo1.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
