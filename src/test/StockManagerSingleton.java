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
    public boolean updateItemPrice(MediaProduct product, double newPrice)
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
                        product1.setPrice(newPrice);
                        
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
    

	
	//Gets the media products that are below the given maxPrice
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice)
	{
		ArrayList<MediaProduct> list= new ArrayList<MediaProduct>();
		return list;
	}
	
	//Gets the CD products that are below the given maxPrice
	//need to create CDRecordProduct
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList)
	{
		ArrayList<CDRecordProduct> list= new ArrayList<CDRecordProduct>();
		return list;
	}
	
	//Gets the CD products that are below the given maxPrice
	//need to create TapeRecordProduct
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList)
	{
		ArrayList<TapeRecordProduct> list= new ArrayList<TapeRecordProduct>();
		return list;
	}

	public String getInventoryFilePath() {
		return inventoryFilePath;
	}

	public Map<String, MediaProduct> getInventory() {
		return inventory;
	}

	public void setInventory(Map<String, MediaProduct> inventory) {
		this.inventory = inventory;
	}
	
}