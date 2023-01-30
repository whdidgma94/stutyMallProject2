package S4_Board;

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
	void addBoard(String name) {
		String title = Util.getString("제목");
		String content = Util.getString("내용");
	
		Board board = new Board(title,content,name);
		boardDAO.addBoard(board);
	}
	void removeBoard(String name) {	
		System.out.print("삭제할 게시물 번호");
		int sel = Util.getInt(1, boardDAO.getBoardList().size());
		if(!boardDAO.getBoardList().get(sel-1).getUserName().equals(name)) {
			System.err.println("[본인의 게시물이 아닙니다]");
			return;
		}
		Board board = boardDAO.getBoardList().get(sel-1);
		boardDAO.removeBoard(board);
	}
	
	
	
	public void boardMenu() {
		if(memberController == null) {
			memberController = MemberController.getInstance();
		}
		while(true) {
			String name = memberController.getMemberId();
			System.out.println("[1.게시글 목록] [2.게시글 작성] [3.게시글 삭제] [0.뒤로 가기]");
			int sel = Util.getInt(0, 3);
			if(sel==0) {
				break;
			} else if (sel == 1) {
				showBoard();
			} else if (sel == 2) {
				addBoard(name);
			} else if (sel == 3) {
				removeBoard(name);
			}
		}
	}
	
	
}
