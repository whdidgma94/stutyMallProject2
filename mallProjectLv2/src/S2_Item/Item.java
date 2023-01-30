package S2_Item;

public class Item {
	private String name;
	private int price;	
	
	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[" + name + "] " + price + " 원";
	}
	
}
