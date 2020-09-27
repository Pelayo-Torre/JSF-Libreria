
package com.miw.business.bookmanager;

import java.util.List;

import org.apache.log4j.Logger;

import com.miw.model.Book;
import com.miw.persistence.book.BookDataService;
import com.miw.persistence.vat.VATDataService;

public class BookManager implements BookManagerService {
	Logger logger = Logger.getLogger(this.getClass());
	
	private BookDataService bookDataService = null;
	private VATDataService vatDataService = null;
	
	public void setBookDataService(BookDataService bookDataService) {
		logger.debug("Injecting bookDataService");
		this.bookDataService = bookDataService;
	}

	public void setVatDataService(VATDataService vatDataService) {
		logger.debug("Injecting vatDataService");
		this.vatDataService = vatDataService;
	}

	public List<Book> getBooks() throws Exception {
		logger.debug("Asking for books");
		List<Book> books = bookDataService.getBooks();
		
		// We calculate the final price with the VAT value
		for (Book b : books) {
			b.setPrice(b.getBasePrice() * (1 + b.getVat().getValue()));
		}
		return books;
	}
	
	public Book getSpecialOffer() throws Exception
	{
		List<Book> books = getBooks();
		int number = (int) (Math.random()*books.size());
		logger.debug("Applying disccount to "+books.get(number).getTitle());
		books.get(number).setPrice((double)books.get(number).getPrice()*0.85);
		return books.get(number);
	}
}
