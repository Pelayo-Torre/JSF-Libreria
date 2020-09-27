package com.miw.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.miw.model.Book;
import com.miw.model.ShoppingCart;
import com.miw.presentation.book.BookManagerServiceHelper;

@ManagedBean(name = "addCart", eager = true)
@SessionScoped
public class AddCartBean {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@ManagedProperty(value = "#{bookManagerServiceHelper}")
	private BookManagerServiceHelper helper;
	
	//En esta lista se almacenan los identificadores de los libros seleccionados por el usuario en el formulario
	List<String> selectedBooks = new ArrayList<String>();
	
	
	ShoppingCart carrito = null;
	
	public String librosSeleccionados() throws Exception {
		if(carrito == null)
			carrito = new ShoppingCart();
		
		for(String id : this.selectedBooks) {
			String name = getNameOfBookByIdentifier(id);
			if(name != null)
				carrito.add(name);
		}
		
		this.selectedBooks = new ArrayList<String>();
		return "success";
	}

	public String getNameOfBookByIdentifier(String id) throws Exception {
		for(Book b : (List<Book>) helper.getBooks()) {
			if(b.getId() == Integer.parseInt(id))
				return b.getTitle();
		}
		return null;
	}
	
	public List<String> getSelectedBooks() {
		return selectedBooks;
	}

	public void setSelectedBooks(List<String> selectedBooks) {
		this.selectedBooks = selectedBooks;
	}

	public BookManagerServiceHelper getHelper() {
		return helper;
	}

	public void setHelper(BookManagerServiceHelper helper) {
		this.helper = helper;
	}

	public ShoppingCart getCarrito() {
		return carrito;
	}

	public void setCarrito(ShoppingCart carrito) {
		this.carrito = carrito;
	}
	

}
