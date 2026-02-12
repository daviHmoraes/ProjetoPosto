package exceptions;

import java.math.BigDecimal;

public class CapacidadeExcedidaException extends RuntimeException {
    public CapacidadeExcedidaException(String message) {
        super(message);
    }

    public CapacidadeExcedidaException(BigDecimal maximo) {
        super("O tamanho máximo do tanque é " + maximo + "L!");
    }
}
