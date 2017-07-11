package com.hand.liu.dao;

import java.util.List;

import com.hand.liu.model.Book;


public interface BookDao {

			//添加书籍
			public void addBook(Book book) ;
			//更改书籍信息
			public void updateBook(Book book);
			//删除书籍
			public void deleteBook(int bId);
			//查询所有书籍
			public List<Book> queryAllBook();
			// 借书
			public void borrowBook(int bId);
			//按照Id查询书籍
			public Book findBookById(int bId);
			//按照类型查询书籍 
			public List<Book> findBookByType(String bType);
}
