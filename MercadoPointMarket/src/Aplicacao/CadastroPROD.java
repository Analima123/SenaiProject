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

	//Método responsável por salvar os cadastros de alunos de acordo com os atributos
	public static void SalvarProdutos (BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException, SAXException {



		//instanciona os objetos "produto e "marca."
		Produtos produto= new Produtos();
		Marca marca= new Marca();

		
		//Armazena os atributos na variável "dadosAlunos".
		//[0] por exemplo, representa a posição dos atributos.
		String[] dadosProdutos =ViewCadastroPROD.ViewMenuSalvarProduto(reader);
		

		//O set adiciona os atributos vindos da variavel temporária "dadosProdutos" e são inseridos nos objetos "produto" e "marca" instanciados logo acima.
		//O comando Integer.parseInt converte os dados de String para int
		produto.setNome(dadosProdutos[0]);
		produto.setCategoria(dadosProdutos[1]);
		marca.setNome(dadosProdutos[2]);
		marca.setPreco(Double.parseDouble(dadosProdutos[3]));
		
		//Adiciona o objeto marca no objeto produto, ou seja, conecta as informações.
		produto.setMarca(marca);
		
		//O método getInstance permite o acesso a classe Lista de Produtos, sem a necessidade de chama-la diversas vezes 
		//o add(produto) permite que o objeto seja inserido na lista cada vez que for feito um novo cadastro.
		ListaDeProdutos.getInstance().add(produto);
    
		
		//Salva os dados inseridos nos ARQUIVOS TXT E XML.
		ManipulacaoTXT.SalvarArquivoTXT();
		ManipulacaoXML.SalvarXML();
		


	}
	
    //Método responsável por Listar os cadastros de produtos
	public static void ListarProdutosSalvos(int op) throws IOException, ParserConfigurationException, TransformerException, SAXException {

		//Faz a limpeza da lista de produtos
		ListaDeProdutos.getInstance().clear();

		//Permite que o arquivo XML faça a leitura dos objetos.
		//ManipulacaoArquivoTXT.LerArquivoTXT();
          ManipulacaoXML.LerArquivoXML();
          
          if (op ==0)
          //Mostra a lista de produtos atualizada caso seja feita alguma alteração.
			ViewCadastroPROD.ViewListaDeProdutosEditada();
		}
	
	
	  //Método responsável por deletar os alunos cadastrados.
	public static void DeletarProdutos(BufferedReader reader)throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {

		//Variavel responsável por deletar os cadastros de acordo com o índice
		//Vale observar que foram adicionados parâmetros responsáveis por mostrar a ação que será feita com o indice escolhido.
		int indice = ViewCadastroPROD.ViewMenuEditarOuDeletarProduto("DELETAR", reader);

		//Permite que remova o cadastro da lista de alunos de acordo com o indice.
        ListaDeProdutos.getInstance().remove(indice);

    	//Salva as alterações feitas no arquivo TXT E XML após deletar os cadastros.
        ManipulacaoTXT.SalvarArquivoTXT();
        ManipulacaoXML.SalvarXML();

      //Apresenta uma mensagem para mostrar que o cadastro foi deletado.
			ViewCadastroPROD.ViewMsgFinal(1);
		}

	
	  //Método responsável por editar os dados dos produtos cadastrados.
	public static void EditarProdutos(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException{

		//Variavel responsável por alterar o dado escolhido  os cadastros de acordo com o índice.
//Variável responsável por receber o indice e o dado que será alterado.
		String[] dadosEditados = {"",""};

		
		//Vale observar que foram adicionados parâmetros responsáveis por mostrar a ação que será feita com o indice escolhido.
		int indice = ViewCadastroPROD.ViewMenuEditarOuDeletarProduto("EDITAR", reader);

		
		//Faz com que o objeto produto seja pego da lista de produtos de acordo com o seu indice
		Produtos produto = ListaDeProdutos.getInstance().get(indice);

		//Seleciona a opção do indice escolhido do usuário para edição
		dadosEditados= ViewCadastroPROD.ViewOpcaoEdicao(reader);

		
		//Faz o menu de opções de quais atributos o usuário deseja editar
		// OBS* Não foi preciso a chamada do marca.get preço por exemplo, pois a marca foi colocado no objeto produto anteriormente.
		switch(Integer.parseInt(dadosEditados[0])){


		//Edição nome + mensagem final mostrando que o nome foi alterado
		case 1:
			produto.setNome(dadosEditados[1]);
			
			ViewCadastroPROD.ViewMsgFinal(2);
			break;
			
			//Edição categoria + mensagem final mostrando que a categoria foi alterada
		case 2:
			produto.setCategoria(dadosEditados[1]);
			
			ViewCadastroPROD.ViewMsgFinal(3);
			break;
			
			//Edição nome marca + mensagem final mostrando que o nome da marca foi alterado
		case 3:
			produto.getMarca().setNome(dadosEditados[1]);
			
			ViewCadastroPROD.ViewMsgFinal(4);

			break;
			
			//Edição preço + mensagem final mostrando que a preço foi alterado
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
		
		//Salva as alterações feitas após a edição dos atributos ( indice + produto ) nos arquivos TXT E XML.
		ListaDeProdutos.getInstance().set(indice, produto);
		ManipulacaoTXT.SalvarArquivoTXT();
		ManipulacaoXML.SalvarXML();
	
		}


	}
	

