package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelos.Alunos;
import Util.ListaDeAlunos;
import Modelos.Endereco;

public class XMLHandlerAlunos extends DefaultHandler{

	private StringBuilder texto;
	Alunos aluno;
	Endereco endereco;

	@Override
	public void startDocument() throws SAXException {

		


	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if(qName.equals("aluno")) {

			aluno = new Alunos();
			endereco = new Endereco();
		} else {
			texto= new StringBuilder();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {


		if(qName.equals("Nome")) {
			aluno.setNome(texto.toString());

		} else if(qName.equals("CPF")){
			aluno.setCpf(Integer.parseInt(texto.toString()));

		} else if(qName.equals("Curso")){
			aluno.setCurso(texto.toString());

		} else if(qName.equals("Rua")){
			endereco.setRua(texto.toString());

		} else if(qName.equals("Numero")){
			endereco.setNum(Integer.parseInt(texto.toString()));
			
		} else if(qName.equals("Bairro")){
			endereco.setBairro(texto.toString());	
			
		} else if(qName.equals("Cidade")){
			endereco.setCidade(texto.toString());		
			
		} else if(qName.equals("Estado")){
			endereco.setEstado(texto.toString());			
			
		} else if(qName.equals("CEP")){
			endereco.setCep(Integer.parseInt(texto.toString()));			
			
			aluno.setEndereco(endereco);	

			 ListaDeAlunos.getInstance().add(aluno);
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		texto.append(ch, start, length);

	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		// TODO Auto-generated method stub

	}




}
