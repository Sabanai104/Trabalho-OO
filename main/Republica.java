package trabalho_OO.main;

import trabalho_OO.main.despesa.Despesa;

public class Republica {
    //Atributos 
    private Pessoa pessoas;
    private Despesa despesas;    
    
    
    //Metodos 
    public Pessoa getPessoa(){
        return pessoas;
    }
    public void setPessoa(Pessoa pessoa){

    }
    public void addPessoa(String nome,String email,float rendimento,int numeroPessoa) {
    	
    	Pessoa[] p;
    	p = new Pessoa[500];
    	p[numeroPessoa] = new Pessoa();
    	
    	p[numeroPessoa].setNome(nome);
    	p[numeroPessoa].setEmail(email);
    	p[numeroPessoa].setTotalRendimento(rendimento);
    	

    }

    public Despesa getDespesa(){
    	return despesas;
    }
    public void setDespesa(Despesa despesa){
    
    }
    
    public float regraIgualitaria() {
    	
    	
        
    }
    
    public float regraProporcional() {
        
    }
}
