package com.java.app;

/*This example represents the implementation of DOM XML parser. 
 *  DOM parser parses the entire XML document and loads it into memory 
 * in the form of tree structure,and we have to traverse node by node in the tree to get the values.*/

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParsingExample {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		// DOM builder factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// DOM builder
		DocumentBuilder doc = factory.newDocumentBuilder();
		// document contains the complete XML as a Tree.
		Document document = doc.parse(ClassLoader
				.getSystemResourceAsStream("student.xml"));
		ArrayList<Student> al = new ArrayList<Student>();
		// Iterating through the nodes and extracting the data.
		// getDocumentElement() returns the root element of the document and
		// getChildNodes() returns the child of the root.
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			// //encountered an <student> tag.
			Node node = nodeList.item(i);
			if (node instanceof Element) {
				Student student = new Student();
				// getAttributes():For a given Node, returns the attribute with
				// the requested name.
				student.studentId = node.getAttributes().

				getNamedItem("id").getNodeValue();
				NodeList childNode = node.getChildNodes();
				for (int j = 0; j < childNode.getLength(); j++) {

					// Encountered the child node of Student
					Node cnode = childNode.item(j);
					if (cnode instanceof Element) {
						String content = cnode.getFirstChild().getTextContent();

						switch (cnode.getNodeName()) {

						case "firstName":

							student.firstName = content;

							break;

						case "lastName":

							student.lastName = content;

							break;

						case "courseName":

							student.courseName = content;

							break;

						}

					}
				}
				// adding the data into ArrayList
				al.add(student);
			}

		}
		// Iterating the ArrayList to get the data
		for (Student student : al) {
			System.out.println(student);

		}

	};
}
