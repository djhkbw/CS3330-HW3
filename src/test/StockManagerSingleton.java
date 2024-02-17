package test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import test.MediaProduct.Genre;

public class StockManagerSingleton
{
	private static StockManagerSingleton instance = null;
	
	private final String inventoryFilePath;
	private Map<String, MediaProduct> inventory;
	
	private StockManagerSingleton() {
        inventoryFilePath = "inventory.csv"; // Initialize inventoryFilePath in the constructor
        setInventory(new HashMap<>());
    }
	
	public static synchronized StockManagerSingleton getInstance()
	{
		if(instance == null) {
		instance = new StockManagerSingleton();
		}
		return instance;
		
	}
	
	//reads the inventory data from file
	public boolean initializeStock() {
	    try (BufferedReader reader = new BufferedReader(new FileReader(inventoryFilePath))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(",");
	            if (parts.length == 4) { // Assuming CSV format: title,price,year,genre
	                String title = parts[0].trim();
	                double price = Double.parseDouble(parts[1].trim());
	                int year = Integer.parseInt(parts[2].trim());
	                Genre genre = Genre.valueOf(parts[3].trim());
	                MediaProduct product = new MediaProduct(title, price, year, genre);
	                inventory.put(title, product);
	            }
	        }
	        return !inventory.isEmpty(); // Return true if inventory is not empty
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false; // Return false if an exception occurs (file not found, etc.)
	    }
	}
		//updates the price of a media product
		public boolean updateItemPrice(MediaProduct product, double newPrice) {
			// Check if the product exists in the inventory
			if (inventory.containsKey(product.getTitle())) {
				// Update the price of the product
				product.setPrice(newPrice);
				return true; // Return true indicating successful update
			}
			return false; // Return false if the product does not exist in the inventory
		}


    //adds an item to the file
    public boolean addItem(MediaProduct product)
    {
        try( BufferedReader reader = new BufferedReader(new FileReader(inventoryFilePath)))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                if(parts.length == 4)
                {
                    String title = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    int year = Integer.parseInt(parts[2].trim());
                    Genre genre = Genre.valueOf(parts[3].trim());
                    MediaProduct product1 = new MediaProduct(title, price, year, genre);
                    if(product1.equals(product))
                    {
                        return false;
                    }
                }
                
            }
            return true;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }


    //removes item from the file
    public boolean removeItem(MediaProduct product)
    {
        try( BufferedReader reader = new BufferedReader(new FileReader(inventoryFilePath)))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                if(parts.length == 4)
                {
                    String title = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    int year = Integer.parseInt(parts[2].trim());
                    Genre genre = Genre.valueOf(parts[3].trim());
                    MediaProduct product1 = new MediaProduct(title, price, year, genre);
                    if(product1.equals(product))
                    {
                        inventory.remove(product1);
                        return true;
                    }
                }
                
            }
            return false;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
	    //Saves the updated inventory back to the CSV file
		public boolean saveStock()
		{
			try( BufferedReader reader = new BufferedReader(new FileReader(inventoryFilePath)))
			{
				String line;
				while((line = reader.readLine()) != null)
				{
					String[] parts = line.split(",");
					if(parts.length == 4)
					{
						String title = parts[0].trim();
						double price = Double.parseDouble(parts[1].trim());
						int year = Integer.parseInt(parts[2].trim());
						Genre genre = Genre.valueOf(parts[3].trim());
						MediaProduct product1 = new MediaProduct(title, price, year, genre);
						inventory.put(title, product1);
					}
					
				}
				return true;
			}
			catch(IOException e)
			{
				e.printStackTrace();
				return false;
			}
		}
    

	
	//Gets the media products that are below the given maxPrice
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice) {
		    ArrayList<MediaProduct> belowPriceList = new ArrayList<>();
		    for (MediaProduct product : inventory.values()) {
		        if (product.getPrice() < maxPrice) {
		            // Add the product to the belowPriceList if its price is below maxPrice
		            belowPriceList.add(product);
		        }
		    }
		    // Return the ArrayList of media products below the maxPrice
		    return belowPriceList;
		}

	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
		    for (MediaProduct product : productList) {
		        System.out.println(product); // Assuming MediaProduct class overrides toString() method
		    }
		}

	//Gets the vinyl products that are below the given maxPrice
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList) {
	    ArrayList<VinylRecordProduct> vinylRecordList = new ArrayList<>();
	    for (MediaProduct product : productList) {
	        if (product instanceof VinylRecordProduct) {
	            // Check if the product is an instance of VinylRecordProduct
	            vinylRecordList.add((VinylRecordProduct) product);
	        }
	    }
	    return vinylRecordList;
	}

	//Gets the CD products that are below the given maxPrice
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList) {
	    ArrayList<CDRecordProduct> cdRecordsList = new ArrayList<>();
	    for (MediaProduct product : productList) {
	        if (product instanceof CDRecordProduct) {
	            // Check if the product is an instance of CDRecordProduct
	            cdRecordsList.add((CDRecordProduct) product);
	        }
	    }
	    return cdRecordsList;
	}

	
	//Gets the tape products that are below the given maxPrice
	//need to create TapeRecordProduct
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList) {
	    ArrayList<TapeRecordProduct> tapeRecordList = new ArrayList<>();
	    for (MediaProduct product : productList) {
	        if (product instanceof TapeRecordProduct) {
	            // Check if the product is an instance of TapeRecordProduct
	            tapeRecordList.add((TapeRecordProduct) product);
	        }
	    }
	    return tapeRecordList;
	}


	public String getInventoryFilePath() {
		try( BufferedReader reader = new BufferedReader(new FileReader(inventoryFilePath)))
		{
			String line;
			while((line = reader.readLine()) != null)
			{
				String[] parts = line.split(",");
				if(parts.length == 4)
				{
					String title = parts[0].trim();
					double price = Double.parseDouble(parts[1].trim());
					int year = Integer.parseInt(parts[2].trim());
					Genre genre = Genre.valueOf(parts[3].trim());
					MediaProduct product1 = new MediaProduct(title, price, year, genre);
					inventory.put(title, product1);
				}
				
			}
			return inventoryFilePath;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, MediaProduct> getInventory() {
		try( BufferedReader reader = new BufferedReader(new FileReader(inventoryFilePath)))
		{
			String line;
			while((line = reader.readLine()) != null)
			{
				String[] parts = line.split(",");
				if(parts.length == 4)
				{
					String title = parts[0].trim();
					double price = Double.parseDouble(parts[1].trim());
					int year = Integer.parseInt(parts[2].trim());
					Genre genre = Genre.valueOf(parts[3].trim());
					MediaProduct product1 = new MediaProduct(title, price, year, genre);
					inventory.put(title, product1);
				}
				
			}
			return inventory;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public void setInventory(Map<String, MediaProduct> inventory) {
		this.inventory = inventory;
	}
	
}