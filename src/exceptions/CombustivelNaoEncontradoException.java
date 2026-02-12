package exceptions;

public class CombustivelNaoEncontradoException extends RuntimeException {
    public CombustivelNaoEncontradoException(String message) {
        super(message);
    }

    public CombustivelNaoEncontradoException(int id) {
        super("Combustivel ID: " + id + " nao encontrado!");
    }

}
