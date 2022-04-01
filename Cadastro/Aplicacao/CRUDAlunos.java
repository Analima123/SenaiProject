package Aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.print.event.PrintJobAdapter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDeDados.ManipulacaoArquivoTXT;
import BancoDeDados.ManipulacaoArquivoXML;


import java.io.File;
import java.io.FileReader;

import Modelos.Alunos;
import Modelos.Endereco;
import Util.ListaDeAlunos;
import View.ViewCRUDAluno;




public class CRUDAlunos {


	//Método responsável por salvar os cadastros de alunos de acordo com os atributos
	public static void SalvarAlunos (BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {


		//instanciona os objetos "aluno" e "endereco."
		Alunos aluno= new Alunos();
		Endereco endereco= new Endereco();
		
		//Armazena os atributos na variável "dadosAlunos".
		//[0] por exemplo, representa a posição dos atributos.
		String[] dadosAlunos =ViewCRUDAluno.ViewMenuSalvarAluno(reader);

		//O set adiciona os atributos vindos da variavel temporária "dadosAlunos" e são inseridos nos objetos "aluno" e "enderecos" instanciados logo acima.
		//O comando Integer.parseInt converte os dados de String para int
		aluno.setNome(dadosAlunos[0]);
		aluno.setCpf(Integer.parseInt(dadosAlunos[1]));
		aluno.setCurso(dadosAlunos[2]);
		endereco.setRua(dadosAlunos[3]);
		endereco.setNum(Integer.parseInt(dadosAlunos[4]));
		endereco.setBairro(dadosAlunos[5]);
		endereco.setCidade(dadosAlunos[6]);
		endereco.setEstado(dadosAlunos[7]);
		endereco.setCep(Integer.parseInt(dadosAlunos[8]));

		//O método getInstance permite o acesso a classe Lista de Alunos, sem a necessidade de chama-la diversas vezes 
		//o add(aluno) permite que o objeto seja inserido na lista cada vez que for feito um novo cadastro.
		ListaDeAlunos.getInstance().add(aluno);
		
		
		//Adiciona o objeto endereço no objeto aluno, ou seja, conecta as informações.
		aluno.setEndereco(endereco);
		
		//Salva os dados inseridos nos ARQUIVOS TXT E XML.
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();

		//Mostra a mensagem mostrando que o cadastro foi realizado.
		ViewCRUDAluno.ViewMsgFinal(0);


	}


    //Método responsável por Listar os cadastros de alunos 
	public static void ListarAlunos() throws IOException, ParserConfigurationException, SAXException {

		//Faz a limpeza da lista de alunos
		ListaDeAlunos.getInstance().clear();

		
		//Permite que o arquivo XML faça a leitura dos objetos.
		//ManipulacaoArquivoTXT.LerArquivoTXT();
		ManipulacaoArquivoXML.LerArquivoXML();

        //Mostra a lista de alunos atualizada caso seja feita alguma alteração.
		ViewCRUDAluno.ViewListaDeAlunosEditada();



	}


	  //Método responsável por deletar os alunos cadastrados.
	public static void DeletarAluno (BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {

//Variavel responsável por deletar os cadastros de acordo com o índice
//Vale observar que foram adicionados parâmetros responsáveis por mostrar a ação que será feita com o indice escolhido.
		int indice = ViewCRUDAluno.ViewMenuEditarOuDeletarAluno("DELETAR", reader);

		//Permite que remova o cadastro da lista de alunos de acordo com o indice.
		ListaDeAlunos.getInstance().remove(indice);

		//Salva as alterações feitas no arquivo TXT E XML após deletar os cadastros.
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();

//Apresenta uma mensagem para mostrar que o cadastro foi deletado.
		ViewCRUDAluno.ViewMsgFinal(1);
	}


	  //Método responsável por editar os dados dos alunos cadastrados.
	public static void EditarAlunos(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException{

		//Variavel responsável por alterar o dado escolhido  os cadastros de acordo com o índice.
//Variável responsável por receber o indice e o dado que será alterado.
		String[] dadosEditados = {"",""};
		
		//Vale observar que foram adicionados parâmetros responsáveis por mostrar a ação que será feita com o indice escolhido.
		int indice = ViewCRUDAluno.ViewMenuEditarOuDeletarAluno("EDITAR",  reader);

		//Faz com que o objeto aluno seja pego da lista de alunos de acordo com o seu indice
		Alunos aluno = ListaDeAlunos.getInstance().get(indice);

		
//Seleciona a opção do indice escolhido do usuário para edição
		dadosEditados= ViewCRUDAluno.ViewOpcaoEdicao(reader);
		
		
//Faz o menu de opções de quais atributos o usuário deseja editar
// OBS* Não foi preciso a chamada do endereco.get rua por exemplo, pois o endereco foi colocado no objeto aluno anteriormente.
		switch(Integer.parseInt(dadosEditados[0])){

		//Edição nome + mensagem final mostrando que o nome foi alterado
		case 1:
			aluno.setNome(dadosEditados[1]);
			ViewCRUDAluno.ViewMsgFinal(2);
			break;
			
			//Edição curso + mensagem final mostrando que o curso foi alterado
		case 2:
			aluno.setCurso(dadosEditados[1]);
			ViewCRUDAluno.ViewMsgFinal(3);
			break;
			
			//Edição cpf + mensagem final mostrando que o cpf foi alterado
		case 3:
			aluno.setCpf(Integer.parseInt(dadosEditados[1]));
			ViewCRUDAluno.ViewMsgFinal(4);
			break;
			
			//Edição rua + mensagem final mostrando que a rua foi alterada
		case 4:
			aluno.getEndereco().setRua(dadosEditados[1]);
			ViewCRUDAluno.ViewMsgFinal(5);
			break;
			
			//Edição número + mensagem final mostrando que o número foi alterado
		case 5:
			aluno.getEndereco().setNum(Integer.parseInt(dadosEditados[1]));
			ViewCRUDAluno.ViewMsgFinal(6);
			break;
			
			//Edição bairro + mensagem final mostrando que o bairro foi alterado
		case 6:
			aluno.getEndereco().setBairro(dadosEditados[1]);
			ViewCRUDAluno.ViewMsgFinal(7);
			break;
			
			//Edição cidade + mensagem final mostrando que a cidade foi alterada
		case 7:
			aluno.getEndereco().setCidade(dadosEditados[1]);
			ViewCRUDAluno.ViewMsgFinal(8);
			break;
			
			//Edição estado + mensagem final mostrando que o estado foi alterado
		case 8:
			aluno.getEndereco().setEstado(dadosEditados[1]);
			ViewCRUDAluno.ViewMsgFinal(9);
			break;
			
			//Edição cpf + mensagem final mostrando que o cpf foi alterado
		case 9:
			aluno.getEndereco().setCep(Integer.parseInt(dadosEditados[1]));
			ViewCRUDAluno.ViewMsgFinal(10);
			break;

		}

		//Salva as alterações feitas após a edição dos atributos ( indice + aluno ) nos arquivos TXT E XML.
		ListaDeAlunos.getInstance().set(indice, aluno);
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();


	}


}















