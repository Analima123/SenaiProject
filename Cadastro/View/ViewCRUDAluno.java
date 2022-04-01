package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import Modelos.Alunos;
import Modelos.Endereco;
import Util.ListaDeAlunos;

public class ViewCRUDAluno {



	public static int ViewMenuPrincipal(BufferedReader Reader) throws NumberFormatException, IOException{
		System.out.println();


		System.out.println("================ BEM VINDO[A] AO SISTEMA DE CADASTRO DE ALUNOS!! =================\r");
		System.out.println("                  |================================|");
		System.out.println("                  |     [1] - CADASTRAR ALUNO      |");
		System.out.println("                  |     [2] - VER CADASTRADOS      |");
		System.out.println("                  |     [3] - DELETAR ALUNO        |");
		System.out.println("                  |     [4] - EDITAR ALUNO         |");
		System.out.println("                  |     [5] - SAIR DO SISTEMA      |");
		System.out.println("                  |================================|");






		return Integer.parseInt(Reader.readLine());
	}

	public static String[] ViewMenuSalvarAluno(BufferedReader reader) throws IOException {
		String[]MenuAluno= {"DIGITE O NOME DO ALUNO:","DIGITE O CPF DO ALUNO:", "DIGITE O CURSO DO ALUNO:", "DIGITE A RUA DO ALUNO:", "DIGITE O NÚMERO/RUA DO ALUNO:", "DIGITE O BAIRRO DO ALUNO:" , "DIGITE A CIDADE DO ALUNO:", "DIGITE O ESTADO DO ALUNO:", "DIGITE O CEP DO ALUNO:"};



		String[] dadosAlunos={"","","","","","","","",""};
		for(int i=0; i< MenuAluno.length;i++) {
			System.out.println(MenuAluno[i]);
			dadosAlunos[i]=reader.readLine();
		}
		return dadosAlunos;
	}


	public static int ViewMenuEditarOuDeletarAluno(String editar_deletar, BufferedReader reader) throws NumberFormatException, IOException {

		for(int i=0; i<ListaDeAlunos.getInstance().size();i++) {
			System.out.println(i + " - " + ListaDeAlunos.getInstance().get(i));
		}
		System.out.println();


		System.out.println("DENTRE OS CADASTROS ACIMA, ESCOLHA QUAL DESEJA " + editar_deletar);

		return Integer.parseInt(reader.readLine());

	}

	public static String[] ViewOpcaoEdicao (BufferedReader reader) throws NumberFormatException, IOException {



		String[] dadosEditados = {"",""};



		System.out.println("       ===============  ESCOLHA UM ATRIBUTO ABAIXO PARA ALTERAR ====================");

		System.out.println();
		System.out.println("                  |==================================|");
		System.out.println("                  |   [1] - NOME DO ALUNO            |");
		System.out.println("                  |   [2] - CURSO DO ALUNO           |");
		System.out.println("                  |   [3] - CPF DO ALUNO             |");
		System.out.println("                  |   [4] - RUA DO ALUNO             |");
		System.out.println("                  |   [5] - NÚMERO DO ALUNO          |");
		System.out.println("                  |   [6] - BAIRRO DO ALUNO          |");
		System.out.println("                  |   [7] - CIDADE DO ALUNO          |");
		System.out.println("                  |   [8] - ESTADO DO ALUNO          |");
		System.out.println("                  |   [9] - CEP DO ALUNO             |");
		System.out.println("                  |  [10] - VOLTAR AO MENU PRINCIPAL |");
		System.out.println("                  |==================================|");



		dadosEditados[0] = reader.readLine();

		System.out.println("ESCREVA O NOVO VALOR DO ATRIBUTO");

		dadosEditados[1] = reader.readLine();





		return dadosEditados;






	}

	public static void ViewListaDeAlunosEditada ()	{

	
			for(Alunos a: ListaDeAlunos.getInstance()) {
				
				
			System.out.println();
			System.out.println("                  |==================================================|");
			System.out.println("                  |"+"[NOME]" +"-" + a.getNome()  +                 "|");
			System.out.println("                  |"+"[CURSO]" +"-"+ a.getCurso() +                 "|");
			System.out.println("                  |"+"[CPF]" +"-" + a.getCpf()  +                   "|");
			System.out.println("                  |"+"[RUA]" +"-" + a.getEndereco().getRua()  +     "|");
			System.out.println("                  |"+"[Nº]" +"-" + a.getEndereco().getNum()  +      "|");
			System.out.println("                  |"+"[BAIRRO]" +"-" + a.getEndereco().getBairro()+ "|");
			System.out.println("                  |"+"[CIDADE]" +"-" + a.getEndereco().getCidade()+ "|");
			System.out.println("                  |"+"[ESTADO]" +"-" + a.getEndereco().getEstado()+ "|");
			System.out.println("                  |"+"[CEP]" +"-" + a.getEndereco().getCep()      + "|");
			System.out.println("                  |==================================================|");

	}
			System.out.println();	

	}
	
	public static void ViewMsgFinal(int op) {

		String[] msgFinal = {"  ===================== CADASTRO REALIZADO !!!! =====================\r",
				"   ===================== CADASTRO DELETADO !!!! =====================\r",
				"   ===================== VOCÊ ALTEROU O NOME DO ALUNO =====================\r",
				"   ===================== VOCÊ ALTEROU CURSO DO ALUNO  =====================\r",
				"   ===================== VOCÊ ALTEROU O CPF DO ALUNO =====================\r",
				"   ===================== VOCÊ ALTEROU A RUA DO ALUNO =====================\r",
				"   ===================== VOCÊ ALTEROU O NÚMERO(ENDEREÇO) DO ALUNO =====================\r",
				"   ===================== VOCÊ ALTEROU O BAIRRO(ENDEREÇO) DO ALUNO =====================\r",
				"   ===================== VOCÊ ALTEROU O CIDADE(ENDEREÇO) DO ALUNO =====================\r",
				"   ===================== VOCÊ ALTEROU O ESTADO(ENDEREÇO) DO ALUNO =====================\r",
				"   ===================== VOCÊ ALTEROU O CEP(ENDEREÇO) DO ALUNO =====================\r",
		"  ===================== OBRIGADO[A] POR UTILIZAR O NOSSO SISTEMA!!! =====================\r"};
		
		System.out.println(msgFinal[op]);

	}

	
	
	
}
