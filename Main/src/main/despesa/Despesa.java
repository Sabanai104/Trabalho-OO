package main.despesa;

public class Despesa {
    //Atributos
    private String descricao;
    private Categoria categoria; 
    public String cat;
    private float valor;
    
    //Construtor 
    public Despesa(String descricao, String categoria, float valor) {
        setDescricao(descricao);
        this.cat = categoria;
        setValor(valor);
    }
    
    //Métodos
    public String getDescricao() {
    	return descricao;

    }
    public void setDescricao(String descricaoCadastrada) {
    	this.descricao = descricaoCadastrada;
    }
    public Categoria getCategoria() {
    	return categoria;
    }
    public void setCategoria(Categoria categoria) {
        
    }	
    
    public float getValor() {
    	return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
}
