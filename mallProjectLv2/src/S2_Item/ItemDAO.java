package S2_Item;

import java.util.ArrayList;

public class ItemDAO {
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	void addItem(Item item) {
		itemList.add(item);
	}
	void removeItem(Item item) {
		itemList.remove(item);
	}
	void setSampleItem() {
		Item sample1 = new Item("새우깡",1000);
		Item sample2 = new Item("감자깡",1500);
		Item sample3 = new Item("옥수수깡",2000);
		addItem(sample1);
		addItem(sample2);
		addItem(sample3);
	}

}
