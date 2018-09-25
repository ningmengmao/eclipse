package mypackage.xml;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class Dom4jTest {

	public static void main(String[] args) throws Exception {
//		test0();
//		test1();
		test2();
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
	public static void test1() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read("src/mypackage/xml/1.xml");
		Element root = doc.getRootElement();
		//第一个p1
		Element p1 = root.element("p1");
		Element sex = p1.addElement("sex");
		sex.addText("nan");
		//写回XML
		//OutputFormat.createPrettyPrint() 漂亮的格式(带回车,空格的)
		//OutputFormat.createCompactFormat() 压缩的格式(去掉空格 回车)
		XMLWriter w = new XMLWriter(new FileOutputStream("src/mypackage/xml/1.xml"), 
				OutputFormat.createPrettyPrint()) ;  
		w.write(doc);
		w.close();		
	}
	public static void test2() throws Exception {
		SAXReader reader = new SAXReader();
		Document doc = reader.read("src/mypackage/xml/1.xml");
		Element root = doc.getRootElement();
		Element p1 = root.element("p1");
		//新建元素
		Element school = DocumentHelper.createElement("school");
		school.addText("ecit");
		p1.elements().add(1, school);
		XMLWriter w = new XMLWriter(new FileOutputStream("src/mypackage/xml/1.xml"),
				OutputFormat.createPrettyPrint());
		w.write(doc);
		w.close();
	}
}
