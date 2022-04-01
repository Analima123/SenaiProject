
public class main {

	public static void main(String[] args) {
		
		
		Carro carro1= new Carro();
		carro1.setAno(1900);
		carro1.setMarca ("Ford");
		carro1.setModelo("Fiesta");
		carro1.setQuatroPortas(true);
		carro1.buzinar();
		
		carro1.imprimirDados();
		
		System.out.println();
		
		Moto moto1 = new Moto();
		
		moto1.setAno(2010);
		moto1.setMarca("Honda");
		moto1.setModelo("Titan");
		moto1.empinar();
		moto1.buzinar();
		
		moto1.imprimirDados();
		

		Caminhao caminhao1 = new Caminhao();
		
		caminhao1.setAno(2020);
		caminhao1.setMarca("Scania");
		caminhao1.setModelo("V-8");
		caminhao1.buzinar();

		
		caminhao1.imprimirDados();
	
	}

}
