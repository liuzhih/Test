package com.hand.liu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.liu.dao.BookDao;
import com.hand.liu.model.Book;
import com.hand.liu.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.addBook(book);
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.updateBook(book);
	}

	public void deleteBook(int bId) {
		// TODO Auto-generated method stub
		bookDao.deleteBook(bId);
	}

	public List<Book> queryAllBook() {
		// TODO Auto-generated method stub
		return bookDao.queryAllBook();
	}

	public void borrowBook(int bId) {
		// TODO Auto-generated method stub
		bookDao.borrowBook(bId);
	}

	public Book findBookById(int bId) {
		// TODO Auto-generated method stub
		return bookDao.findBookById(bId);
	}

	public List<Book> findBookByType(String bType) {
		// TODO Auto-generated method stub
		return bookDao.findBookByType(bType);
	}

}
