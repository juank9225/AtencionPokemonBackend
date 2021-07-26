package co.com.sofka.model.usuario.valueobjectuser;

import java.util.Objects;

public class Identificacion {
    private Long valor;

    public Identificacion(Long valor) {
        this.valor = valor;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identificacion that = (Identificacion) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
