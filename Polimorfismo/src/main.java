
public class main {
	
	
public static void main(String[] args) {
	
	
	Gato gato1 = new Gato();
	Cachorro cachorro1 = new Cachorro();
	
	
	Animal animal = new Cachorro();
	
	animal = gato1 ;
	
	//gato1.Falar();
	//cachorro1.Falar();
	
	if(animal instanceof Cachorro) {
		System.out.println("Cachorro");
	
	} else if (animal instanceof Gato) {
		System.out.println("Gato");
	}
	

	
	falar(gato1);
	falar(cachorro1);
	
	
	
	
}

private static void falar(Animal a) {
	
	a.Falar();
}





}
