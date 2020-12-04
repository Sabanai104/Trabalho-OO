package trabalho_OO.main;

import java.util.Scanner;

import trabalho_OO.main.despesa.Categoria;
import trabalho_OO.main.despesa.SubCategoria;

public class Main {
	
	public static void main (String[] args) {
		
    	Republica rep = new Republica();
		
		int numeroPessoa = 0;
    	int numeroCategoria = 0;
		int numeroSubCategoria = 0;
		
		System.out.println("Bem vindo ao REPUBLICA APP!\n\n"
				+ "Para começar, você precisa fazer os devidos cadastros.\n"
				+ "1) Pessoas\n"
				+ "2) Despesas\n"
				+ "3) Categorias\n\n"
				+ "escolha entre as opções acima: ");
		
		    Scanner sc = new Scanner(System.in);
		
		int opcao = sc.nextInt();
		
    	sc.nextLine();
		    
		switch (opcao) {
	    case 1:
	    	
	    	int simNao;

	    	System.out.println("Você escolheu: Cadastrar pessoas.");
	    	
	    	do {
	    	
	    	System.out.println("Digite o nome:");
	    	
	    	String nome = sc.nextLine();
	    	
	    	System.out.println("Digite o email:");
	    	
	    	String email = sc.next();
	    	
	    	System.out.println("Digite o rendimento total:");
	    	
	    	float rendimento = sc.nextFloat();
	    	
	    	rep.addPessoa(nome,email,rendimento,numeroPessoa);
	    	
	    	numeroPessoa++;
	    	
	    	System.out.println("Deseja cadastrar mais uma pessoa?\n\n"
	    			+ "1) sim\n"
	    			+ "2) nao");
	    	
	    	simNao = sc.nextInt();
	    	
	    	sc.nextLine();
	    	
	    	} while (simNao == 1);
	    	
	    	
	    	break;
	    case 2:
	    	
	    	System.out.println("Você escolheu: Cadastrar despesas.");
	    	
	    	System.out.println("");

	    break;
	    
	    case 3:
	    	
	    	System.out.println("Você escolheu: Cadastrar categorias.\n\n");
	    	
	    	System.out.println("Digite a descrição da categoria: ");
	    	
	    	String descricaoCateg = sc.nextLine();
	    	
	    	System.out.println("A categoria cadastrada possui uma subcategoria?\n\n"
	    			+ "1) sim \n"
	    			+ "2) nao");
	    	
	    	simNao = sc.nextInt();
	    	
	    	if (simNao == 1) {
	    		
	    		System.out.println("Digite a descriçãoo da subcategoria:");
		    	
		    	String descricaoSubCategoria = sc.next();
		    	
		    	SubCategoria[] subCateg;
		    	subCateg = new SubCategoria[500];
		    	subCateg[numeroSubCategoria] = new SubCategoria();
		    	
		    	subCateg[numeroSubCategoria].setDescricao(descricaoSubCategoria);
		    	
	    	}

	    	
	    	Categoria[] categ;
	    	categ = new Categoria[500];
	    	categ[numeroCategoria] = new Categoria();
	    	
	    	categ[numeroCategoria].setDescricao(descricaoCateg);
	    	
	    	
	    	
	    default: 
	    	
	    	System.out.println("Erro: opção invalida.");

	    break;
	}
		
	}

}
