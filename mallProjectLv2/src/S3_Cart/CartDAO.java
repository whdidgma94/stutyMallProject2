package S3_Cart;

import java.util.ArrayList;

public class CartDAO {
	private ArrayList<Cart> cartList = new ArrayList<Cart>();

	public ArrayList<Cart> getCartList() {
		return cartList;
	}
	
	void addCart(Cart cart) {
		cartList.add(cart);
	}
	
}
