package Modelos;

public class Marca {
	
	public Marca (String[] dados) {
		

		String[] nome= dados[2].split("=");
		String[] preco= dados[3].split("=");
		
		this.nome = nome[1].trim();
		this.preco = Double.parseDouble(preco[1].trim());
	}
	
	public Marca () {
		
	}

		
	private String nome;
	private double preco;
			
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return ""+ nome + "," + "PREÇO="+preco;
	}
	
	
	
	
	
}
