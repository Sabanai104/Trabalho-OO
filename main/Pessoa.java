package trabalho_OO.main;

public class Pessoa {
    //Atributos
    private String nome;
    private String email;
    private float totalRendimento;

    //Metodos
    public String getNome() {
    	return nome;
    }
    public void setNome(String nomeCadastrado){
    	this.nome = nomeCadastrado;
    }
    public String getEmail(){
    	return email;

    }
    public void setEmail(String emailCadastrado){
    	this.email = emailCadastrado;

    }
    public float getTotalRendimento(){
    	return totalRendimento;
    }
    public void setTotalRendimento(float totalRendimentoCadastrado){
    	this.totalRendimento = totalRendimentoCadastrado;
    }
}
