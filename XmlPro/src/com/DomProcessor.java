package com;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class DomProcessor {
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);
		dbf.setIgnoringElementContentWhitespace(true);
		DocumentBuilder db=dbf.newDocumentBuilder();
				
		Document doc=db.parse("books.xml");		
		Element rootElement= doc.getDocumentElement();		
		System.out.println(rootElement.getNodeName());
		System.out.println(rootElement.getChildNodes().getLength());
		
		System.out.println(rootElement.getFirstChild().getNodeName());//book
		System.out.println(rootElement.getFirstChild().getFirstChild().getNodeType());//name
		System.out.println(rootElement.getFirstChild().getFirstChild().getFirstChild().getNodeType());//name
		
		for(int i=0;i<rootElement.getChildNodes().getLength();i++) {
			for(int j=0;j<rootElement.getChildNodes().item(i).getChildNodes().getLength();j++) {
				System.out.println
		(rootElement.getChildNodes().item(i).getChildNodes().item(j).getFirstChild().getNodeValue());
			}
		}	
		
		Node newElement=doc.createElement("MyNewElement");
		Node textNode=doc.createTextNode("the value of new element");
		newElement.appendChild(textNode);
		
		Node clone=newElement.cloneNode(true);
		
		rootElement.getFirstChild().appendChild(newElement);
		rootElement.appendChild(clone);//copy and paste
		
		//To serialize the dom object to a string- so as to display
			TransformerFactory tfm=TransformerFactory.newInstance();
			Transformer tm=tfm.newTransformer();
			tm.setOutputProperty(OutputKeys.INDENT,"yes");
			DOMSource source=new DOMSource(doc);
			StringWriter writer=new StringWriter();
			StreamResult result=new StreamResult(writer);
			tm.transform(source, result);
			System.out.println(writer.toString());
		
		
	}
}