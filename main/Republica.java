package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
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
    
    public void regraIgualitaria() {
    	Iterator<Despesa> itd = despesas.iterator();
    	float despesasSoma = 0;
    	
    	int quantidadePessoas = pessoas.size();
    	
    	while (itd.hasNext()) {
    		Despesa d = itd.next();
    		despesasSoma += d.getValor();
    	}
    	float div = despesasSoma / quantidadePessoas;
    	
    	String msg = "Cada pessoa pagar�:" + div +"\n";
    	
    	JOptionPane.showMessageDialog(null, msg);
    }
    
    public void regraProporcional() {
    	
    	Iterator<Pessoa> itp = pessoas.iterator();
    	Iterator<Pessoa> it = pessoas.iterator();
    	Iterator<Despesa> itd = despesas.iterator();
    	float rendaTotal = 0;
    	float despesasSoma = 0; 
    	double result = 0;
    	
    	
    	while (itd.hasNext()) {
    		Despesa d = itd.next();
    		despesasSoma += d.getValor();
    	}
    	
    	while (itp.hasNext()) {
    		Pessoa p = itp.next();
    		rendaTotal += p.getTotalRendimento(); 
    	}
    	
    	String msg ="";
    	
    	while(it.hasNext()) {
    		Pessoa P = it.next();
    		result = (despesasSoma * P.getTotalRendimento()) / rendaTotal;
    		msg += "Nome: " + P.getNome() + " Pagar� " + result + "\n";
    	}
    	JOptionPane.showMessageDialog(null, msg);    	
    }
    
    public String toStringPessoa() {
        
        String retorno = ""; 
        String resposta = "";
        Iterator<Pessoa> it = pessoas.iterator();
		while (it.hasNext()) {
	            Pessoa pessoa = it.next();
	            retorno += "Pessoa: " + pessoa.getNome() + " // " + pessoa.getEmail() + " // " + "R$" + pessoa.getTotalRendimento() + "\n\n";
	            resposta += pessoa.getNome() + ";" + pessoa.getEmail() + ";" + pessoa.getTotalRendimento() + "\n";
		}	
        
        FileWriter arquivo;
        PrintWriter gravarArquivo;
        BufferedWriter bufferWriter;
        
        try {
           File file = new File("pessoas.txt");
           
           if(!file.exists()) 
               arquivo = new FileWriter(file);
           else 
               arquivo = new FileWriter(file,true);
           
           bufferWriter = new BufferedWriter(arquivo);
           gravarArquivo = new PrintWriter(bufferWriter);
           
           gravarArquivo.print(resposta);
           gravarArquivo.close();
           
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
        }
        
        return retorno;
	}
    
    public String toStringDespesa() {
        String retorno = ""; 
        String resposta = "";
        Iterator<Despesa> it = despesas.iterator();
		while (it.hasNext()) {
	            Despesa despesa = it.next();
	            if(despesa.printSubCategoria() == null){
	            	retorno += "Despesa: " + despesa.getDescricao()+ "\nValor: " + despesa.getValor()+ "\nCategoria: " + despesa.getCategoria() + "\n";
	                resposta += despesa.getDescricao() + ";" + despesa.getCategoria() + ";" + despesa.getValor() + "\n";
	            } else { 
	                retorno += "Despesa: " + despesa.getDescricao()+ "\nValor: " + despesa.getValor()+ "\nCategoria: " + despesa.getCategoria() + "\n" + despesa.printSubCategoria()+ "\n";
	                resposta += despesa.getDescricao() + ";" + despesa.printSubCategoria() + ";" + despesa.getValor() + "\n";
	            }
	        }
        
        FileWriter arquivo;
        PrintWriter gravarArquivo;
        BufferedWriter bufferWriter;
        String nomeArquivo = "despesas";
        
        Calendar calendario =  Calendar.getInstance();

        int mes = calendario.get(Calendar.MONTH);
        int ano = calendario.get(Calendar.YEAR);
        
        nomeArquivo = nomeArquivo +"_"+ Integer.toString(mes)+ "_" + Integer.toString(ano) + ".txt";
        
        try {
	        File file = new File(nomeArquivo);
	       
	        if(!file.exists()) 
	            arquivo = new FileWriter(file);
	        else 
	            arquivo = new FileWriter(file,true);
	       
	        bufferWriter = new BufferedWriter(arquivo);
	        gravarArquivo = new PrintWriter(bufferWriter);
	       
	        gravarArquivo.print(resposta);
	        gravarArquivo.close();
           
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
        }
		
        return retorno;
	}
}
