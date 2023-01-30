package S3_Cart;

public class Cart {
	private int num;
	private String itemName;
	private int price;
	
	public Cart(int num, String itemName, int price) {
		super();
		this.num = num;
		this.itemName = itemName;
		this.price = price;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return itemName + " : " + price + "원";
	}
}
