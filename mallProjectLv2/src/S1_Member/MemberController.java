package S1_Member;


import S0_Main.MainController;
import S2_Item.ItemController;
import S3_Cart.CartController;
import S4_Board.BoardController;
import S_Util.Util;

public class MemberController {
	
	private MemberDAO memberDAO= new MemberDAO();
	private ItemController itemController = ItemController.getInstance();
	private CartController cartController = CartController.getInstance();
	private BoardController boardController = BoardController.getInstance();
	private MemberController() {}
	static private MemberController instance = new MemberController();
	static public MemberController getInstance() {
		return instance;
	}
	
	
	public int login() {
		int stat=-1;
		String id = Util.getString("아이디");
		String pw = Util.getString("비밀번호");
		stat = memberDAO.login(id, pw);
		if(stat==-1) {
			System.err.println("로그인 실패");
		}
		return stat;
	}
	public void join() {
		String id = Util.getString("아이디");
		if(memberDAO.checkId(id)) {
			System.err.println("이미 존재하는 아이디 입니다.");
			return;
		}
		String pw = Util.getString("비밀번호");
		String name = Util.getString("이름");
		Member member = new Member(id,pw,name);
		memberDAO.addMember(member);
	}

	
	public void setAdmin() {
		memberDAO.setAdmin();
	}
	
	public void printMember () {
		int idx = 1;
		for(Member member : memberDAO.getMemberList()) {
			if (!member.getId().equals("ad")) {
				System.out.println("[" + idx + "] " + member);
				idx++;
			}
		}
		memberManager();
	}
	
	private void memberManager() {
		if(memberDAO.getMemberList().size()==1) {
			System.err.println("회원이 없습니다");
			return;
		}
		System.out.print("회원 번호 ");
		int sel = Util.getInt(1, memberDAO.getMemberList().size() - 1);
		System.out.print("입금액 ");
		int money = Util.getInt(0, 100000) + memberDAO.getMemberList().get(sel).getCash();
		memberDAO.getMemberList().get(sel).setCash(money);
	}
	public int getCurMember() {
		return MainController.getStat();
	}
	public String getMemberId() {
		return memberDAO.getCurrentMemberId(getCurMember());
	}
	public int getMemberCash() {
		return memberDAO.getMemberList().get(getCurMember()).getCash();
	}
	public void setMemberCash(int money) {
		memberDAO.getMemberList().get(getCurMember()).setCash(money);		
	}
	public void addbuyList(String item) {
		memberDAO.getMemberList().get(getCurMember()).getBuyList().add(item);
		
	}
	private void printBuyList() {
		for(String item : memberDAO.getMemberList().get(getCurMember()).getBuyList()) {
			System.out.println(item);
		}
	}
	public void memberMenu() {
	
		while (true) {
			System.out.println("[1.쇼핑] [2.장바구니] [3.게시판] [4.구매 내역] [0.뒤로가기]");
			int sel = Util.getInt(0, 4);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				itemController.buyItem();
			} else if (sel == 2) {
				cartController.cartMenu();
			} else if (sel == 3) {
				boardController.boardMenu();
			} else if (sel == 4) {
				printBuyList();
			}
		}
	}


	
}
