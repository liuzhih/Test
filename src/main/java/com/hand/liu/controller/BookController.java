package com.hand.liu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hand.liu.model.Book;
import com.hand.liu.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "addBook", method = RequestMethod.POST)
	public String  addBook(Book book ,String time) throws UnsupportedEncodingException{
		System.out.println("222222222222");
		String name = new String(book.getbName().getBytes("ISO8859-1"),"UTF-8");
		String type = new String(book.getbType().getBytes("ISO8859-1"),"UTF-8");
		String author = new String(book.getbAuthor().getBytes("ISO8859-1"),"UTF-8");
		book.setbName(name);
		System.out.println(name);
		book.setbAuthor(author);
		book.setbType(type);
		 try {
		    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				Date date = sdf.parse(time);
				book.setbDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		try {
			bookService.addBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	@RequestMapping(value = "updateBook", method = RequestMethod.POST)
	public String updateBook (Book book,String time){
		System.out.println(time);
		 
	    try {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date date = sdf.parse(time);
			book.setbDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		try {
			
			bookService.updateBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "findBookById", method = RequestMethod.GET)
	public void  findBookById(HttpServletResponse resp, int bId){
		
		Book b = null;
		try {
			b = bookService.findBookById(bId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jo = JSON.toJSONString(b);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		
		try {
			out = resp.getWriter();
			out.print(jo);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "deleteBook", method = RequestMethod.GET)
	public String deleteBook(int bId){
		System.out.println(bId);
		try {
			bookService.deleteBook(bId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "queryBook", method = RequestMethod.POST)
	public void queryBook(HttpServletResponse resp){
		System.out.println("查询书籍");
		List<Book> bl = null;
		try {
			bl = bookService.queryAllBook();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String jo = JSON.toJSONString(bl);
		
		System.out.println(jo);
		  
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		
		try {
			out = resp.getWriter();
			out.print(jo);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "queryTypeBook", method = RequestMethod.POST)
	public void queryTypeBook(HttpServletResponse resp,String bType){
		System.out.println("查询书籍");
		List<Book> bl = null;
		try {
			bl = bookService.findBookByType(bType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String jo = JSON.toJSONString(bl);
		
		System.out.println(jo);
		  
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		
		try {
			out = resp.getWriter();
			out.print(jo);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
