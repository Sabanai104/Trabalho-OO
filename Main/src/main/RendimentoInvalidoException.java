package main;

public class RendimentoInvalidoException extends Exception {
    public RendimentoInvalidoException() {
        super();
    }
    
    RendimentoInvalidoException(String msg) {
        super(msg);
    }
}
