package S2_Item;

import java.util.Scanner;

import S0_Main.MainController;
import S3_Cart.CartController;
import S_Util.Util;

public class ItemController {
	Scanner scan = Util.scan;
	private ItemDAO itemDAO = new ItemDAO();
	private CartController cartController = CartController.getInstance();
	private ItemController() {
		itemDAO.setSampleItem();
	}
	static private ItemController instance = new ItemController();
	static public ItemController getInstance() {
		return instance;
	}
	public void addItem() {
		String name = Util.getString("상품 이름 ");
		int price = Integer.parseInt(Util.getString("상품 가격"));
		Item item = new Item(name, price);
		itemDAO.addItem(item);
	}
	public void removeItem() {
		printItemList();
		System.out.print("삭제할 상품 번호 ");
		int sel=Util.getInt(1, itemDAO.getItemList().size());
		Item item = itemDAO.getItemList().get(sel-1);
		itemDAO.removeItem(item);
	}
	public void printItemList() {
		int cnt=1;
		for(Item item :itemDAO.getItemList()) {
			System.out.println(cnt+". "+item);		
			cnt++;
		}
	}
	public void buyItem() {
		if(itemDAO.getItemList().size()==0) {
			System.err.println("[구매가능한 상품이 없습니다]");
			return;
		}		
		printItemList();
		int sel=Util.getInt(1, itemDAO.getItemList().size());
		Item item = itemDAO.getItemList().get(sel-1);
		cartController.addCart(MainController.getStat(),item);
	}


}
