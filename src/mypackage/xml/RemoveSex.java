package mypackage.xml;

import org.w3c.dom.Node;

public class RemoveSex extends ModifyXMLByJAXP {

	@Override
	public void run() {
		Node sex = this.doc.getElementsByTagName("sex").item(0);
		Node sexP = sex.getParentNode();
		sexP.removeChild(sex);
	}

	public static void main(String[] args) throws Exception {
		new RemoveSex().modify("src/mypackage/xml/1.xml");
	}

}
