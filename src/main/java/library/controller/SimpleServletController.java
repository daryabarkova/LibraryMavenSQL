package library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.action.BaseAction;
import library.bean.Book;
import library.dao.BookDao;
import library.dao.file.simple.SimpleBookDaoImpl;

/**
 * Servlet implementation class SimpleServletController
 */
public class SimpleServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao dao = new SimpleBookDaoImpl();

    /**
     * Default constructor. 
     */
    public SimpleServletController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Hello World");
		
		List<Book> books = dao.readAll();
		response.getWriter().append(books.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
