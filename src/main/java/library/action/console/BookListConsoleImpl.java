package library.action.console;

import java.util.List;

import library.action.BaseAction;
import library.bean.Book;
import library.dao.BookDao;
import library.dao.db.BookDaoMySQLImpl;
import library.dao.file.simple.SimpleBookDaoImpl;

public class BookListConsoleImpl implements BaseAction{
	
	//private BookDao dao = new SimpleBookDaoImpl();
	
	private BookDao dao = new BookDaoMySQLImpl();


	@Override
	public void doSmth() {
		List <Book> books = dao.readAll();
		
		if(books != null){
		for (Book book : books){
			System.out.println(book);
		}
		}else{
			System.out.println("Library is empty");
		}
	}

}
