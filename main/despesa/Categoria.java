package trabalho_OO.main.despesa;

public class Categoria {
    //Atributos
    private String descricao;
    private SubCategoria subCategoria;

    //Metodos
    public String getDescricao() {
    	return descricao;
    }
    public void setDescricao(String descricaoCadastrada) {
    	descricao = descricaoCadastrada;
    }
    public SubCategoria getSubCategoria() {
    	return subCategoria;
    }
    public void setSubCategoria(SubCategoria subCategoriaCadastrada) {
    	subCategoria = subCategoriaCadastrada;
    }
    
}