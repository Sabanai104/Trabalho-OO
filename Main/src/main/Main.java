package main;

import javax.swing.JOptionPane;
import main.despesa.Categoria;
import main.despesa.SubCategoria;
import main.Republica;

public class Main {
    
        static void cadastroPessoas(Republica republica) {
           
            boolean validacao = true;
            String nome, email, rendimento;
            float rend;
            while(validacao){
                
                nome = JOptionPane.showInputDialog("Me diga o nome");
                email = JOptionPane.showInputDialog("Me diga o email");
                rendimento = JOptionPane.showInputDialog("Me diga o rendimento total");
            
                try {
                    validacao = false;
                    if("".equals(nome) || "".equals(email) || "".equals(rendimento)) {
                        System.out.println("OIE");
                        validacao = true;
                        throw new DadosPessoaisIncompletosException("Erro! Dados pessoais incompletos, verifique se preencheu todos os campos.");
                    }
                    
                    rend = Float.parseFloat(rendimento);
                    Pessoa pessoa = new Pessoa(nome, email, rend);
                    republica.setPessoa(pessoa);
                } catch(DadosPessoaisIncompletosException e) {
                    String msg = e.getMessage() + "\n"; 
                    JOptionPane.showMessageDialog(null, msg);
                }
            }
        }
	
	public static void main (String[] args) {
            Republica republica = new Republica();
            
            String validacao = "sim";
            JOptionPane.showMessageDialog(null, "Bem vindo ao República App\n "
                    + "Vamos cadastrar as pessoas");
            
            while("sim".equals(validacao)){
               cadastroPessoas(republica);
               
               validacao = JOptionPane.showInputDialog("Gostaria de cadastrar outra pessoa?");
            }
            
            JOptionPane.showMessageDialog(null,republica.toString());
        }
 }


