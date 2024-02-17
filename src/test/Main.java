package test;
import java.util.ArrayList;


public class Main {

	    public static void main(String[] args) {
	        // Get the instance of StockManagerSingleton
	        StockManagerSingleton stockManager = StockManagerSingleton.getInstance();
	        
	        // Initialize the stock
	        boolean initializationSuccess = stockManager.initializeStock();
	        System.out.println("Initialization successful: " + initializationSuccess);
	        
	        // Update item price
	        MediaProduct productToUpdate = new MediaProduct("TitleToUpdate", 15.99, 2023, Genre.ROCK);
	        boolean updateSuccess = stockManager.updateItemPrice(productToUpdate, 19.99);
	        System.out.println("Update successful: " + updateSuccess);
	        
	        // Add item
	        MediaProduct productToAdd = new MediaProduct("NewTitle", 24.99, 2022, Genre.POP);
	        boolean addSuccess = stockManager.addItem(productToAdd);
	        System.out.println("Add successful: " + addSuccess);
	        
	        // Remove item
	        MediaProduct productToRemove = new MediaProduct("TitleToRemove", 9.99, 2021, Genre.JAZZ);
	        boolean removeSuccess = stockManager.removeItem(productToRemove);
	        System.out.println("Remove successful: " + removeSuccess);
	        
	        // Save stock
	        boolean saveSuccess = stockManager.saveStock();
	        System.out.println("Save successful: " + saveSuccess);
	        
	        // Get media products below a certain price
	        ArrayList<MediaProduct> belowPriceList = stockManager.getMediaProductBelowPrice(20);
	        System.out.println("Media products below price 20:");
	        stockManager.printListOfMediaProduct(belowPriceList);
	        
	        // Get vinyl record list
	        ArrayList<VinylRecordProduct> vinylRecordList = stockManager.getVinylRecordList(stockManager.getInventory());
	        System.out.println("Vinyl record list:");
	        stockManager.printListOfMediaProduct(vinylRecordList);
	        
	        // Get CD record list
	        ArrayList<CDRecordProduct> cdRecordsList = stockManager.getCDRecordsList(stockManager.getInventory());
	        System.out.println("CD record list:");
	        stockManager.printListOfMediaProduct(cdRecordsList);
	        
	        // Get tape record list
	        ArrayList<TapeRecordProduct> tapeRecordList = stockManager.getTapeRecordList(stockManager.getInventory());
	        System.out.println("Tape record list:");
	        stockManager.printListOfMediaProduct(tapeRecordList);
	    }
	

}
