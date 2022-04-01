package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Modelos.Produtos;
import Util.ListaDeProdutos;

public class ManipulacaoTXT {
	
	private static String nomeDoArquivo = "CADASTRO DE PRODUTOS MERCADO POINT MARKET.txt";

	
	//Salva o arquivo TXT
	public static void SalvarArquivoTXT() throws IOException {

		//Responsável pela criação do arquivo TXT
		try(BufferedWriter buffer= new BufferedWriter(new FileWriter(nomeDoArquivo));
				PrintWriter pw= new PrintWriter(buffer)){

			//adiciona os cadastros no arquivo
			for(Produtos prod: ListaDeProdutos.getInstance())
				pw.println(prod);


		}
	}
	
	//Classe responsável pelo leitura do arquivo txt	
	public static void LerArquivoTXT() throws FileNotFoundException, IOException {
		
		try(FileWriter arq = new FileWriter(nomeDoArquivo,true)){};
		

		String line="";

		//Permite que o TXT não tenha linhas vazias, sempre será preenchido com o objeto produto
		//Cada produto será preenchido em uma linha diferente, nunca na mesma
		try (BufferedReader reader= new BufferedReader(new FileReader(nomeDoArquivo))){
			while((line= reader.readLine()) != null && !"".equals(line)) {

				Produtos prod = new Produtos(line);
				ListaDeProdutos.getInstance().add(prod);
			}
		}  	
		
	}
}

