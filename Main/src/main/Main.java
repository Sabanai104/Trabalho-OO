package main;

import javax.swing.JOptionPane;
import main.despesa.Categoria;
import main.despesa.SubCategoria;
import main.Republica;
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
                        throw new RendimentoInvalidoException("Erro! Rendimento invalido, verifique que os valores são positivos.");
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
            String descricao, categoria, val;
            
            descricao = JOptionPane.showInputDialog("Informe a descrição da despesa");
            categoria = JOptionPane.showInputDialog("Informe a categoria da despesa");
            float valor = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor da despesa"));
            
            Despesa despesa = new Despesa(descricao, categoria, valor);
            republica.setDespesa(despesa);
        }
	
	public static void main (String[] args) {
            Republica republica = new Republica();
            
            String validacao = "sim";
            JOptionPane.showMessageDialog(null, "Bem vindo ao República App\n "
                + "Vamos cadastrar as pessoas");
            
           
            while("sim".equals(validacao)) {
               cadastroPessoas(republica);
               
               validacao = JOptionPane.showInputDialog("Gostaria de cadastrar outra pessoa?");
            }
            
            validacao = "sim";
            
            while("sim".equals(validacao)) {
                JOptionPane.showMessageDialog(null, "Preencha a despesas desse mês");
                cadastroDespesa(republica);
                
                validacao = JOptionPane.showInputDialog("Gostaria de cadastrar outra despesa?");
            }
            JOptionPane.showMessageDialog(null,republica.toStringPessoa());
            JOptionPane.showMessageDialog(null, republica.toStringDespesa());
        }
 }


