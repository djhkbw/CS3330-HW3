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
        /* ALTERNATE MAIN -> that we cannot test because it cannot
         * find or load main class
         * 
         * // Get the instance of StockManagerSingleton
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
} */
}}