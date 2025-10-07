package com;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxProcessorDemo {
	public static void main(String[] args) throws Exception{
		new XMLEvents();
	}
}
class XMLEvents {
		public XMLEvents()throws Exception {
			SAXParserFactory spf=SAXParserFactory.newDefaultInstance();
			SAXParser sp=spf.newSAXParser();
			sp.parse("books.xml", new MyHandler());
		}
	
}
class MyHandler extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		System.out.println("document parsing started....");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("document parsing completed....");
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s=new String(ch,start,length);
		System.out.println("Data...:"+s);
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName);
		int length=attributes.getLength();
		for(int i=0;i<length;i++) {
			String name=attributes.getLocalName(i);
			String value=attributes.getValue(i);
			System.out.println("Attribute...:"+name+":"+value);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}
}
