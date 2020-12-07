package main;

public class DescricaoNaoInformadaException extends Exception {
    public DescricaoNaoInformadaException() {
        super();
    }
    
    public DescricaoNaoInformadaException(String msg) {
        super(msg);
    }
}
