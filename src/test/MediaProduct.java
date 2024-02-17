package test;

public class MediaProduct {
	
	private String title;
	private double price;
	private int year;
	
	public MediaProduct(String title, double price, int year) {
		this.title = title;
		this.price = price;
		this.year = year;
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
	
}