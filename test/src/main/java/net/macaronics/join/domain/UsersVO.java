/**
* <pre>
* 1. 패키지명 : net.macaronics.web.domain
* 2. 타입명 : UsersVO.java
* 3. 작성일 : 2017. 12. 26. 오후 7:48:05
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package net.macaronics.join.domain;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class UsersVO {
	
	private int idx;   // 자동 증가 
	@NotBlank
	@Size(min=4, max=30, message="아이디의 크기는 4에서 20 사이여야 합니다.")
	@Pattern(regexp = ".*(?=.{4,})(?=.*[\\d[a-z][A-Z]]{4,}).*", 
            message = "최소 4 자리 / 알파벳 문자가 필요합니다.")
	private String username; // 아이디 unique
	
	@NotBlank(message="닉네임은 필수 입니다.")
	@Pattern(regexp="^[ㄱ-ㅎ가-힣]*$", message="이름은 한글만 가능합니다.")
	private String nickname; //닉네임
	
	@NotNull(message="비밀번호는 필수 입니다.")
	@Size(min=6, max=20, message="비밀번호는 6-20자 사이여야 합니다.")
	@Pattern(regexp="([0-9].*[!,@,#,^,&,*,(,)])|([!,@,#,^,&,*,(,)].*[0-9])",
					message="비밀번호는 숫자, 특수문자가 포함되어야 합니다.")
	private String password; //패스워드
	
	private String pwCheck;
	
	
	@NotBlank(message="이메일은 필수 입니다.")
	@Pattern(regexp="\\w+[@]\\w+\\.\\w+", message="이메일 형식에 맞지 않습니다.")
	private String email; //이메일
	
	private Integer enabled;  // 계정사용여부
	
	@NotBlank(message="포인트는 필수 입니다.")
	@Pattern(regexp="^[0-9]*$", message="양수만 가능합니다.")
	private String upoint;  // 포인트
	
	private Timestamp regdate; // 현재 날짜
	
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	//비밀번호 체크
	public boolean passwordCheck() {
		return password.equals(pwCheck);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPwCheck() {
		return pwCheck;
	}
	public void setPwCheck(String pwCheck) {
		this.pwCheck = pwCheck;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}	
	public String getUpoint() {
		return upoint;
	}
	public void setUpoint(String upoint) {
		this.upoint = upoint;
	}
	
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
	@Override
	public String toString() {
		return "UsersVO [idx=" + idx + ", username=" + username + ", nickname=" + nickname + ", password=" + password
				+ ", pwCheck=" + pwCheck + ", email=" + email + ", enabled=" + enabled + ", upoint=" + upoint
				+ ", regdate=" + regdate + "]";
	}
	
	
	
}
