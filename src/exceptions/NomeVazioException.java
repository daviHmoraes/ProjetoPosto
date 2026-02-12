package exceptions;

public class NomeVazioException extends RuntimeException {
    public NomeVazioException(String nome) {
        super("O nome " + nome + " e invalido. O nome nao pode ser vazio!");
    }
}
