package xml.sax;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * SaxParseXml
 * description:
 */
public class SaxParseXmlTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();

		SAXParser parser = factory.newSAXParser();

		XmlParseHandler handler = new XmlParseHandler();

		InputStream is = new FileInputStream(new File("D:\\test.xml"));

		parser.parse(is, handler);
		is.close();
		List<User> users = handler.getUsers();
		System.out.println("=====================");
		System.out.println(users);
	}
}
