package S3_Cart;

import java.util.Scanner;

import S0_Main.MainController;
import S2_Item.Item;
import S_Util.Util;

public class CartController {
	Scanner scan = Util.scan;
	private CartDAO cartDAO = new CartDAO();
	private CartController() {}
	static private CartController instance = new CartController();
	static public CartController getInstance() {
		return instance;
	}
	void printCart(int num) {
		int cnt=1;
		for(Cart cart : cartDAO.getCartList()) {
			if(cart.getNum()==num) {
				System.out.println(cnt+". "+cart);
				cnt++;
			}
		}
		if(cnt==1) {
			System.out.println("[장바구니가 비었습니다]");
		}
	}
	
	public void printAllCart() {
		int cnt = 1;
		for (Cart cart : cartDAO.getCartList()) {
			System.out.println(cnt + ". " + cart);
			cnt++;
		}
		if (cnt == 1) {
			System.out.println("[장바구니가 비었습니다]");
		}
	}
	
	void removeCart(int num) {
		printCart(MainController.getStat());
		int input = Util.getInt(0, cartDAO.getCartList().size());
		int cnt=1;
		for(Cart cart : cartDAO.getCartList()) {
			if(cart.getNum()==num) {
				if(cnt==input) {
					cartDAO.getCartList().remove(cart);
					return;
				}
				System.out.println(cnt+". "+cart);
				cnt++;
			}
		}
	}
	
	void clearCart(int num) {
		for(Cart cart : cartDAO.getCartList()) {
			if(cart.getNum()==num) {
				cartDAO.getCartList().remove(cart);
			}
		}
	}
	
	public void addCart(int stat, Item item) {
		Cart cart = new Cart(stat, item.getName(), item.getPrice());
		cartDAO.addCart(cart);
	}

	public void cartMenu() {
		while(true) {
			System.out.println("[1]장바구니출력 [2]구입 [3]삭제 [0]뒤로가기");
			int sel = Util.getInt(0, 3);
			if(sel==0) {
				break;
			}else if(sel==1) {
				printCart(MainController.getStat());
			}else if(sel==2) {
				clearCart(MainController.getStat());
			}else if(sel==3) {
				removeCart(MainController.getStat());
			}
		}
		
	}

}
