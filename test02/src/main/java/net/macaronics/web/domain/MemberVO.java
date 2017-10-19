package net.macaronics.web.domain;

import java.sql.Timestamp;
import java.util.Date;

public class MemberVO {
	private int mid;
	private String userid ; 
	private String userpw ; 
	private String username;
	private String email ;
	private int upoint;
    private Timestamp regdate; 
    private Timestamp updatedate;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUpoint() {
		return upoint;
	}
	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", userid=" + userid + ", userpw=" + userpw + ", username=" + username
				+ ", email=" + email + ", upoint=" + upoint + ", regdate=" + regdate + ", updatedate=" + updatedate
				+ "]";
	}
    
	
    
    
}
