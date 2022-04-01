package Modelos;


public class Endereco {

	private String rua;
	private int num;
	private String bairro;
	private String cidade;
	private String estado;
	private int cep;

	
	public Endereco(String[] dados) {
	
		String[] rua= dados[3].split("=");
		
		
		
		
		
		this.rua = rua[1].trim();
		this.num = Integer.parseInt(dados[4].trim());
		this.bairro = dados[5].trim();
		this.cidade = dados[6].trim();
		this.estado = dados[7].trim();
		this.cep = Integer.parseInt(dados[8].trim());
		
	}
	
	
	
	public Endereco() {
	
		
	}

	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	
	@Override
	public String toString() {
		return "Endereço = "+rua+","+num+","+bairro+","+cidade+","+estado+","+cep;
	}
	
	
	
	
}

