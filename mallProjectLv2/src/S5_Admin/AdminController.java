package S5_Admin;


import S2_Item.ItemController;
import S_Util.Util;

public class AdminController {
	private AdminController() {}
	static private AdminController instance = new AdminController();
	static public AdminController getInstance() {
		return instance;
	}
	
	ItemController itemController = ItemController.getInstance();

	void itemManeger() {
		while (true) {
			System.out.println("[1.상품 추가] [2.상품 삭제] [3.상품 출력] [0.뒤로가기]");
			int sel = Util.getInt(0, 3);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				itemController.addItem();
			} else if (sel == 2) {
				itemController.removeItem();
			} else if (sel == 3) {
				itemController.printItemList();
			}
		}
	}

	public void adminMenu() {
		
		while (true) {
			System.out.println("[1.회원관리] [2.상품관리] [3.장바구니관리] [0.뒤로가기]");
			int sel = Util.getInt(0, 3);
			if(sel==0) {
				break;
			} else if (sel == 1) {
				
			} else if (sel == 2) {
				itemManeger();
			} else if (sel == 3) {
				
			}

		}
	}
}
