package exceptions;

import java.math.BigDecimal;

public class QuantidadeLitrosInvalidaException extends RuntimeException {
    public QuantidadeLitrosInvalidaException(String message) {
        super(message);
    }

    public QuantidadeLitrosInvalidaException(BigDecimal litros) {
        super("A quantidade de litros deve ser maior que 0! Quantidade inserida: " + litros);
    }
}
