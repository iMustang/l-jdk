package xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * DomParseXml
 *
 * @description DOM解析xml
 */
public class DomParseXml {
	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		// 创建DOM解析器工厂对象 DocumentBuildFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 由解析器工厂对象创建DOM解析器对象DocumentBuilder
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 由解析器对象对指定XML文件进行解析，构建相应的DOM树，创建Document对象
		Document doc = builder.parse(new File("D:\\test.xml"));
		NodeList root = doc.getElementsByTagName("root");
		NodeList products = root.item(0).getChildNodes();

		for (int i = 0; i < products.getLength(); i++) {
			NodeList nl = products.item(i).getChildNodes();
			for (int j = 0; j < nl.getLength(); j++) {
				String text = nl.item(j).getTextContent();
				System.out.println(text);
			}
		}
	}
}
