package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.swing.text.View;

import Modelos.Produtos;
import Util.ListaDeProdutos;
import Modelos.Marca;

public class ViewCadastroPROD {


	//Apresenta o menu principal ao usuário
	public static int ViewMenuPrincipal(BufferedReader Reader) throws NumberFormatException, IOException{
		System.out.println();

		System.out.println("\r================ BEM VINDO[A] AO SISTEMA MERCADO POINT MARKET! =================\r");
		System.out.println("                  |==================================|");
		System.out.println("                  |   [1] - CADASTRAR PRODUTO        |");
		System.out.println("                  |   [2] - VER PRODUTOS CADASTRADOS |");
		System.out.println("                  |   [3] - DELETAR PRODUTO          |");
		System.out.println("                  |   [4] - EDITAR PRODUTO           |");
		System.out.println("                  |   [5] - SAIR DO SISTEMA          |");
		System.out.println("                  |==================================|");

//Recebe a resposta do usuário
		return Integer.parseInt(Reader.readLine());

	}

//Pede os dados para o usuário 

	public static String[] ViewMenuSalvarProduto(BufferedReader reader) throws IOException {
		String[]MenuProduto= {"DIGITE O NOME DO PRODUTO:","DIGITE A CATEGORIA DO PRODUTO:", "DIGITE A MARCA DO PRODUTO:", "DIGITE O PREÇO DO PRODUTO:"};



		String[] dadosProdutos={"","","",""};
		for(int i=0; i< MenuProduto.length;i++) {
			System.out.println(MenuProduto[i]);
			dadosProdutos[i]=reader.readLine();
		}
		
		ViewCadastroPROD.ViewMsgFinal(0);
		return dadosProdutos;
	}
//Editar ou deletar os dados 
	public static int ViewMenuEditarOuDeletarProduto(String editar_deletar, BufferedReader reader) throws NumberFormatException, IOException {

		for(int i=0; i< ListaDeProdutos.getInstance().size();i++) 
			System.out.println(i + " - " + ListaDeProdutos.getInstance().get(i));
		
		System.out.println();


		System.out.println("DENTRE OS CADASTROS ACIMA, ESCOLHA QUAL DESEJA " + editar_deletar);
		

		return Integer.parseInt(reader.readLine());

	}

	public static String[] ViewOpcaoEdicao (BufferedReader reader) throws NumberFormatException, IOException {



		String[] dadosEditados = {"",""};


//Mostra o menu de EDITAR
		System.out.println("       ===============  ESCOLHA UM ATRIBUTO ABAIXO PARA ALTERAR ====================");

		System.out.println("                  |==================================|");
		System.out.println("                  |   [1] - NOME DO PRODUTO          |");
		System.out.println("                  |   [2] - CATEGORIA DO PRODUTO     |");
		System.out.println("                  |   [3] - NOME DA MARCA            |");
		System.out.println("                  |   [4] - PREÇO DO PRODUTO         |");
		System.out.println("                  |   [5] - VOLTAR AO MENU PRINCIPAL |");
		System.out.println("                  |==================================|");


		dadosEditados[0] = reader.readLine();

		System.out.println("ESCREVA O NOVO VALOR DO ATRIBUTO");

		dadosEditados[1] = reader.readLine();
		
	
		return dadosEditados;

	}

	//Apresenta a lista de Produtos editada
	public static void ViewListaDeProdutosEditada ()	{


	  ViewCadastroPROD.ViewMsgFinal(8);

		for(Produtos prod: ListaDeProdutos.getInstance()) {


			System.out.println();
			System.out.println("                  |==================================================|");
			System.out.println("                  |"+"[PRODUTO]" +"-" + prod.getNome()+             "|");
			System.out.println("                  |"+"[CATEGORIA]" +"-"+ prod.getCategoria() +      "|");
			System.out.println("                  |"+"[MARCA]" +"-" + prod.getMarca().getNome() +   "|");
			System.out.println("                  |"+"[PREÇO]" +"-" + prod.getMarca().getPreco()  + "|");
			System.out.println("                  |==================================================|");

		}

	}

	//Mostra todas as mensagens finais ao usuário
	public static void ViewMsgFinal(int op) {

		String[] msgFinal = {"  ===================== PRODUTO CADASTRADO !!!! =====================\r",
				"   ===================== CADASTRO DELETADO !!!! =====================\r",
				"   ===================== VOCÊ ALTEROU O NOME DO PRODUTO =====================\r",
				"   ===================== VOCÊ ALTEROU A CATEGORIA DO PRODUTO =====================\r",
				"   ===================== VOCÊ ALTEROU O NOME DA MARCA =====================\r",
				"   ===================== VOCÊ ALTEROU O PREÇO DO PRODUTO =====================\r",
				"   ===================== VOCÊ ESCOLHEU VOLTAR AO MENU INICIAL =====================\r",
		"  ===================== OBRIGADO[A] POR UTILIZAR O NOSSO SISTEMA!!! =====================\r",
				"  ===================== LISTA DE PRODUTOS CADASTRADOS =====================\r"};
		
		System.out.println(msgFinal[op]);

	}



}


	

