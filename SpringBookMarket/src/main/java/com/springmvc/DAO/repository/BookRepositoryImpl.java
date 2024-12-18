package com.springmvc.DAO.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.DTO.Book;
import com.springmvc.exception.BookIdException;

@Repository
public class BookRepositoryImpl implements BookRepository
{
	private JdbcTemplate template;
	
	@Autowired
	public void serJdbctemplate(DataSource dataSource)
	{
		System.out.println("template 객체 생성");
		this.template = new JdbcTemplate(dataSource);
	}
	
	public BookRepositoryImpl() 
	{ 
//		System.out.println("BookRepository 생성");
//		Book book1 = new Book("ISBN1234", "C# 교과서", 30000);
//		book1.setAuthor("박용준");
//		book1.setDescription("C# 교과서는 생애 첫 프로그래밍 언어로 C#을 시작하는 독자를 대상으로"
//				+ " 한다. 특히 응용 프로그래머를 위한 C# 입문서로, C#을 사용하여 게임(유니티), "
//				+ "웹, 모바일, IoT 등을 개발할 때 필요한 C# 기초 문법을 익히고 기본기를 탄탄하게 "
//				+ "다지는 것이 목적이다.");
//		book1.setPublisher("길벗");
//		book1.setCategory("IT전문서");
//		book1.setUnitsInStock(1000);
//		book1.setReleaseDate("2020/05/29");
//        
//		Book book2 = new Book("ISBN1235", "Node.js 교과서", 36000);
//		book2.setAuthor("조현영");
//		book2.setDescription("이 책은 프런트부터 서버, 데이터베이스, 배포까지 아우르는 광범위한 "
//				+ "내용을 다룬다. 군더더기 없는 직관적인 설명으로 기본 개념을 확실히 이해하고, 노드의"
//				+ " 기능과 생태계를 사용해 보면서 실제로 동작하는 서버를 만들어보자. 예제와 코드는 최신 "
//				+ "문법을 사용했고 실무에 참고하거나 당장 적용할 수 있다.");
//		book2.setPublisher("길벗");
//		book2.setCategory("IT전문서");
//		book2.setUnitsInStock(1000);
//		book2.setReleaseDate("2020/07/25");
//        
//		Book book3 = new Book("ISBN1236", "어도비 XD CC 2020", 25000);
//		book3.setAuthor("김두한");
//		book3.setDescription("어도비 XD 프로그램을 통해 UI/UX 디자인을 배우고자 하는 예비 "
//				+ "디자이너의 눈높이에 맞게 기본적인 도구를 활용한 아이콘 디자인과 웹&앱 페이지 "
//				+ "디자인, UI 디자인, 앱 디자인에 애니메이션과 인터랙션을 적용한 프로토타이핑을 "
//				+ "학습합니다.");
//		book3.setPublisher("길벗");
//		book3.setCategory("IT활용서");
//		book3.setUnitsInStock(1000);
//		book3.setReleaseDate("2019/05/29");
//        
//		listOfBooks.add(book1);
//		listOfBooks.add(book2);
//		listOfBooks.add(book3);
	}
	   
	@Override
	public List<Book> getAllBookList() 
	{
		System.out.println("------------------------------------------");
		System.out.println("BookRepositoryImpl.getAllBookList() 함수 입장");
		String SQL="select * from book";
		List<Book> listOfBooks = template.query(SQL, new BookRowMapper());
		System.out.println("DB 조회 완료, BookRepositoryImpl.getAllBookList() 퇴장");
		System.out.println("------------------------------------------");
		return listOfBooks;
	}

	@Override
	public List<Book> getBookListByCategory(String category) 
	{
		System.out.println("------------------------------------------");
		System.out.println("BookRepository.getBookListByCategory() 입장 : "+ category);
//		for(int i = 0; i < listOfBooks.size(); i++)
//		{
//			Book book = listOfBooks.get(i);
//			if(category.equalsIgnoreCase(book.getCategory()))
//			{
//				booksByCategory.add(book);
//			}
//		}
		List<Book> booksByCategory = new ArrayList<Book>();
		String sql = "select * from book where b_category like '%" + category + "%'";
		booksByCategory = template.query(sql, new BookRowMapper());
		System.out.println("BookRepository.getBookListByCategory() 퇴장 : "+ booksByCategory.getFirst().getBookId());
		System.out.println("------------------------------------------");

		return booksByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) 
	{
		System.out.println("------------------------------------------");
		System.out.println("Repository.getBookListByFilter() 함수 입장 : " + filter.toString());
//		if(booksByFilter.contains("publisher")) 
//		{
//			for(int j = 0; j < filter.get("publisher").size(); j++)
//			{
//				String publisherName = filter.get("publisher").get(j);
//				for(int i = 0; i < listOfBooks.size(); i++)
//				{
//					Book book = listOfBooks.get(i);
//					
//					if(publisherName.equalsIgnoreCase(book.getPublisher()))
//					{
//						booksByPublisher.add(book);
//					}
//				}
//			}
//		}
//		
//		if(booksByFilter.contains("category"))
//		{
//			for(int i = 0; i < filter.get("category").size(); i++)
//			{
//				String category = filter.get("category").get(i);
//				List<Book> list = getBookListByCategory(category);
//				booksByCategory.addAll(list);
//			}
//		}
//		booksByCategory.retainAll(booksByPublisher);
		Set<Book> booksByPublisher = new HashSet<Book>();
		Set<Book> booksByCategory = new HashSet<Book>();		
		Set<String> criterias = filter.keySet();
		
		if(criterias.contains("publisher")) 
		{
			for(int j = 0; j < filter.get("publisher").size(); j++)
			{
				String publisherName = filter.get("publisher").get(j);
				String sql = "select * from book where b_publisher like '%" + publisherName + "%'";
				booksByPublisher.addAll(template.query(sql, new BookRowMapper()));
			}
		}
		
		if(criterias.contains("category"))
		{
			for(int i = 0; i < filter.get("category").size(); i++)
			{
				String category = filter.get("category").get(i);
				String sql = "select * from book where b_category like '%" + category + "%'";
				booksByPublisher.addAll(template.query(sql, new BookRowMapper()));
			}
		}
		
		
		booksByCategory.retainAll(booksByPublisher);
		
		booksByCategory.retainAll(booksByPublisher);
		System.out.println("Repository.getBookListByFilter() 함수 퇴장 : " + booksByCategory.toString());
		System.out.println("------------------------------------------");

		
		return booksByCategory;
	}

	@Override
	public Book getBookById(String bookId)
	{
		System.out.println("------------------------------------------");
		System.out.println("Repository.getBookById 입장 : " + bookId);
//		for(int i = 0; i < listOfBooks.size(); i++)
//		{
//			Book book = listOfBooks.get(i);
//			if(book != null && book.getBookId() != null && book.getBookId().equalsIgnoreCase(bookId))
//			{
//				bookInfo = book;
//				break;
//			}
//		}
//		
		Book bookInfo = null;
		String SQL = "select count(*) from book where b_bookId=?";
		int rowCount = template.queryForObject(SQL, Integer.class, bookId);
		if(rowCount != 0)
		{
			SQL="select * from book where b_bookId=?";
			bookInfo = template.queryForObject(SQL, new Object[] {bookId}, new BookRowMapper());
		}
		
		if(bookInfo == null)
		{
			throw new BookIdException(bookId);
		}
		System.out.println("BookRepository.getBookById() 함수 퇴장 : " + bookInfo.getBookId());
		System.out.println("------------------------------------------");

		return bookInfo;
	}

	@Override
	public void setNewBook(Book book) 
	{
		System.out.println("------------------------------------------");
		System.out.println("bookRepository.setNewbook() 입장 : " + book.getCondition());

		String sql = "insert into book (b_bookId, b_name, b_unitPrice, b_author, b_description, b_publisher, b_category, b_unitsInStock, b_releaseDate, b_condition, b_fileName)" + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(sql, book.getBookId(), book.getName(), book.getUnitPrice(), book.getAuthor(), book.getDescription(), book.getPublisher(), book.getCategory(), book.getUnitsInStock(), book.getReleaseDate(), book.getCondition(), book.getFileName());
//		listOfBooks.add(book);
		
		System.out.println("bookRepository.setNewbook() 퇴장");
		System.out.println("------------------------------------------");
	}

	@Override
	public void setUpdateBook(Book book) 
	{
		if(book.getFileName() != null)
		{
			String SQL = "update book set b_name=?, b_unitPrice=?, b_author=?, b_description=?, b_publisher=?, b_category=?, b_unitsInStock=?, b_releaseDate=?, b_condition=?, b_fileName=? where b_bookId=?";
			template.update(SQL, book.getName(), book.getUnitPrice(), book.getAuthor(), book.getDescription(), book.getPublisher(), book.getCategory(), book.getUnitsInStock(), book.getReleaseDate(), book.getCondition(), book.getFileName(), book.getBookId());
		}
		else if(book.getFileName() == null)
		{
			String SQL = "update book set b_name=?, b_unitPrice=?, b_author=?, b_description=?, b_publisher=?, b_category=?, b_unitsInStock=?, b_releaseDate=?, b_condition=? where b_bookId=?";
			template.update(SQL, book.getName(), book.getUnitPrice(), book.getAuthor(), book.getDescription(), book.getPublisher(), book.getCategory(), book.getUnitsInStock(), book.getReleaseDate(), book.getCondition(), book.getBookId());
		}
	}

	@Override
	public void setDeleteBook(String bookId) 
	{
		String sql = "delete from book where b_bookId = ?";
		this.template.update(sql, bookId);
	}
	
}
