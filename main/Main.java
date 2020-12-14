package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;
import main.despesa.Despesa;

public class Main {
    
        static void cadastroPessoas(Republica republica) {
           
            boolean validacao = true;
            String nome, email, rendimento;
            float rend = 0;
            
            while(validacao) {
                
                nome = JOptionPane.showInputDialog("Me diga o nome");
                email = JOptionPane.showInputDialog("Me diga o email");
                rendimento = JOptionPane.showInputDialog("Me diga o rendimento total");
            
                try {
                    validacao = false;
                    if("".equals(nome) || "".equals(email) || "".equals(rendimento)) {
                        validacao = true;
                        throw new DadosPessoaisIncompletosException("Erro! Dados pessoais incompletos, verifique se preencheu todos os campos.");
                    }
                    
                    rend = Float.parseFloat(rendimento);
                    
                    if(rend < 0) {
                        validacao = true;
                        throw new RendimentoInvalidoException("Erro! Rendimento invalido, verifique que os valores sao positivos.");
                    }
                    
                    Pessoa pessoa = new Pessoa(nome, email, rend);
                    republica.setPessoa(pessoa);
                } catch(DadosPessoaisIncompletosException | RendimentoInvalidoException e) {
                    String msg = e.getMessage() + "\n"; 
                    JOptionPane.showMessageDialog(null, msg);
                }
            }
        }
        
        static void cadastroDespesa(Republica republica) {
            String descricao, val, categoria, subCategoria, subCatValidacao = null;
            boolean validacao = true;
            
            while(validacao) {
                
                descricao = JOptionPane.showInputDialog("Informe a descricao da despesa");
                val = JOptionPane.showInputDialog("Informe o valor da despesa");
                categoria = JOptionPane.showInputDialog("Informe a categoria da despesa");
                if(!"".equals(categoria))
                    subCatValidacao = JOptionPane.showInputDialog("A categoria possui uma subCategoria?\n"
                            + "Responda com 'sim' ou 'nao'."); 
                try {
                    validacao = false;
                    if("".equals(descricao)) {
                        validacao = true;
                        throw new DescricaoNaoInformadaException("Erro! Descricao nao informada, verifique se preencheu o campo.");
                    }
                    
                    if("".equals(categoria)) {
                        validacao = true;
                        throw new CategoriaNaoInformadaException("Erro! Categoria nao informada, verifique se preencheu o campo.");
                    }
                    
                    if("".equals(val)) {
                        validacao = true;
                        throw new ValorNaoInformadoException("Erro! Valor nao informado, verifique se preencheu o campo.");
                    }
                    
                    float valor = Float.parseFloat(val);
                    
                    if("sim".equals(subCatValidacao)) {
	                    Despesa despesa = new Despesa(descricao, categoria, valor);
	                    republica.setDespesa(despesa);
	                    while("sim".equals(subCatValidacao)){ 
	                        subCategoria = JOptionPane.showInputDialog("Me diga a descricao da subCategoria");
	                        despesa.novaSubCategoria(subCategoria);
	                        subCatValidacao = JOptionPane.showInputDialog("Quer adicionar outra subCategoria?\n"
	                                + "Responda com 'sim' ou 'nao'.");
	                    }
	                } else {
	                    subCategoria = null;
	
	                    Despesa despesa = new Despesa(descricao, categoria, valor);
	                    despesa.novaSubCategoria(subCategoria);
	                    republica.setDespesa(despesa);    
	                }
                } catch(DescricaoNaoInformadaException | CategoriaNaoInformadaException | ValorNaoInformadoException e) {
                    String msg = e.getMessage() + "\n"; 
                    JOptionPane.showMessageDialog(null, msg);
                }
            }
        }
	
    static final String nomeArquivoPessoa = "pessoas.txt";
    
    static void lerArquivoPessoas(Republica republica) throws IOException {
    	Scanner s = null; 
		BufferedReader entrada = null;
		
		
		try {
			
			entrada = new BufferedReader(new FileReader(nomeArquivoPessoa));
			String linha; 
			while ((linha = entrada.readLine()) != null) {
				s = new Scanner(linha);
				s.useDelimiter(";");
				
				String nome = s.next();
				String email = s.next();
				String rendimentoString = s.next();
				
				Float rendimentoFloat = Float.parseFloat(rendimentoString);
				
				Pessoa p = new Pessoa(nome, email, rendimentoFloat);
				republica.setPessoa(p);
			}
				
		} catch (Exception e){
			String msg = e.getMessage() + "\n"; 
            JOptionPane.showMessageDialog(null, msg);
		}finally {
			if (entrada != null)
				entrada.close();
		}
    }
    
    static final  Calendar calendario =  Calendar.getInstance();
    static final int mes = calendario.get(Calendar.MONTH);
    static final int ano = calendario.get(Calendar.YEAR);
    static final String nomeArquivoDespesa = "despesas" +"_"+ Integer.toString(mes)+ "_" + Integer.toString(ano) + ".txt";
    
    static void lerArquivoDespesas(Republica republica) throws IOException {
    	Scanner s = null; 
		BufferedReader entrada = null;
		
		try {
			
			entrada = new BufferedReader(new FileReader(nomeArquivoDespesa));
			String linha; 
			while ((linha = entrada.readLine()) != null) {
				s = new Scanner(linha);
				s.useDelimiter(";");
				
				String nomeDespesa = s.next();
				String catSubcat = s.next();
				String val = s.next();
				
				Float valor = Float.parseFloat(val);
				
				Despesa D = new Despesa(nomeDespesa, catSubcat, valor);
				republica.setDespesa(D);
			}
				
		} catch (Exception e){
			String msg = e.getMessage() + "\n"; 
            JOptionPane.showMessageDialog(null, msg);
		}finally {
			if (entrada != null)
				entrada.close();
		}
    }
        
	public static void main (String[] args) throws IOException {
		Republica republica = new Republica();
        String validacao = "sim";   
        boolean control1 = true;
            
        do {
            
            String opcao = JOptionPane.showInputDialog("Bem vindo ao RepublicApp\n\n"
                    + "Digite a opção desejada:\n"
                    + "1)Cadastros\n"
                    + "2)Calculo despesas");
            
            switch (opcao){
	            case "1":
	            	while("sim".equals(validacao)) {
	            		cadastroPessoas(republica);
	            		validacao = JOptionPane.showInputDialog("Gostaria de cadastrar outra pessoa?\n"
	            				+ "Responda com 'sim' ou 'nao'.");
	            	}
	            	validacao = "sim";
	            	
	            	while("sim".equals(validacao)) {
	            		JOptionPane.showMessageDialog(null, "Preencha a despesas desse mes");
	            		cadastroDespesa(republica);
	            		
	            		validacao = JOptionPane.showInputDialog("Gostaria de cadastrar outra despesa?\n"
	            				+ "Responda com 'sim' ou 'nao'.");
	            	}
	            	JOptionPane.showMessageDialog(null,republica.toStringPessoa());
	            	JOptionPane.showMessageDialog(null, republica.toStringDespesa());
	            	control1 = true;
	            	
	            	break;
	            case "2":
	            	boolean control2 = false;
	            	do {
		            	opcao = JOptionPane.showInputDialog("1)Regra igualitaria\n"
		                        + "2)Regra proporcional");

		            		switch (opcao) {
		            			case "1":
		            				control2 = true;
		            				lerArquivoDespesas(republica);
		            				lerArquivoPessoas(republica);
		            				republica.regraIgualitaria();
		            				break;
		            	
		            			case "2":
		            				control2 = true;
		            				lerArquivoDespesas(republica);
		            				lerArquivoPessoas(republica);
		            				republica.regraProporcional();
		            				break;
		            	
		            			default:
		            				JOptionPane.showMessageDialog(null,"Erro! Opcao invalida");
		            				control2 = false;
		            				break;
		            				
		            		}
	            	} while(control2 == false);
	            	control1 = true;
	            	break;
	            default:
	            	JOptionPane.showMessageDialog(null,"Erro! Opcao invalida");
	            	control1 = false;
	            	break;
	            }
            
           
        }while(control1 == false);
	}
}

