package net.macaronics.web.domain;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotBlank;


public class MemberVO {
	private int mid;
	
	@NotBlank
	@Size(min=4,max=20,message="아이디의 크기는 4에서 20 사이 여야합니다.")
    @Pattern(regexp = ".*(?=.{4,})(?=.*[\\d[a-z][A-Z]]{4,}).*", 
                    message = "최소 4 자리 / 알파벳 문자가 필요합니다.")
	private String userid ;
	
	@NotNull(message="비밀번호는 필수 입니다.")
	@Size(min=5, max=10, message="비밀번호는 5 - 10 자 사이 여야합니다.")
	private String userpw ;

	
	@NotBlank(message="이름은 필수 입니다.")
	@Pattern(regexp="^[ㄱ-ㅎ가-힣]*$", message="이름은 한글만 가능합니다.")
	private String username;
	
	private String userpwCheck;
	
	@NotBlank(message="이메일은 필수 입니다.")
	@Pattern(regexp="\\w+[@]\\w+\\.\\w+", message="이메일 형식에 맞지 않습니다.")
	private String email ;
	
	@NotBlank(message="포인트는 필수 입니다.")
	@Pattern(regexp="^[0-9]*$", message="양수만 가능합니다.")
	private String upoint;
	
    private Timestamp regdate; 
    private Timestamp updatedate;
    
    
    //비밀번호 체크
    public boolean passwordCheck(){  	
    	return userpw.equals(userpwCheck);
    }
    
    
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
	public String getUserpwCheck() {
		return userpwCheck;
	}
	public void setUserpwCheck(String userpwCheck) {
		this.userpwCheck = userpwCheck;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
	public String getUpoint() {
		return upoint;
	}
	public void setUpoint(String upoint) {
		this.upoint = upoint;
	}
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", userid=" + userid + ", userpw=" + userpw + ", username=" + username
				+ ", userpwCheck=" + userpwCheck + ", email=" + email + ", upoint=" + upoint + ", regdate=" + regdate
				+ ", updatedate=" + updatedate + "]";
	}
    
 
    
}




