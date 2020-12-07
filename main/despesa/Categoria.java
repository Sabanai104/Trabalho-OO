package main.despesa;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Categoria{
    //Atributos
    private String descricao;
    private List<SubCategoria> subCategorias;

    public Categoria(String descricaoCat) {
        setDescricao(descricaoCat);
        subCategorias = new LinkedList<SubCategoria>();
    }

    //Metodos
    public String getDescricao() {
    	return descricao;
    }
    public void setDescricao(String descricaoCadastrada) {
    	this.descricao = descricaoCadastrada;
    }
    public void setSubCategoria(SubCategoria subCategoriaCadastrada) {
        subCategorias.add(subCategoriaCadastrada);
    }
    
    public String toStringSub() {
       String retorno = ""; 
       Iterator<SubCategoria> it = subCategorias.iterator();
	while (it.hasNext()) {
            SubCategoria subCategoria = it.next();
            if(subCategoria.getDescricaoSub() == null)
                return null;
            else
                retorno += "subCategorias: " + subCategoria.getDescricaoSub()+ "\n";
	}
		
            return retorno;
	}
    
}