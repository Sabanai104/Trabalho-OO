package main;

public class ValorNaoInformadoException extends Exception {
    public ValorNaoInformadoException() {
        super();
    }
    
    public ValorNaoInformadoException(String msg) {
        super(msg);
    }
}
