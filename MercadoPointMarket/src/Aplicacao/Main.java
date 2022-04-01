package Aplicacao;

import Modelos.Produtos;
import View.ViewCadastroPROD;
import Modelos.Marca;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;


public class Main{

	//realiza a aplicação do programa
	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException  {

		//permite que a entrada do usuário
		BufferedReader reader= new BufferedReader( new InputStreamReader(System.in));


       CadastroPROD.ListarProdutosSalvos(1);
		
		//opções do menu: cadastrar,mostrar,deletar,editar,sair do programa

		int menu= 0 ;
		while(menu < 5){

			//faz a leitura da escolha do usuário
			menu = ViewCadastroPROD.ViewMenuPrincipal(reader);

				switch(menu) { 

				case 1:
					
					CadastroPROD.SalvarProdutos(reader);
					break;

				case 2:

					CadastroPROD.ListarProdutosSalvos(0);

					break;

				case 3:

					CadastroPROD.DeletarProdutos(reader);

					break;

				case 4:
					
					CadastroPROD.EditarProdutos(reader); 
					break;
					
				case 5:

					ViewCadastroPROD.ViewMsgFinal(7);
					break;
				}
		}

	}

}



