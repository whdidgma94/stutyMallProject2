package S5_Admin;


import S1_Member.MemberController;
import S2_Item.ItemController;
import S3_Cart.CartController;
import S_Util.Util;

public class AdminController {
	private AdminController() {}
	static private AdminController instance = new AdminController();
	static public AdminController getInstance() {
		return instance;
	}
	
	ItemController itemController = ItemController.getInstance();
	MemberController memberController = MemberController.getInstance();
	CartController cartController = CartController.getInstance();
	
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
	
	void memberManeger() {
		while(true) {
		System.out.println("[1.회원 목록] [2.장바구니 목록] [0.뒤로가기]");
		int sel = Util.getInt(0, 2);
		if (sel == 0) {
			break;
		} else if (sel == 1) {
			memberController.printMember();
		} else if (sel == 2) {
			cartController.printAllCart();
		}
	}
}
	
	public void adminMenu() {
		
		while (true) {
			System.out.println("[1.회원관리] [2.상품관리] [0.뒤로가기]");
			int sel = Util.getInt(0, 3);
			if(sel==0) {
				break;
			} else if (sel == 1) {
				memberManeger();
			} else if (sel == 2) {
				itemManeger();
			}

		}
	}
}
