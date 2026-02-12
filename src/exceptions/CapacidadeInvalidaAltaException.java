package exceptions;

import java.math.BigDecimal;

public class CapacidadeInvalidaAltaException extends RuntimeException {
    public CapacidadeInvalidaAltaException(String message) {
        super(message);
    }

    public CapacidadeInvalidaAltaException(BigDecimal litros) {
        super("Capacidade de " + litros + " invalida. Capacidade maxima 60000.0L");
    }

}
