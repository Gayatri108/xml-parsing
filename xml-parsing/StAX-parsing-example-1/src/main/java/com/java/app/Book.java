package com.java.app;

public class Book {
	String bookId;
	String bookName;
	String bookAuthor;
	String bookPrice;

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookAuthor=" + bookAuthor + ", bookPrice=" + bookPrice
				+ "]";
	}

}
