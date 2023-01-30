package S4_Board;

import java.util.ArrayList;

import S_Util.Util;

public class BoardDAO {
	private ArrayList<Board> boardList = new ArrayList<Board>();
	
	public ArrayList<Board> getBoardList() {
		return boardList;
	}
	void addBoard(Board board) {
		boardList.add(board);
	}
	void removeBoard(Board board) {
		boardList.remove(board);
	}
	void printBoard() {
		int cnt=1;
		for(Board board : boardList) {
			System.out.println(cnt+". "+board.getTitle());
			cnt++;
		}
		if(cnt==1) {
			System.out.println("[게시글이 없습니다]");
			return;
		}
		System.out.print("확인할 게시글 번호 ");
		int sel = Util.getInt(1, boardList.size());
		System.out.println(boardList.get(sel-1));
	}

}
