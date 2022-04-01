package Modelos;

public class Alunos {

	private String nome;
	private String curso;
	private Endereco endereco;
	private int cpf;

	public Alunos (String dados) {

		String[] atributos =  dados.split(",");

		String[] nome = atributos[0].split("=");

		String[] curso= atributos[1].split("=");

		String[] cpf = atributos[2].split("=");

		Endereco endereco = new Endereco(atributos);

		this.nome = nome[1].trim();
		this.curso = curso[1].trim();
		this.cpf= Integer.parseInt(cpf[1].trim());
		this.endereco = endereco;

	}

	public Alunos() {


	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


	@Override
	public String toString() {

		return "NOME="+nome +","+"CURSO="+curso+","+"CPF="+ cpf+"," + endereco;
		
	



	}

}
