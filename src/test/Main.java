package test;

public class Main {
	public static void main(String[] args) {
        StockManagerSingleton stockManager = StockManagerSingleton.getInstance();
        // Use stockManager to manage inventory
        boolean success = stockManager.initializeStock();
        
        if (success) {
        	System.out.println("inventory data read");
            stockManager.addItem(new MediaProduct("Generic Rock Song", 19.99, 1999, MediaProduct.Genre.ROCK));
            stockManager.updateItemPrice(new MediaProduct("Generic Rock Song", 19.99, 1999, MediaProduct.Genre.ROCK), 13.29);
            stockManager.removeItem(new MediaProduct("Generic Rock Song", 19.99, 1999, MediaProduct.Genre.ROCK));
            stockManager.saveStock();
        	stockManager.getInventoryFilePath();
            stockManager.getInventory();
            stockManager.setInventory(null);
            stockManager.getMediaProductBelowPrice(0);
            stockManager.getCDRecordsList(null);
            stockManager.getTapeRecordList(null);
        } else {
        	System.out.println("Failed to read inventory data");
        }
    }
}
