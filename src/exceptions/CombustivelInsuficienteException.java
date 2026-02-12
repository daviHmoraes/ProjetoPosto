package exceptions;

import java.math.BigDecimal;

public class CombustivelInsuficienteException extends RuntimeException {
    public CombustivelInsuficienteException(String message) {
        super(message);
    }

    public CombustivelInsuficienteException(BigDecimal litros) {
        super("Quantidade " + litros +"L, indisponível! Reabasteça o tanque!");
    }

}
