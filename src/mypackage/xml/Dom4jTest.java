package mypackage.xml;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class Dom4jTest {

	public static void main(String[] args) throws DocumentException {
//		test0();
	}

	public static void test0() throws DocumentException {
		SAXReader reader = new SAXReader();
		//解析XML
		Document doc = reader.read("src/mypackage/xml/1.xml");
		Element root = doc.getRootElement();
		//获得第二层节点为p1的标签
		List<Element> list = root.elements("p1");
		for (Element e : list) {
			//p1下的name标签的文本值
			 System.out.println(e.element("name").getText());
		}
	}
}
