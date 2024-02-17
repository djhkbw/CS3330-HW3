package test;

public class CDRecordProduct extends MediaProduct {
	
	public CDRecordProduct(String title, double price, int year) {
		super(title, price, year);
	}
	
	public CDRecordProduct(CDRecordProduct CD) {
		super(CD.title, CD.price, CD.year);
	}
}