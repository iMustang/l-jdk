package xml.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * XmlParseHandler
 * description:
 */
public class XmlParseHandler extends DefaultHandler {
	private List<User> users; // 存放遍历集合
	private String currentTag; // 记录当前解析到的节点名称
	private User user; // 记录当前的user

	/**
	 * 文档解析时开始调用，只调用一次
	 *
	 * @throws SAXException
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("startDocument----");
		this.users = new ArrayList<>();
	}

	/**
	 * 文档解析结束后调用，只调用一次
	 *
	 * @throws SAXException
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("endDocument----");
	}

	/**
	 * 节点解析开始调用，调用多次
	 *
	 * @param uri       命名空间uri
	 * @param localName 标签名称
	 * @param qName
	 * @param attributes
	 * @throws SAXException
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		System.out.println("startElement----");

		if ("user".equals(qName)) {
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.println("attribute_name:" + attributes.getLocalName(i));
				System.out.println("attribute_value:" + attributes.getValue(i));

				this.user = new User();

				if ("id".equals(attributes.getLocalName(i))) {
					this.user.setId(Long.parseLong(attributes.getValue(i)));
				}
			}
		}
		this.currentTag = qName;
	}

	/**
	 * 节点解析结束后调用，调用多次
	 *
	 * @param uri
	 * @param localName
	 * @param qName
	 * @throws SAXException
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		System.out.println("endElement----");
		if ("user".equals(qName)) {
			this.users.add(this.user);
			this.user = null;
		}
		this.currentTag = null;
	}

	/**
	 * 调用多次
	 *
	 * @param ch
	 * @param start
	 * @param length
	 * @throws SAXException
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String value = new String(ch, start, length);
		System.out.println("value:" + value);

		if ("name".equals(this.currentTag)) {
			this.user.setName(value);
		}
		if ("password".equals(this.currentTag)) {
			this.user.setPassword(value);
		}
	}

	public List<User> getUsers() {
		return this.users;
	}
}
