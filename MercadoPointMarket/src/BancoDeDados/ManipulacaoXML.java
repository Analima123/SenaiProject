package BancoDeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandlerProdutos;
import Modelos.Produtos;
import Util.ListaDeProdutos;






public class ManipulacaoXML {

	private static String nomeDoArquivo = "CadastroDeProdutos.xml";



	public static void SalvarXML() throws ParserConfigurationException, FileNotFoundException, IOException, TransformerException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.newDocument();

		Element produtosTag = doc.createElement("Produtos");
		doc.appendChild(produtosTag);

		for(Produtos prod : ListaDeProdutos.getInstance()) {

			Element produtoTag = doc.createElement("produto");
			produtoTag.setAttribute("id", "1");
			produtosTag.appendChild(produtoTag);

			Element nomeTag = doc.createElement("Nome");
			nomeTag.setTextContent(prod.getNome());
			produtosTag.appendChild(nomeTag);

			Element categoriaTag = doc.createElement("Categoria");
			categoriaTag.setTextContent(prod.getCategoria());
			produtosTag.appendChild(categoriaTag);

			Element marcaTag = doc.createElement("Marca");
			produtosTag.appendChild(marcaTag);
			
			Element nomemarcaTag = doc.createElement("NomeMarca");
		    nomemarcaTag.setTextContent(prod.getMarca().getNome());
			produtosTag.appendChild(nomemarcaTag);

			Element precoTag = doc.createElement("Preco");
			precoTag.setTextContent(String.valueOf(prod.getMarca().getPreco()));
			produtosTag.appendChild(precoTag);



		}

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();

		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		DOMSource source = new DOMSource(doc);

		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo),"ISO-8859-1")){ 

			StreamResult result = new StreamResult(osw);

			trans.transform(source, result);


		}



	}

	public static void LerArquivoXML() throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {

		SAXParserFactory spf = SAXParserFactory.newInstance();

		SAXParser parser = spf.newSAXParser();

		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo),"ISO-8859-1")){

			InputSource source = new InputSource(isr);
			
			XMLHandlerProdutos handler = new XMLHandlerProdutos(); 
			
			parser.parse(source, handler);
		}
		
		
		
		}
	}



