package S1_Member;


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
		stat = getMemberDAO().login(id, pw);
		if(stat==-1) {
			System.err.println("로그인 실패");
		}
		return stat;
	}
	public void join() {
		String id = Util.getString("아이디");
		if(getMemberDAO().checkId(id)) {
			System.err.println("이미 존재하는 아이디 입니다.");
			return;
		}
		String pw = Util.getString("비밀번호");
		String name = Util.getString("이름");
		Member member = new Member(id,pw,name);
		memberDAO.addMember(member);
	}
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}
	
	public void memberMenu() {
		while(true) {
			System.out.println("[1.쇼핑] [2.장바구니] [3.게시판] [0.뒤로가기]");
			int sel = Util.getInt(0, 3);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				itemController.buyItem();
			} else if (sel == 2) {
				cartController.cartMenu();
			} else if (sel == 3) {
				boardController.boardMenu();
			}
		}
	}
	
}
