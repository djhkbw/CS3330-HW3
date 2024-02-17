package test;


public class TapeRecordProduct extends MediaProduct {
	
    public TapeRecordProduct(String title, double price, int year, Genre genre) {
        super(title, price, year, genre);
    }

    // Copy constructor
    public TapeRecordProduct(TapeRecordProduct other) {
        super(other);
    }
}