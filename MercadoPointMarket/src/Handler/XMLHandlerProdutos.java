package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelos.Produtos;
import Util.ListaDeProdutos;
import Modelos.Marca;

public class XMLHandlerProdutos extends DefaultHandler{

	private StringBuilder texto;
	Produtos produto;
	Marca marca;

	@Override
	public void startDocument() throws SAXException {




	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if(qName.equals("produto")) {

			produto = new Produtos();
			marca = new Marca();
		} else {
			texto= new StringBuilder();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub


		if(qName.equals("Nome")) {
			produto.setNome(texto.toString());

		} else if(qName.equals("Categoria")){
			produto.setCategoria(texto.toString());

		} else if(qName.equals("NomeMarca")){
			marca.setNome(texto.toString());

		} else if(qName.equals("Preco")){
			marca.setPreco(Double.parseDouble(texto.toString()));


			produto.setMarca(marca);	



			ListaDeProdutos.getInstance().add(produto);
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
