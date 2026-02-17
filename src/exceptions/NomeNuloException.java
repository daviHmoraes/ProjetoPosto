package exceptions;

public class NomeNuloException extends RuntimeException {
    public NomeNuloException(String message) {
        super(message);
    }

    public NomeNuloException() {
        super("O nome nao pode ser nulo!");
    }
}
