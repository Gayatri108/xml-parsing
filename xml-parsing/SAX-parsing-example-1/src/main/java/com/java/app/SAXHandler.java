package com.java.app;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
	ArrayList<Department> al = new ArrayList<Department>();
	Department department = null;
	String content = null;

	// startElement() is invoked when an start tag of department is found.
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		switch (qName) {
		case "department":
			// create department object
			department = new Department();
			department.deptId = attributes.getValue("deptId");

			break;
		}

	}

	// This method is invoked when the end tag of department is found.
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		switch (qName) {
		case "department":
			// Adding department object to ArrayList once end tag(department) is
			// found
			al.add(department);
			break;
		// Employee has to be updated for other end tag(i.e deptName,deptLoc)
		case "deptName":
			department.deptName = content;
			break;
		case "deptLoc":
			department.deptLoc = content;
			break;

		}

	}

	// This method will be invoked when text data will be found.
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		content = String.copyValueOf(ch, start, length).trim();

	}

}
