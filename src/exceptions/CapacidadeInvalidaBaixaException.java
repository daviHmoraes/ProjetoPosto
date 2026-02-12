package exceptions;

import java.math.BigDecimal;

public class CapacidadeInvalidaBaixaException extends RuntimeException {
    public CapacidadeInvalidaBaixaException(String message) {
        super(message);
    }

    public CapacidadeInvalidaBaixaException(BigDecimal litros) {
        super("Capacidade de " + litros + " invalida. Capacidade minima 0.1L");
    }

}
