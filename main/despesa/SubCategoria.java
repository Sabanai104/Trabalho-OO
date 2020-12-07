package main.despesa;

public class SubCategoria extends Categoria{
    //Atributos
    private String descricaoSub;

    public SubCategoria(String descricaoCat, String descricaoSub) {
        super(descricaoCat);
        
        setDescricaoSub(descricaoSub);
    }

    //Metodos
    public String getDescricaoSub() {
    	return this.descricaoSub;
    }

    public void setDescricaoSub(String descricaoCadastrada) {
    	this.descricaoSub = descricaoCadastrada;
    }
    
}
