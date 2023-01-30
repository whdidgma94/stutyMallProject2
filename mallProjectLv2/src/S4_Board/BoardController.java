package S4_Board;

import S0_Main.MainController;
import S1_Member.MemberController;
import S_Util.Util;

public class BoardController {
	private BoardDAO boardDAO = new BoardDAO();
	private MemberController memberController = MemberController.getInstance();
	private BoardController() {}
	static private BoardController instance = new BoardController();
	static public BoardController getInstance() {
		return instance;
	}
	
	void showBoard() {
		boardDAO.printBoard();
	}
	void addBoard() {
		String title = Util.getString("제목");
		String content = Util.getString("내용");
		String name = memberController.getMemberDAO().getMemberList().get(MainController.getStat()).getId();
		Board board = new Board(title,content,name);
		boardDAO.addBoard(board);
	}
	void removeBoard() {
		
	}
	
	public void boardMenu() {
		while(true) {
			System.out.println("[1.게시글 목록] [2.게시글 작성] [3.게시글 삭제] [0.뒤로 가기]");
			int sel = Util.getInt(0, 3);
			if(sel==0) {
				break;
			} else if (sel == 1) {
				showBoard();
			} else if (sel == 2) {
				addBoard();
			} else if (sel == 3) {
				removeBoard();
			}
		}
	}
	
	
}
