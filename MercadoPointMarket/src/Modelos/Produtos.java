package Modelos;

public class Produtos {

	private String nome;
	private String categoria;
	private Marca marca;

	public Produtos(String dados) {
		
		//quebra os dados de acordo com a ,


		String[] atributos =  dados.split(",");

		String[] nome = atributos[0].split("=");

		String[] categoria = atributos[1].split("=");

		Marca marcaprod = new Marca(atributos);

        this.nome = nome[1].trim();
        this.categoria = categoria[1].trim();
        this.marca= marcaprod;
     
       

		//		for(int x=0; x < atributos.length; x++)
		//			System.out.println(atributos[x]);
		//		
	}
	public Produtos() {
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "PRODUTO="+nome +","+"CATEGORIA="+categoria+","+"MARCA="+ marca+"";

	}

}