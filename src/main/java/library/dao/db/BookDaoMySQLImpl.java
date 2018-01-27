package library.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import library.bean.Book;
import library.dao.BookDao;

public class BookDaoMySQLImpl implements BookDao {

	@Override
	public void create(Book t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Book t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Book t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> readAll() {
		
		List<Book> list = new ArrayList<>();
		
		ResourceBundle rb = ResourceBundle.getBundle("db_config");
		
		String dbURL = rb.getString("db_url");
	    String user = rb.getString("db_login");
	    String pass = rb.getString("db_pass");
	    
	    String driver = rb.getString("db.driver");
		
		Connection cn = null;
		
		try {
			
			try {
				Class.forName(driver);
			
			
			cn = DriverManager.getConnection(dbURL, user, pass);
			System.out.println("connected");
			
			Statement st = cn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * from books;");
			
			Book book = new Book();
			
			while(rs.next()){
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				rs.getInt("authorId");
				//rs.getDate("year");
			}
			
			list.add(book);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try{
				if(cn != null) {
				cn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return list;
 		
  }
}

