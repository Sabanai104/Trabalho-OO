package trabalho_OO.main.despesa;

import trabalho_OO.main.despesa.SubCategoria;

public class Despesa {
    //Atributos
    private String descricao;
    private Categoria categoria; 
    private float valor;

    //Métodos
    public String getDescricao() {
    	return descricao;

    }
    public void setDescricao(String descricaoCadastrada) {
    	descricao = descricaoCadastrada;
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
        
    }
    
}
