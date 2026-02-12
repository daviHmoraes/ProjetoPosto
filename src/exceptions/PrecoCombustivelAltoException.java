package exceptions;

import java.math.BigDecimal;

public class PrecoCombustivelAltoException extends RuntimeException {
    public PrecoCombustivelAltoException(String message) {
        super(message);
    }

    public PrecoCombustivelAltoException(BigDecimal preco) {
        super("O valor R$" + preco + " é inválido! Insira um valor menor que 100!");
    }

}
