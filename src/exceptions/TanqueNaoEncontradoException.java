package exceptions;

public class TanqueNaoEncontradoException extends RuntimeException {
    public TanqueNaoEncontradoException(String message) {
        super(message);
    }

    public TanqueNaoEncontradoException(int id) {
        super("Tanque id: " + id + " não encontrado!");
    }

}
