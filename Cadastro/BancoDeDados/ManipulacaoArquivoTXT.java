package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Modelos.Alunos;
import Util.ListaDeAlunos;



public class ManipulacaoArquivoTXT {
	
	private static String nomeDoArquivo = "Cadastro de Alunos.txt";

	
	//Salva o arquivo TXT
	public static void SalvarArquivoTXT() throws IOException {
		
		
		//Responsável pela criação do arquivo TXT
		try(BufferedWriter buffer= new BufferedWriter(new FileWriter(nomeDoArquivo));
				PrintWriter pw= new PrintWriter(buffer)){

			
			//adiciona os cadastros no arquivo
			for(Alunos a: ListaDeAlunos.getInstance())
				pw.println(a);


		}
	}

//Classe responsável pelo leitura do arquivo txt	
	public static void LerArquivoTXT() throws FileNotFoundException, IOException {

		
		
		try(FileWriter arq = new FileWriter(nomeDoArquivo,true)){};
		
		
		String line="";

		//Permite que o TXT não tenha linhas vazias, sempre será preenchido com o objeto aluno
		//Cada aluno será preenchido em uma linha diferente, nunca na mesma
		try (BufferedReader reader= new BufferedReader(new FileReader(nomeDoArquivo))){
			while((line= reader.readLine()) != null && !"".equals(line)) {

				Alunos a = new Alunos(line);
				ListaDeAlunos.getInstance().add(a);
			}
		}  	
		
		



	}
}

