package S1_Member;

import java.util.ArrayList;

public class Member {
	@Override
	public String toString() {
		return "아이디 : " + id + " \n    비밀번호 : " + pw + " \n    이름 : " + name+"\n";
	}
	private String id;
	private String pw;
	private String name;
	private int cash;
	private	ArrayList<String> buyList = new ArrayList<String>();
	public Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	public String getId() {
		return id;
	}

	public ArrayList<String> getBuyList() {
		return buyList;
	}
	public void setBuyList(ArrayList<String> buyList) {
		this.buyList = buyList;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	
}
