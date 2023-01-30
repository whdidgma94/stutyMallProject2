package S1_Member;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<Member> memberList = new ArrayList<Member>();
	
	public ArrayList<Member> getMemberList() {
		return memberList;
	}


	void addMember(Member member) {
		memberList.add(member);
	}
	
	String getCurrentMemberId(int idx) {
		return memberList.get(idx).getId();
	}
	
	boolean checkId(String id) {	
		for(Member member : memberList) {
			if(member.getId().equals(id)) {
				return true;
			}
		}		
		return false;
	}
	int login(String id , String pw) {
		int stat =-1;
		for(int i = 0 ; i < memberList.size();i++) {
			if(memberList.get(i).getId().equals(id)&&memberList.get(i).getPw().equals(pw)) {
				stat = i;
			}
		}	
		return stat;
	}
	public void setAdmin() {
		Member admin = new Member("ad","ad","관리자");
		memberList.add(admin);
	}
}
