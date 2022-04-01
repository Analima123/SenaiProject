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

import BancoDeDados.ManipulacaoTXT;
import BancoDeDados.ManipulacaoXML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import Modelos.Marca;
import Modelos.Produtos;
import Util.ListaDeProdutos;
import View.ViewCadastroPROD;


public class CadastroPROD {

	//M�todo respons�vel por salvar os cadastros de alunos de acordo com os atributos
	public static void SalvarProdutos (BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException, SAXException {



		//instanciona os objetos "produto e "marca."
		Produtos produto= new Produtos();
		Marca marca= new Marca();

		
		//Armazena os atributos na vari�vel "dadosAlunos".
		//[0] por exemplo, representa a posi��o dos atributos.
		String[] dadosProdutos =ViewCadastroPROD.ViewMenuSalvarProduto(reader);
		

		//O set adiciona os atributos vindos da variavel tempor�ria "dadosProdutos" e s�o inseridos nos objetos "produto" e "marca" instanciados logo acima.
		//O comando Integer.parseInt converte os dados de String para int
		produto.setNome(dadosProdutos[0]);
		produto.setCategoria(dadosProdutos[1]);
		marca.setNome(dadosProdutos[2]);
		marca.setPreco(Double.parseDouble(dadosProdutos[3]));
		
		//Adiciona o objeto marca no objeto produto, ou seja, conecta as informa��es.
		produto.setMarca(marca);
		
		//O m�todo getInstance permite o acesso a classe Lista de Produtos, sem a necessidade de chama-la diversas vezes 
		//o add(produto) permite que o objeto seja inserido na lista cada vez que for feito um novo cadastro.
		ListaDeProdutos.getInstance().add(produto);
    
		
		//Salva os dados inseridos nos ARQUIVOS TXT E XML.
		ManipulacaoTXT.SalvarArquivoTXT();
		ManipulacaoXML.SalvarXML();
		


	}
	
    //M�todo respons�vel por Listar os cadastros de produtos
	public static void ListarProdutosSalvos(int op) throws IOException, ParserConfigurationException, TransformerException, SAXException {

		//Faz a limpeza da lista de produtos
		ListaDeProdutos.getInstance().clear();

		//Permite que o arquivo XML fa�a a leitura dos objetos.
		//ManipulacaoArquivoTXT.LerArquivoTXT();
          ManipulacaoXML.LerArquivoXML();
          
          if (op ==0)
          //Mostra a lista de produtos atualizada caso seja feita alguma altera��o.
			ViewCadastroPROD.ViewListaDeProdutosEditada();
		}
	
	
	  //M�todo respons�vel por deletar os alunos cadastrados.
	public static void DeletarProdutos(BufferedReader reader)throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {

		//Variavel respons�vel por deletar os cadastros de acordo com o �ndice
		//Vale observar que foram adicionados par�metros respons�veis por mostrar a a��o que ser� feita com o indice escolhido.
		int indice = ViewCadastroPROD.ViewMenuEditarOuDeletarProduto("DELETAR", reader);

		//Permite que remova o cadastro da lista de alunos de acordo com o indice.
        ListaDeProdutos.getInstance().remove(indice);

    	//Salva as altera��es feitas no arquivo TXT E XML ap�s deletar os cadastros.
        ManipulacaoTXT.SalvarArquivoTXT();
        ManipulacaoXML.SalvarXML();

      //Apresenta uma mensagem para mostrar que o cadastro foi deletado.
			ViewCadastroPROD.ViewMsgFinal(1);
		}

	
	  //M�todo respons�vel por editar os dados dos produtos cadastrados.
	public static void EditarProdutos(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException{

		//Variavel respons�vel por alterar o dado escolhido  os cadastros de acordo com o �ndice.
//Vari�vel respons�vel por receber o indice e o dado que ser� alterado.
		String[] dadosEditados = {"",""};

		
		//Vale observar que foram adicionados par�metros respons�veis por mostrar a a��o que ser� feita com o indice escolhido.
		int indice = ViewCadastroPROD.ViewMenuEditarOuDeletarProduto("EDITAR", reader);

		
		//Faz com que o objeto produto seja pego da lista de produtos de acordo com o seu indice
		Produtos produto = ListaDeProdutos.getInstance().get(indice);

		//Seleciona a op��o do indice escolhido do usu�rio para edi��o
		dadosEditados= ViewCadastroPROD.ViewOpcaoEdicao(reader);

		
		//Faz o menu de op��es de quais atributos o usu�rio deseja editar
		// OBS* N�o foi preciso a chamada do marca.get pre�o por exemplo, pois a marca foi colocado no objeto produto anteriormente.
		switch(Integer.parseInt(dadosEditados[0])){


		//Edi��o nome + mensagem final mostrando que o nome foi alterado
		case 1:
			produto.setNome(dadosEditados[1]);
			
			ViewCadastroPROD.ViewMsgFinal(2);
			break;
			
			//Edi��o categoria + mensagem final mostrando que a categoria foi alterada
		case 2:
			produto.setCategoria(dadosEditados[1]);
			
			ViewCadastroPROD.ViewMsgFinal(3);
			break;
			
			//Edi��o nome marca + mensagem final mostrando que o nome da marca foi alterado
		case 3:
			produto.getMarca().setNome(dadosEditados[1]);
			
			ViewCadastroPROD.ViewMsgFinal(4);

			break;
			
			//Edi��o pre�o + mensagem final mostrando que a pre�o foi alterado
		case 4:
			produto.getMarca().setPreco(Double.parseDouble(dadosEditados[1]));

			ViewCadastroPROD.ViewMsgFinal(5);
			
			break;

			//Volta ao menu principal
		case 5:
			int menu;
			
			menu = 5;
			
			ViewCadastroPROD.ViewMsgFinal(6);
			
			break;

		}
		
		//Salva as altera��es feitas ap�s a edi��o dos atributos ( indice + produto ) nos arquivos TXT E XML.
		ListaDeProdutos.getInstance().set(indice, produto);
		ManipulacaoTXT.SalvarArquivoTXT();
		ManipulacaoXML.SalvarXML();
	
		}


	}
	

