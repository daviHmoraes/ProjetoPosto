package exceptions;

public class IdentificacaoNulaException extends RuntimeException {
    public IdentificacaoNulaException(String message) {
        super(message);
    }

    public IdentificacaoNulaException() {
        super("A identificacao nao pode ser nula!");
    }
}
