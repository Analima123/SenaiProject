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


	//M�todo respons�vel por salvar os cadastros de alunos de acordo com os atributos
	public static void SalvarAlunos (BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {


		//instanciona os objetos "aluno" e "endereco."
		Alunos aluno= new Alunos();
		Endereco endereco= new Endereco();
		
		//Armazena os atributos na vari�vel "dadosAlunos".
		//[0] por exemplo, representa a posi��o dos atributos.
		String[] dadosAlunos =ViewCRUDAluno.ViewMenuSalvarAluno(reader);

		//O set adiciona os atributos vindos da variavel tempor�ria "dadosAlunos" e s�o inseridos nos objetos "aluno" e "enderecos" instanciados logo acima.
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

		//O m�todo getInstance permite o acesso a classe Lista de Alunos, sem a necessidade de chama-la diversas vezes 
		//o add(aluno) permite que o objeto seja inserido na lista cada vez que for feito um novo cadastro.
		ListaDeAlunos.getInstance().add(aluno);
		
		
		//Adiciona o objeto endere�o no objeto aluno, ou seja, conecta as informa��es.
		aluno.setEndereco(endereco);
		
		//Salva os dados inseridos nos ARQUIVOS TXT E XML.
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();

		//Mostra a mensagem mostrando que o cadastro foi realizado.
		ViewCRUDAluno.ViewMsgFinal(0);


	}


    //M�todo respons�vel por Listar os cadastros de alunos 
	public static void ListarAlunos() throws IOException, ParserConfigurationException, SAXException {

		//Faz a limpeza da lista de alunos
		ListaDeAlunos.getInstance().clear();

		
		//Permite que o arquivo XML fa�a a leitura dos objetos.
		//ManipulacaoArquivoTXT.LerArquivoTXT();
		ManipulacaoArquivoXML.LerArquivoXML();

        //Mostra a lista de alunos atualizada caso seja feita alguma altera��o.
		ViewCRUDAluno.ViewListaDeAlunosEditada();



	}


	  //M�todo respons�vel por deletar os alunos cadastrados.
	public static void DeletarAluno (BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {

//Variavel respons�vel por deletar os cadastros de acordo com o �ndice
//Vale observar que foram adicionados par�metros respons�veis por mostrar a a��o que ser� feita com o indice escolhido.
		int indice = ViewCRUDAluno.ViewMenuEditarOuDeletarAluno("DELETAR", reader);

		//Permite que remova o cadastro da lista de alunos de acordo com o indice.
		ListaDeAlunos.getInstance().remove(indice);

		//Salva as altera��es feitas no arquivo TXT E XML ap�s deletar os cadastros.
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();

//Apresenta uma mensagem para mostrar que o cadastro foi deletado.
		ViewCRUDAluno.ViewMsgFinal(1);
	}


	  //M�todo respons�vel por editar os dados dos alunos cadastrados.
	public static void EditarAlunos(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException{

		//Variavel respons�vel por alterar o dado escolhido  os cadastros de acordo com o �ndice.
//Vari�vel respons�vel por receber o indice e o dado que ser� alterado.
		String[] dadosEditados = {"",""};
		
		//Vale observar que foram adicionados par�metros respons�veis por mostrar a a��o que ser� feita com o indice escolhido.
		int indice = ViewCRUDAluno.ViewMenuEditarOuDeletarAluno("EDITAR",  reader);

		//Faz com que o objeto aluno seja pego da lista de alunos de acordo com o seu indice
		Alunos aluno = ListaDeAlunos.getInstance().get(indice);

		
//Seleciona a op��o do indice escolhido do usu�rio para edi��o
		dadosEditados= ViewCRUDAluno.ViewOpcaoEdicao(reader);
		
		
//Faz o menu de op��es de quais atributos o usu�rio deseja editar
// OBS* N�o foi preciso a chamada do endereco.get rua por exemplo, pois o endereco foi colocado no objeto aluno anteriormente.
		switch(Integer.parseInt(dadosEditados[0])){

		//Edi��o nome + mensagem final mostrando que o nome foi alterado
		case 1:
			aluno.setNome(dadosEditados[1]);
			ViewCRUDAluno.ViewMsgFinal(2);
			break;
			
			//Edi��o curso + mensagem final mostrando que o curso foi alterado
		case 2:
			aluno.setCurso(dadosEditados[1]);
			ViewCRUDAluno.ViewMsgFinal(3);
			break;
			
			//Edi��o cpf + mensagem final mostrando que o cpf foi alterado
		case 3:
			aluno.setCpf(Integer.parseInt(dadosEditados[1]));
			ViewCRUDAluno.ViewMsgFinal(4);
			break;
			
			//Edi��o rua + mensagem final mostrando que a rua foi alterada
		case 4:
			aluno.getEndereco().setRua(dadosEditados[1]);
			ViewCRUDAluno.ViewMsgFinal(5);
			break;
			
			//Edi��o n�mero + mensagem final mostrando que o n�mero foi alterado
		case 5:
			aluno.getEndereco().setNum(Integer.parseInt(dadosEditados[1]));
			ViewCRUDAluno.ViewMsgFinal(6);
			break;
			
			//Edi��o bairro + mensagem final mostrando que o bairro foi alterado
		case 6:
			aluno.getEndereco().setBairro(dadosEditados[1]);
			ViewCRUDAluno.ViewMsgFinal(7);
			break;
			
			//Edi��o cidade + mensagem final mostrando que a cidade foi alterada
		case 7:
			aluno.getEndereco().setCidade(dadosEditados[1]);
			ViewCRUDAluno.ViewMsgFinal(8);
			break;
			
			//Edi��o estado + mensagem final mostrando que o estado foi alterado
		case 8:
			aluno.getEndereco().setEstado(dadosEditados[1]);
			ViewCRUDAluno.ViewMsgFinal(9);
			break;
			
			//Edi��o cpf + mensagem final mostrando que o cpf foi alterado
		case 9:
			aluno.getEndereco().setCep(Integer.parseInt(dadosEditados[1]));
			ViewCRUDAluno.ViewMsgFinal(10);
			break;

		}

		//Salva as altera��es feitas ap�s a edi��o dos atributos ( indice + aluno ) nos arquivos TXT E XML.
		ListaDeAlunos.getInstance().set(indice, aluno);
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();


	}


}















