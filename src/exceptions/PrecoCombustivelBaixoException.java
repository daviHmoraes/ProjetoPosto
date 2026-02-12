package exceptions;

import java.math.BigDecimal;

public class PrecoCombustivelBaixoException extends RuntimeException {
    public PrecoCombustivelBaixoException(String message) {
        super(message);
    }

    public PrecoCombustivelBaixoException(BigDecimal preco) {
        super("O valor R$" + preco + " é inválido! Insira um valor maior que 0!");
    }

}
