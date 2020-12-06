package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import main.despesa.Despesa;

public class Republica {
    //Atributos 
    private Despesa despesas;    
    List<Pessoa> pessoas;
    
    //Construtor
    public Republica() {
        pessoas = new LinkedList<Pessoa>();
    }

    //Metodos 
    public Pessoa getPessoa(){
        return (Pessoa) pessoas;
    }
    public void setPessoa(Pessoa pessoa){
      pessoas.add(pessoa);
    }
    public Despesa getDespesa(){
    	return despesas;
    }
    public void setDespesa(Despesa despesa){
    
    }
    
    public float regraIgualitaria() {
    	
    	return 0;
        
    }
    
    public float regraProporcional() {
        return 0;
    }
    
    public String toString() {
        String retorno = ""; 
	Iterator<Pessoa> it = pessoas.iterator();
	while (it.hasNext()) {
            Pessoa pessoa = it.next();
            retorno += "Pessoa: " + pessoa.getNome() + "/ " + pessoa.getEmail() + "/ " + "R$" + pessoa.getTotalRendimento() + "\n";
	}
		
            return retorno;
	}
}
