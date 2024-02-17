package test;
import java.util.*;
import java.util.ArrayList;

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
	public boolean initializeStock()
	{
		return true;
	}
	
	//updates the price of a media product
	public boolean updateItemPrice(MediaProduct product, double newPrice)
	{
		return true;
	}
	
	//adds an item to the file
	public boolean addItem(MediaProduct product)
	{
		return true;
	}
	
	//removes item from the file
	public boolean removeItem(MediaProduct product)
	{
		return true;
	}
	
	//Saves the updated inventory back to the CSV file
	public boolean saveStock()
	{
		return true;
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