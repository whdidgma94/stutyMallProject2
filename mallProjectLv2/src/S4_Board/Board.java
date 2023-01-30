package S4_Board;

public class Board {
	private String userName;
	private String title;
	private String content;
	
	
	public Board(String title, String content, String userName) {
		super();
		this.userName = userName;
		this.title = title;
		this.content = content;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "제목 : " + title + "       작성자 : " + userName + "\n" + content;
	}
}
