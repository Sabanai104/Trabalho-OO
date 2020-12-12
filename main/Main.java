package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
                        throw new RendimentoInvalidoException("Erro! Rendimento invalido, verifique que os valores s�o positivos.");
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
                
                descricao = JOptionPane.showInputDialog("Informe a descri��o da despesa");
                val = JOptionPane.showInputDialog("Informe o valor da despesa");
                categoria = JOptionPane.showInputDialog("Informe a categoria da despesa");
                if(!"".equals(categoria))
                    subCatValidacao = JOptionPane.showInputDialog("A categoria possui uma subCategoria?\n"
                            + "Responda com 'sim' ou 'nao'."); 
                try {
                    validacao = false;
                    if("".equals(descricao)) {
                        validacao = true;
                        throw new DescricaoNaoInformadaException("Erro! Descri��o n�o informada, verifique se preencheu o campo.");
                    }
                    
                    if("".equals(categoria)) {
                        validacao = true;
                        throw new CategoriaNaoInformadaException("Erro! Categoria n�o informada, verifique se preencheu o campo.");
                    }
                    
                    if("".equals(val)) {
                        validacao = true;
                        throw new ValorNaoInformadoException("Erro! Valor n�o informado, verifique se preencheu o campo.");
                    }
                    
                    float valor = Float.parseFloat(val);
                    
                    if("sim".equals(subCatValidacao)) {
                    Despesa despesa = new Despesa(descricao, categoria, valor);
                    republica.setDespesa(despesa);
                    while("sim".equals(subCatValidacao)){ 
                        subCategoria = JOptionPane.showInputDialog("Me diga a descri��o da subCategoria");
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
				float rendimento = s.nextFloat();
				
				Pessoa p = new Pessoa(nome, email, rendimento);
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
        
	public static void main (String[] args) {

            Republica republica = new Republica();
            
            String validacao = "sim";
            JOptionPane.showMessageDialog(null, "Bem vindo ao Rep�blica App\n"
                + "Vamos cadastrar as pessoas");
            
           
            while("sim".equals(validacao)) {
               cadastroPessoas(republica);
               
               validacao = JOptionPane.showInputDialog("Gostaria de cadastrar outra pessoa?\n"
                       + "Responda com 'sim' ou 'nao'.");
            }
            
            validacao = "sim";
            
            while("sim".equals(validacao)) {
                JOptionPane.showMessageDialog(null, "Preencha a despesas desse m�s");
                cadastroDespesa(republica);
                
                validacao = JOptionPane.showInputDialog("Gostaria de cadastrar outra despesa?\n"
                        + "Responda com 'sim' ou 'nao'.");
            }
            JOptionPane.showMessageDialog(null,republica.toStringPessoa());
            JOptionPane.showMessageDialog(null, republica.toStringDespesa());
        }
 }


