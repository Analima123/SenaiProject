
public class Caminhao extends Veiculo {

	@Override
	public void buzinar() {
		System.out.println("FOOOOOOOOOMM!!!!");
	}

	
	public void imprimirDados() {
		
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
		System.out.println("Ano: " + ano);
	}

}


