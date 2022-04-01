package Aplicacao;

import Modelos.Alunos;
import Modelos.Endereco;
import View.ViewCRUDAluno;

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
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException  {

//permite que a entrada do usuário
		BufferedReader reader= new BufferedReader( new InputStreamReader(System.in));


//opções do menu: cadastrar,mostrar,deletar,editar,sair do programa
		int menu= 0 ;
		while(menu < 5) {
			
			
			//faz a leitura da escolha do usuário
			menu = ViewCRUDAluno.ViewMenuPrincipal(reader);
		

				switch(menu) {

				case 1:

					CRUDAlunos.SalvarAlunos(reader);
					break;

				case 2:
						CRUDAlunos.ListarAlunos();   
					break;

				case 3:
						CRUDAlunos.DeletarAluno(reader);
					break;

				case 4:
						CRUDAlunos.EditarAlunos(reader);
					break;

				case 5:
					 ViewCRUDAluno.ViewMsgFinal(11);
					break;
				}

		
			


		}

	}

}

