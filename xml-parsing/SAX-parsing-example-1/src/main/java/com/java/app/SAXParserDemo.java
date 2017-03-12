package com.java.app;

import java.io.IOException;
/*This example is the implementation of SAX(Simple API for XML) parser to read an XML file,
 * SAX parser is faster than DOM parser as it doesn't load the
 * entire document into memory in the form of tree structure.SAX parser parses the XML line by line triggering 
 * different events as and when it encounters different elements like: opening tag, closing tag, character data, 
 * comments and so on. */

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXException;

public class SAXParserDemo {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		SAXHandler handler = new SAXHandler();
		parser.parse(ClassLoader.getSystemResourceAsStream("company.xml"),
				handler);
		// display the list of department from XML.
		for (Department dept : handler.al) {
			System.out.println(dept);

		}
	}

}
