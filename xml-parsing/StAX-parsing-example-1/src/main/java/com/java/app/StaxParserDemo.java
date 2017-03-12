package com.java.app;

/*This example is the implementation of StAX(Streaming API for XML) parsing.*/

import java.io.Reader;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxParserDemo {
	public static void main(String[] args) throws XMLStreamException {
		ArrayList<Book> bookList = null;
		Book book = null;
		String content = null;
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(ClassLoader
				.getSystemResourceAsStream("book.xml"));
		while (reader.hasNext()) {
			int index = reader.next();
			switch (index) {
			case XMLStreamConstants.START_ELEMENT:
				if ("books".equals(reader.getLocalName())) {

					bookList = new ArrayList<Book>();
				}
				if ("book".equals(reader.getLocalName())) {
					book = new Book();
					book.bookId = reader.getAttributeValue(0);
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				content = reader.getText().trim();
				break;
			case XMLStreamConstants.END_ELEMENT:
				switch (reader.getLocalName()) {
				case "book":
					bookList.add(book);
					break;
				case "bookName":
					book.bookName = content;
					break;
				case "bookAuthor":
					book.bookAuthor = content;
					break;

				case "bookPrice":
					book.bookPrice = content;
					break;
				}
				break;

			}
		}
		for (Iterator iterator = bookList.iterator(); iterator.hasNext();) {
			Book book2 = (Book) iterator.next();
			System.out.println(book2);

		}

	}

}
