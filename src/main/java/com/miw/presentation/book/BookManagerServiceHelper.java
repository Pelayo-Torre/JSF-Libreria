package com.miw.presentation.book;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Logger;

import com.miw.business.bookmanager.BookManagerService;
import com.miw.model.Book;
import com.miw.presentation.CounterBean;


@ManagedBean(name = "bookManagerServiceHelper", eager = true)
@ApplicationScoped
public class BookManagerServiceHelper {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@ManagedProperty(value = "#{counter}")
	private CounterBean counter = null;
	
	@ManagedProperty(value = "#{bookManagerService}")
	private BookManagerService bookManagerService = null;
	
	public void setBookManagerService(BookManagerService bookManagerService) {
		logger.debug("Injecting bookManagerService");
		this.bookManagerService = bookManagerService;
	}

	public CounterBean getCounter() {
		return counter;
	}

	public void setCounter(CounterBean counter) {
		logger.debug("Injecting the counter");
		this.counter = counter;
	}

	public List<Book> getBooks() throws Exception {
		logger.debug("Retrieving Books from Business Layer and incrementing the counter");
		counter.inc();
		return bookManagerService.getBooks();
	}

	public Book getSpecialOffer() throws Exception {
		logger.debug("Retrieving Special Offer from Business Layer");
		return bookManagerService.getSpecialOffer();
	}
	
}
