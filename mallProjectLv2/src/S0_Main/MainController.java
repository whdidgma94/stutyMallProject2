package S0_Main;


import S1_Member.MemberController;
import S5_Admin.AdminController;
import S_Util.Util;

public class MainController {
	
	private MemberController memberController;
	private AdminController adminController;
	private static int stat=-1;
	public static int getStat() {
		return stat;
	}
	
	MainController(){
		memberController = MemberController.getInstance();
		adminController = AdminController.getInstance();
	}
	void printMainMenu() {
		System.out.println("[1]로그인 [2]회원가입 [0]종료");
	}
	
	void run() {
		memberController.getMemberDAO().setAdmin();
		while (true) {
			if (stat == -1) {
				printMainMenu();
				int sel = Util.getInt(0, 2);
				if (sel == 0) {
					break;
				} else if (sel == 1) {
					stat = memberController.login();
				} else if (sel == 2) {
					memberController.join();
				}
			} else if (stat == 0) {
				adminController.adminMenu();
				stat=-1;
			} else {
				memberController.memberMenu();
				stat=-1;
			}			
		}
		Util.scan.close();
	}
}
