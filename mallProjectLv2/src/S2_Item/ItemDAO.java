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
}
