package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import main.despesa.Despesa;

public class Republica {
    //Atributos 
    private List<Despesa> despesas;    
    private List<Pessoa> pessoas;
    
    //Construtor
    public Republica() {
        pessoas = new LinkedList<Pessoa>();
        despesas = new LinkedList<Despesa>();
    }

    //Metodos 
    public Pessoa getPessoa(){
        return (Pessoa) pessoas;
    }
    public void setPessoa(Pessoa pessoa){
      pessoas.add(pessoa);
    }
    public Despesa getDespesa(){
    	return (Despesa) despesas;
    }
    public void setDespesa(Despesa despesa){
      despesas.add(despesa);
    }
    
    public float regraIgualitaria() {
    	
    	return 0;
        
    }
    
    public float regraProporcional() {
        return 0;
    }
    
    public String toStringPessoa() {
        String retorno = ""; 
	Iterator<Pessoa> it = pessoas.iterator();
	while (it.hasNext()) {
            Pessoa pessoa = it.next();
            retorno += "Pessoa: " + pessoa.getNome() + " // " + pessoa.getEmail() + " // " + "R$" + pessoa.getTotalRendimento() + "\n\n";
	}
		
            return retorno;
	}
    
    public String toStringDespesa() {
        String retorno = ""; 
	Iterator<Despesa> it = despesas.iterator();
	while (it.hasNext()) {
            Despesa despesa = it.next();
            
            if(despesa.printSubCategoria() == null){
                retorno += "Despesa: " + despesa.getDescricao()+ "\nValor: " + despesa.getValor()+ "\nCategoria: " + despesa.getCategoria() + "\n";
            
            } else { 
                retorno += "Despesa: " + despesa.getDescricao()+ "\nValor: " + despesa.getValor()+ "\nCategoria: " + despesa.getCategoria() + "\n" + despesa.printSubCategoria()+ "\n";
            }
        }
		
            return retorno;
	}
}
