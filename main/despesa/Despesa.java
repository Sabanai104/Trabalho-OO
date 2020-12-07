package main.despesa;

public class Despesa {
    //Atributos
    private String descricao;
    private Categoria categoria; 
    private float valor;
    
    //Construtor 
    public Despesa(String descricao, String descricaoCat, float valor) {
        setDescricao(descricao);
        setCategoria(descricaoCat);
        setValor(valor);
    }
    
    //Métodos
    public String getDescricao() {
    	return descricao;

    }
    public void setDescricao(String descricaoCadastrada) {
    	this.descricao = descricaoCadastrada;
    }
    public String getCategoria() {
    	return this.categoria.getDescricao();
    }
    public void setCategoria(String descricaoCat) {
        this.categoria = new Categoria (descricaoCat);
    }	
    
    public float getValor() {
    	return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public void novaSubCategoria(String descricaoSub) {
        SubCategoria subCat = new SubCategoria(this.descricao, descricaoSub);
        this.categoria.setSubCategoria(subCat);
    }
    
    public String printSubCategoria() {
         String retorno = categoria.toStringSub();
         return retorno;
    }
    
}
