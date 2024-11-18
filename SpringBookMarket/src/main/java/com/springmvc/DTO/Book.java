package com.springmvc.DTO;

public class Book 
{
	private String bookId;
	private String name;
	private int unitPrice;
	private String author;
	private String description;
	private String publisher;
	private String category;
	private int unitsInStock;
	private String releaseDate;
	private String condition;
	
	public Book() 
	{
		System.out.println("주문하신 빈 DTO.Book 나왔습니다.");
	}
	
	public Book(String bookId, String name, Integer unitPrice) 
	{
		System.out.println("주문하신 DTO.Book 나왔습니다.");
		this.bookId = bookId;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(Integer i) {
		this.unitsInStock = i;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
}
