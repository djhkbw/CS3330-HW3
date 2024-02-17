package test;

public class MediaProduct {
	
	private String title;
	private double price;
	private int year;
	private Genre Genre;
	
	enum Genre {
		ROCK,
		POP,
		JAZZ,
		CLASSICAL,
		HIP_HOP,
		ELECTRONIC,
		CHILDREN
	}
	public MediaProduct(String title, double price, int year,Genre genre) {
		this.title = title;
		this.price = price;
		this.year = year;
		this.Genre = genre;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public Genre getGenre() {
		return this.getGenre();
	}
	
	public void setGenre(Genre genre) {
		this.Genre = genre;
	}
}