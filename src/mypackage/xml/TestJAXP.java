package mypackage.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
/**
 * 实现JAXP操作xml
 * @author ningmeng
 */
public class TestJAXP {
	
	public static void main(String[] args) throws Exception {
//		test0();
//		test1();
//		test2();
		
	}
	
	/**
	 * 获取XML中标签名为name的文本内容
	 */
	public static void test0() throws ParserConfigurationException, SAXException, IOException {
		//获得DocumentBuilder实例
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//解析xml得到document
		Document doc = db.parse("C:\\Users\\ningmeng\\git\\eclipse\\src\\mypackage\\xml\\1.xml");
		//得到标签名为name的节点
		NodeList list = doc.getElementsByTagName("name");
		for (int i=0; i<list.getLength(); i++) {
			Node name = list.item(i);
			//返回此节点及其后代的文本内容
			String s = name.getTextContent();
			System.out.println(s);
		}
	}	
	/**
	 * 查询XML中第一个name元素的值
	 * @throws IOException 
	 * @throws SAXException  
	 * @throws ParserConfigurationException 
	 */
	public static void test1() throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilder dc = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = dc.parse("src/mypackage/xml/1.xml");
		NodeList list = doc.getElementsByTagName("name");
		Node name = list.item(0);
		System.out.println(name.getTextContent());	
	}
	
	/**
	 * 在第一个P1下添加一个<sex>标签,操作的xml是解析到内存中的,要改动原XML要回写XML
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws TransformerFactoryConfigurationError 
	 * @throws TransformerException 
	 */
	 public static void test2() throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
		 DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		 Document doc = db.parse("src/mypackage/xml/1.xml");
		 Node p = doc.getElementsByTagName("p1").item(0);
		 Element sex = doc.createElement("sex");
		 Text text = doc.createTextNode("nv");
		 sex.appendChild(text);
		 p.appendChild(sex);
		 
		 //回写
		 Transformer tsf = TransformerFactory.newInstance().newTransformer();
		 tsf.transform(new DOMSource(doc), 
				 new StreamResult("src/mypackage/xml/1.xml"));	
	 }
}
