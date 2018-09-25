package mypackage.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
/**
 * 快捷修改XML内容,子类需重写run()实现自己的需求
 * @author ningmeng
 *
 */
public abstract class ModifyXMLByJAXP {
	DocumentBuilder db;
	Document doc;
	Transformer tf;
	/**
	 * 通过子类run() 修改XML
	 * @param path XML路径
	 * @throws Exception
	 */
	public void modify(String path) throws Exception {
		db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		doc = db.parse(path);
		this.run();
		tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult(path));
	}
	public abstract void run();
}
