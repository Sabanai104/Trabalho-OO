package main;

public class DadosPessoaisIncompletosException extends Exception {
    
    public DadosPessoaisIncompletosException() {
        super();
    }
    
    DadosPessoaisIncompletosException(String msg) {
        super(msg);
    }
}
